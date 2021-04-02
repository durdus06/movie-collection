package durdu.projects.moviecollection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import durdu.projects.moviecollection.exception.MovieNotFoundException;
import durdu.projects.moviecollection.model.Cast;
import durdu.projects.moviecollection.model.Movie;
import durdu.projects.moviecollection.repository.MovieRepository;
import durdu.projects.moviecollection.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieRepository movieRepository;
	
	
	public List<Movie> listAllMovies(){
		return movieRepository.findAll();
	}
	
	public List<Movie> listMoviesByGenreId(int genreId){
		return  movieRepository.getMoviesByGenreId(genreId);
	}
	public Movie getMovieById(int movieId) throws MovieNotFoundException {
		 
		return movieRepository.findById(movieId)
				.orElseThrow(() -> new MovieNotFoundException());
	}
	public void handleMovieSubmission(Movie movie) {
		//Set sequence number 
		int sequenceNumber=1;
		for (Cast cst : movie.getCastList()) {
			cst.setSequenceNumber(sequenceNumber);
			sequenceNumber++;
		}
		 
		movieRepository.save(movie);
	}
	
	public void deleteMovieById(int movieId) {
		movieRepository.deleteById(movieId);
	}
	
	
	public void addCast(Movie movie) {
		 movie.getCastList().add(new Cast());
	}
	public void removeCast(Movie movie, int castIndex) {
		movie.getCastList().remove(castIndex);
	}
	
}
