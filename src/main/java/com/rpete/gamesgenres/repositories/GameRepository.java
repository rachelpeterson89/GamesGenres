package com.rpete.gamesgenres.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rpete.gamesgenres.models.Game;


@Repository
public interface GameRepository extends CrudRepository<Game, Long>{

}
