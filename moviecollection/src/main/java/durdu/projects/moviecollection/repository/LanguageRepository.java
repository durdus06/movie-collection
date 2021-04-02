package durdu.projects.moviecollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import durdu.projects.moviecollection.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{
}
