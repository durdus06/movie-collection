package durdu.projects.moviecollection.service;

import java.util.List;

import durdu.projects.moviecollection.exception.GenreNotFoundException;
import durdu.projects.moviecollection.model.Genre;


public interface GenreService {
	 List<Genre> getAllGenres();
	 void addGenre(Genre genre);
	 Genre getGenre(int genreId) throws GenreNotFoundException;

}
