package app.greatreadsfinal.repositories;

import app.greatreadsfinal.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    List<Author> findByCountry(String country);
    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);
}
