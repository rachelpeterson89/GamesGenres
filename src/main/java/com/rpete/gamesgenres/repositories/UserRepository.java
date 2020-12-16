package com.rpete.gamesgenres.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rpete.gamesgenres.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	// lookup user based on email
	Optional<User> findByEmail(String email);
}
