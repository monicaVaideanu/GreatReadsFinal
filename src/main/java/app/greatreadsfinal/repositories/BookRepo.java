package app.greatreadsfinal.repositories;

import app.greatreadsfinal.entities.Books;
import app.greatreadsfinal.entities.Collection;
import app.greatreadsfinal.entities.enums.BookStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Books, Long> {
    List<Books> findByAuthors_AuthorId(Long authorId);
    List<Books> findByGenres_GenreId(Long genreId);
    List<Books> findByLanguages_LanguageId(Long languageId);

    List<Books> findBooksByCollection(Collection collection);
    @Query("SELECT b FROM Books b WHERE b.avrRating IS NOT NULL ORDER BY b.avrRating DESC")
    List<Books> findTopRatedBooks(Pageable pageable);

    Page<Books> findByStatusAndAvrRatingGreaterThanEqual(BookStatus status, double ratingThreshold, Pageable pageable);
}
