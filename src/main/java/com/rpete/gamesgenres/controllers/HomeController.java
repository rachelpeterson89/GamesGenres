package com.rpete.gamesgenres.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rpete.gamesgenres.models.Game;
import com.rpete.gamesgenres.models.Genre;
import com.rpete.gamesgenres.services.GameService;


@Controller
public class HomeController {
	
	private static GameService gameService;
	
	public HomeController(GameService gameService) {
		this.gameService = gameService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newGame", new Game());
		model.addAttribute("newGenre", new Genre());
		model.addAttribute("allGames", gameService.getGames());
		model.addAttribute("allGenres", gameService.getGenres());
		return "index.jsp";	
	}
	
	@PostMapping("/games")
	public String newGame(@Valid @ModelAttribute("newGame") Game newGame, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			gameService.create(newGame);
			return "redirect:/";
		}
	}
	
	@PostMapping("/genres")
	public String newGenre(@Valid @ModelAttribute("newGenre") Genre newGenre, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			gameService.create(newGenre);
			return "redirect:/";
		}
	}
	
	@PostMapping("/addGenreToGame")
	public String addGenreToGame(@RequestParam("game_id") Long gameId, @RequestParam("genre_id") Long genreId) {
		Game theGame = gameService.getGame(gameId);
		Genre theGenre = gameService.getGenre(genreId);
		List<Genre> gameGenres = theGame.getGenres();
		gameGenres.add(theGenre);
		gameService.saveGame(theGame);
		return "redirect:/";
	}
	
}
