package app.greatreadsfinal.repositories;

import app.greatreadsfinal.entities.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectionRepo extends JpaRepository<Collection, Long> {
    Optional<Collection> findByCollectionId(Long collectionId);

    Optional<Collection> findByCollectionName(String collectionName);
}
