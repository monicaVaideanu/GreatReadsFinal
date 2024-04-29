package app.greatreadsfinal.entities;

import app.greatreadsfinal.entities.composedId.ComposedId;
import app.greatreadsfinal.entities.enums.Wish;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "wish_read_list")
public class WishReadList {
    @EmbeddedId
    private ComposedId wishListId = new ComposedId();

    @OneToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserD userId;
    @OneToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Books bookId;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime addDate;

    @ColumnDefault("'WISH'")
    @Enumerated(EnumType.STRING)
    private Wish wish = Wish.WISH;

    @Nullable
    private LocalDateTime endReadingDate;

    @Nullable
    private LocalDateTime startReadingDate;
}
