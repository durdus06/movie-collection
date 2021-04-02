package durdu.projects.moviecollection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import durdu.projects.moviecollection.model.Language;
import durdu.projects.moviecollection.repository.LanguageRepository;
import durdu.projects.moviecollection.service.LanguageService;
@Service
public class LanguageServiceImpl implements LanguageService {
	@Autowired
	private LanguageRepository languageRepository;
	
	public List<Language> getAllLanguages() {
		return languageRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

}
