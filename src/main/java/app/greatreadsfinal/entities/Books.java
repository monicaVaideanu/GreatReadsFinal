package app.greatreadsfinal.entities;

import app.greatreadsfinal.entities.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.time.Year;
import java.util.Set;

@Entity
@Data
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    @NotNull
    private String name;

    private String description;
    @NotNull
    private Boolean availableToDownload;

    private Year yearPublication;

    private String publisher;
    @Check(constraints = "avrRating > 0.00 AND avrRating < 5.00")
    private Double avrRating;

    @Lob
    @Column(name="pdf_content", columnDefinition = "LONGBLOB")
    private byte[] pdfContent;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @NotNull
    private Set<Genre> genres;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_language",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    @NotNull
    private Set<Language> languages;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'PENDING'")
    private BookStatus status;

    private String filePath;

    @Column //TODO ADMIN ID WHEN A BOOK IS APPROVED
    private Long adminId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collection_id")
    @JsonManagedReference
    private Collection collection;

    @ManyToMany(mappedBy = "publishedBooks", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Author> authors;

}
