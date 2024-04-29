package app.greatreadsfinal.repositories;

import app.greatreadsfinal.entities.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectionRepo extends JpaRepository<Collection, Long> {
    Optional<Collection> findById(Long id);

    Optional<Collection> findByName(String name);
}
