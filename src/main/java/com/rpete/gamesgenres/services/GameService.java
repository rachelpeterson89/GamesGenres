package com.rpete.gamesgenres.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.rpete.gamesgenres.models.Game;
import com.rpete.gamesgenres.models.Genre;
import com.rpete.gamesgenres.repositories.GameRepository;
import com.rpete.gamesgenres.repositories.GenreRepository;


@Service
public class GameService {

	private static GameRepository gameRepo;
	private static GenreRepository genreRepo;
	
	public GameService(GameRepository gameRepo, GenreRepository genreRepo) {
		this.gameRepo = gameRepo;
		this.genreRepo = genreRepo;
	}
	
	public Game create(Game newGame) {
		return gameRepo.save(newGame);
	}
	
	public Genre create(Genre newGenre) {
		return genreRepo.save(newGenre);
	}
	
	public List<Genre> getGenres() {
		return (List<Genre>) genreRepo.findAll();
	}
	
	public List<Game> getGames() {
		return (List<Game>) gameRepo.findAll();
	}
	
	public Genre getGenre(Long id) {
		Optional<Genre> genre = genreRepo.findById(id);
		return genre.isPresent() ? genre.get() : null;
	}
	
	public Game getGame(Long id) {
		Optional<Game> game = gameRepo.findById(id);
		return game.isPresent() ? game.get() : null;
	}
	
	public Game saveGame(Game game) {
		return gameRepo.save(game);
	}
}
