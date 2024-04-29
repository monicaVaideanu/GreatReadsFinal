package app.greatreadsfinal.entities;

import app.greatreadsfinal.entities.enums.BookStatus;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @NotNull
    private Set<Genre> genres;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_language",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'PENDING'")
    private BookStatus status;

    private String filePath;

    @Column
    private Long adminId;

    @Nullable
    @OneToOne
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @ManyToMany(mappedBy = "publishedBooks", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Author> authors;
}
