package com.rpete.gamesgenres.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.rpete.gamesgenres.models.User;
import com.rpete.gamesgenres.repositories.UserRepository;


@Service
public class UserService {
	private static UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User create(User registerUser) {
		String hashed = BCrypt.hashpw(registerUser.getPassword(), BCrypt.gensalt());
		registerUser.setPassword(hashed);
		return userRepo.save(registerUser);
	}
	
	public User getUser(String email) {
		Optional<User> potentialUser = userRepo.findByEmail(email);
		return potentialUser.isPresent() ? potentialUser.get() : null;
	}
}
