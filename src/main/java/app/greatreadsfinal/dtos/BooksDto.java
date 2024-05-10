package app.greatreadsfinal.dtos;

import app.greatreadsfinal.entities.enums.BookStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksDto {
    @NotBlank(message = "Name cannot be blank.")
    private String name;
    @NotBlank(message = "Description cannot be blank.")
    private String description;
    @NotBlank(message = "Available to download cannot be blank.")
    private Boolean availableToDownload;
    @Past(message = "Year of publication cannot be in the future.")
    @NotBlank(message = "Year of publication cannot be blank.")
    private Year yearPublication;
    @NotBlank
    private String publisher;
    @NotBlank
    @Positive(message = "Average rating cannot be negative.")
    @Max(value = 5, message = "Average rating cannot be greater than 5.")
    private Double avrRating;
    private byte[] pdfContent;
    private BookStatus status;
    private Set<GenreDto> genres;
    private Set<LanguagesDto> languages;
    private Set<CollectionDto> collections;
    private Set<AuthorDto> authors;
    private Long bookId;
}
