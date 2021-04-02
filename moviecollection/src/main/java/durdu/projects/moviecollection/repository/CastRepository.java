package durdu.projects.moviecollection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import durdu.projects.moviecollection.model.Cast;

public interface CastRepository extends JpaRepository<Cast, Integer> {
	@Query("FROM Cast WHERE movie_id = :movieId")
	List<Cast> getCastByMovieId(@Param("movieId") int movieId);
}
