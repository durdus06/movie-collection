package durdu.projects.moviecollection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import durdu.projects.moviecollection.model.User;

public interface UserRepository  extends JpaRepository<User, Integer> {
   
	Optional<User> findUserByEmail(String email);
	
}
