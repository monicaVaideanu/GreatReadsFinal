package app.greatreadsfinal.entities;

import app.greatreadsfinal.entities.composedId.ReviewComposedId;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Table(name = "reviews")
@Entity
public class Review {
    @EmbeddedId
    private ReviewComposedId reviewId = new ReviewComposedId();
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserD userId;
    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Books bookId;
    private Double rating;
    @Nullable
    private String reviewText;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime publishedDate = LocalDateTime.now();

}
