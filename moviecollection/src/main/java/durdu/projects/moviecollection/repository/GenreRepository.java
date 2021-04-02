package durdu.projects.moviecollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import durdu.projects.moviecollection.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{
	
	
}
