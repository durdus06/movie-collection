package durdu.projects.moviecollection.service;

import java.util.List;

import durdu.projects.moviecollection.exception.MovieNotFoundException;
import durdu.projects.moviecollection.model.Movie;

public interface MovieService  {
	 List<Movie> listAllMovies();
	 List<Movie> listMoviesByGenreId(int genreId);
	 Movie getMovieById(int movieId) throws MovieNotFoundException;
	 void handleMovieSubmission(Movie movie);
	 void deleteMovieById(int movieId);
	 void addCast(Movie movie);
	 void removeCast(Movie movie, int castIndex);
}
