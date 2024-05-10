package app.greatreadsfinal.entities;

import app.greatreadsfinal.entities.enums.Role;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@Entity
@Table(name = "user_details", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username")
})
@Data
public class UserD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userDetailsId;
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Nullable
    private String middleName;

    @ToString.Exclude
    private String password;

    @ColumnDefault(" 'READER' ")
    @Enumerated(EnumType.STRING)
    private Role role;

    @PrePersist
    void prePersist() {
        if (this.role == null) {
            this.role = Role.READER;
        }
    }

    @OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
    private Author authorProfile;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}
