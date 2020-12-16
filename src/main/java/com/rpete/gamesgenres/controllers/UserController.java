package com.rpete.gamesgenres.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rpete.gamesgenres.models.LoginUser;
import com.rpete.gamesgenres.models.User;
import com.rpete.gamesgenres.services.UserService;


@Controller
public class UserController {
	
	private static UserService userServ;
	
	public UserController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@GetMapping("/sign_in")
	public String signIn(Model model) {
		model.addAttribute("registerUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "sign_in.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registerUser") User registerUser, Model model, BindingResult result) {
		System.out.println("TESTJDJKLFJDSFDKSFJDSLKA");
		if (!registerUser.getPassword().equals(registerUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Match", "Confirm Password must match Password!");
		}
		if (userServ.getUser(registerUser.getEmail()) != null) {
			result.rejectValue("email", "Unique", "Email already in use!");
		}
		System.out.println("TESTJDJKLFJDSFDKSFJDSLKA 2");
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "sign_in.jsp";
		} else {
			userServ.create(registerUser);
			return "redirect:/sign_in";
		}
		
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, Model model, BindingResult result) {
		
		if (result.hasErrors()) {
			model.addAttribute("registerUser", new User());
			return "sign_in.jsp";
		} else {
			return "redirect:/sign_in";
		}
	}
}
