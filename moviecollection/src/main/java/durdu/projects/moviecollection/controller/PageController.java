package durdu.projects.moviecollection.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import durdu.projects.moviecollection.exception.GenreNotFoundException;
import durdu.projects.moviecollection.exception.MovieNotFoundException;
import durdu.projects.moviecollection.model.Genre;
import durdu.projects.moviecollection.model.Movie;
import durdu.projects.moviecollection.service.GenreService;
import durdu.projects.moviecollection.service.MovieService;

@Controller
public class PageController {
	
	@Autowired
	private GenreService genreService;
	@Autowired
	private MovieService movieService;
	
	@GetMapping(value= {"/","/home"})
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/show/all/movies")
	public String showAllMovies(Model model) {
		model.addAttribute("title", "All Movies");
		return "listMovies";
	}
	
	@GetMapping(value="/show/genre/{id}/movies")
	public String showMoviesByCategory(@PathVariable("id") int genreId,Model model) throws GenreNotFoundException {
			Genre genre = genreService.getGenre(genreId);
			model.addAttribute("genre", genre);
			model.addAttribute("title", genre.getName());
			return "listMovies";
	}
	
	
	@GetMapping("show/movie/{id}")
	public String showSingleMovieDetails(@PathVariable("id")int movieId, Model model) throws MovieNotFoundException {
		Movie movie = movieService.getMovieById(movieId);
		model.addAttribute("title", movie.getName());
		model.addAttribute("movie",  movie);
		return "singleMovie";
	}
	
	@ModelAttribute("genres")
	public List<Genre> getAllGenres(){
		return genreService.getAllGenres();
	}
	
}