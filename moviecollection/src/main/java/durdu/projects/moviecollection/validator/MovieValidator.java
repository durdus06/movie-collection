package durdu.projects.moviecollection.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import durdu.projects.moviecollection.model.Movie;

public class MovieValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Movie.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Movie movie = (Movie) target;

		// check whether file has been selected or not
		if (movie.getFile() == null || movie.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select an image file to upload!");
			return;
		}

		if (!(movie.getFile().getContentType().equals("image/jpeg")
				|| movie.getFile().getContentType().equals("image/png")
				|| movie.getFile().getContentType().equals("image/gif"))) {
			errors.rejectValue("file", null, "Please use only image file for upload!");
			return;
		}

	}

}