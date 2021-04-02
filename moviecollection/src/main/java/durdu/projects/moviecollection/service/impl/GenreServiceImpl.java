package durdu.projects.moviecollection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import durdu.projects.moviecollection.exception.GenreNotFoundException;
import durdu.projects.moviecollection.model.Genre;
import durdu.projects.moviecollection.repository.GenreRepository;
import durdu.projects.moviecollection.service.GenreService;
@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private GenreRepository genreRepository;
	
	
	public List<Genre> getAllGenres(){
		return genreRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}
	
	public void addGenre(Genre genre) {
		genreRepository.save(genre);
	}
	public Genre getGenre(int genreId) throws GenreNotFoundException {
		return genreRepository.findById(genreId)
				.orElseThrow(() -> new GenreNotFoundException());
	}

}
