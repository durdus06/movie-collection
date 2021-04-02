package durdu.projects.moviecollection.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import durdu.projects.moviecollection.exception.MovieNotFoundException;
import durdu.projects.moviecollection.model.Genre;
import durdu.projects.moviecollection.model.Movie;
import durdu.projects.moviecollection.service.GenreService;
import durdu.projects.moviecollection.service.LanguageService;
import durdu.projects.moviecollection.service.MovieService;
import durdu.projects.moviecollection.util.FileUploadUtility;
import durdu.projects.moviecollection.validator.MovieValidator;

@Controller
public class ManagementController {
	@Autowired
	private GenreService genreService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private LanguageService languageService;
 
	
	@GetMapping("/add/movie")
	public String showAddMovie(@ModelAttribute ("movie") Movie movie, Model model) {
	  model.addAttribute("allLanguages",  languageService.getAllLanguages());	
	  return "addMovie";
	}

	@PostMapping("/add/movie")
	public String handleMovieSubmission(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		// Validate the form when create a new movie or choose a file.
		if (movie.getId() == 0  || (!movie.getFile().getOriginalFilename().equals(""))) {
			new MovieValidator().validate(movie, bindingResult);
		}
		
		if (bindingResult.hasErrors()) {
			return "addMovie";
		} else {
			
			movieService.handleMovieSubmission(movie);

			if (!movie.getFile().getOriginalFilename().equals("")) {
				FileUploadUtility.uploadFile(movie.getFile(), movie.getCode());
			}
			redirectAttributes.addFlashAttribute("message", "Movie Submitted Successfully.");
			return "redirect:/show/movie/"+ movie.getId();
		}
	}
	
	@GetMapping("/edit/movie/{id}")
	public String editMovie(@PathVariable("id") int movieId, Model model) throws MovieNotFoundException {
		Movie movie = movieService.getMovieById(movieId);
		
		model.addAttribute("allLanguages",  languageService.getAllLanguages());	
		model.addAttribute("movie", movie);
		return "addMovie";
		
	}
	
	

	@GetMapping("/delete/movie/{id}")
	public String deleteMovie(@PathVariable ("id") int movieId,  Model model) {
		movieService.deleteMovieById(movieId);
		
		return "redirect:/show/all/movies";
	}
	
	@PostMapping("/add/cast")
	public String addCast(@ModelAttribute("movie") Movie movie) {
		  
		movieService.addCast(movie);
		return "addMovie :: crew";
	}
	@PostMapping("/remove/cast")
	public String removeCast(Movie movie, @RequestParam("removeDynamicRow") int castIndex) {
		movieService.removeCast(movie,castIndex);
		return "addMovie :: crew";
	}
	
	@PostMapping("/add/genre")
	public String handleCategorySubmission(@ModelAttribute Genre genre) {
		// add the new genre
		genreService.addGenre(genre);
		return "redirect:/add/movie";
	}
	
	@ModelAttribute("genres")
	public List<Genre> getAllGenres(){
		return genreService.getAllGenres();
	}
	
	
	@ModelAttribute("genre")
	public Genre getGenre() {
		return new Genre();
	}
	@ModelAttribute("title")
	public String getTitle() {
		return "Add Movie";
	}
}