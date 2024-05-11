package app.greatreadsfinal.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    @NotNull
    @Positive
    @Max(value = 5)
    private Double rating;

    private LocalDateTime publishedDate;
    @Nullable
    private String reviewText;
    private Long bookId;
    private Long userId;
    private String username;
}


