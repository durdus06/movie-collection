package durdu.projects.moviecollection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import durdu.projects.moviecollection.model.Movie;
import durdu.projects.moviecollection.service.MovieService;

@RestController
@RequestMapping("/json")
public class JsonController {
	
	@Autowired
	private MovieService movieService;
	
	
	@GetMapping("/all/movies")
	public List<Movie> getAllMovies(){
		return movieService.listAllMovies();
	}
	
	@GetMapping("/genre/{id}/movies")
	public List<Movie> getMoviesByGenreId(@PathVariable("id") int genreId){
		return movieService.listMoviesByGenreId(genreId);
	}
	
	
}
