package app.greatreadsfinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "collections", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collection_id")
    private Long collectionId;
    @Column(name = "name")
    private String collectionName;

    @OneToMany(mappedBy = "collection")
    @JsonBackReference
    private Set<Books> books;
}
