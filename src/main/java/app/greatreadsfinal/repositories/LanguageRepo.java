package app.greatreadsfinal.repositories;

import app.greatreadsfinal.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Long> {

    Optional<Language> findByLanguageName(String name);

    Long getLanguageIdByLanguageName(String name);
}
