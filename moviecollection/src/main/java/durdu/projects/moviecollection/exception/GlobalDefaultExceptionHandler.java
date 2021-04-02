package durdu.projects.moviecollection.exception;


import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler  {


	
	@ExceptionHandler(MovieNotFoundException.class)
	public String handlerMovieNotFoundException(Model model) {
		
		model.addAttribute("errorTitle", "Movie is not available");
		model.addAttribute("errorDescription","The movie you are looking for is not available right now!");
		model.addAttribute("title", "Movie Unavailable");
		return "error";
	}
	
	@ExceptionHandler(GenreNotFoundException.class)
	public String handlerGenreNotFoundException(Model model) {
		
		model.addAttribute("errorTitle", "Genre is not available");
		model.addAttribute("errorDescription","The genre you are looking for is not available!");
		model.addAttribute("title", "Genre Unavailable");
		return "error";
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handlerException(Exception ex, Model model) {
		
		model.addAttribute("errorTitle", "Contact Your Administrator!");
		/*Only for debugging the application */
		StringWriter sw = new StringWriter();
		PrintWriter pw= new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		model.addAttribute("errorDescription", sw.toString());
		
		model.addAttribute("title", "Error");
		return "error";
	}
}
