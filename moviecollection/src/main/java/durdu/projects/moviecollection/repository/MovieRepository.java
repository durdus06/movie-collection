package durdu.projects.moviecollection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import durdu.projects.moviecollection.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	@Query("FROM Movie") 
	List<Movie> getAllMovies();
	@Query("FROM Movie WHERE genre_id = :genreId")
	List<Movie> getMoviesByGenreId( @Param("genreId") int genreId);
}
