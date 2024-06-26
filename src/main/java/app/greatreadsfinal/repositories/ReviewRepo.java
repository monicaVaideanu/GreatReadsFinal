package app.greatreadsfinal.repositories;

import app.greatreadsfinal.entities.Review;
import app.greatreadsfinal.entities.composedId.ReviewComposedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, ReviewComposedId> {
    List<Review> findByReviewIdBookId(Long bookId);

   // List<Review> findByBookId(Long bookId);

}
