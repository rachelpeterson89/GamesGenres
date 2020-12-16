package com.rpete.gamesgenres.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rpete.gamesgenres.models.Genre;


@Repository
public interface GenreRepository extends CrudRepository<Genre, Long>{

}
