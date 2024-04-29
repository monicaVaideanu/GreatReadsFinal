package app.greatreadsfinal.services;

import app.greatreadsfinal.dtos.ReviewDto;
import app.greatreadsfinal.entities.Books;
import app.greatreadsfinal.entities.Review;
import app.greatreadsfinal.entities.UserD;
import app.greatreadsfinal.entities.composedId.ReviewComposedId;
import app.greatreadsfinal.exceptions.AlreadyExistsException;
import app.greatreadsfinal.exceptions.DoesNotExistException;
import app.greatreadsfinal.repositories.BookRepo;
import app.greatreadsfinal.repositories.ReviewRepo;
import app.greatreadsfinal.repositories.UserDetailsRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final BookRepo bookRepo;
    private final UserDetailsRepo userDetailsRepo;
    @Autowired
    public ReviewService(ReviewRepo reviewRepo, BookRepo bookRepo, UserDetailsRepo userDetailsRepo) {
        this.reviewRepo = reviewRepo;
        this.bookRepo = bookRepo;
        this.userDetailsRepo = userDetailsRepo;
    }
    @Transactional
    public void addReviewToBook(Long userId, Long bookId, ReviewDto reviewDto) {
        Books book = bookRepo.findById(bookId)
                .orElseThrow(() -> new DoesNotExistException("Book not found with id " + bookId));
        UserD userD = userDetailsRepo.findById(userId)
                .orElseThrow(() -> new DoesNotExistException("User not found with id " + userId));
        ReviewComposedId reviewId = new ReviewComposedId(userId, bookId);
        if (reviewRepo.existsById(reviewId)) {
            throw new AlreadyExistsException("Review already exists for this book and user");
        }
        Review review = new Review();
        review.setUserId(userD);
        review.setBookId(book);
        review.setRating(reviewDto.getRating());
        review.setReviewText(reviewDto.getReviewText());
        reviewRepo.save(review);
    }
    public Double getAverageRating(Long bookId) {
        return reviewRepo.findByReviewIdBookId(bookId).stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
    }
}
