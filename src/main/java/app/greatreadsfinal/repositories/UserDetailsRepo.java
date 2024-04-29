package app.greatreadsfinal.repositories;

import app.greatreadsfinal.entities.UserD;
import app.greatreadsfinal.entities.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserD, Long> {
    Optional<UserD> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<UserD> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<UserD> findByUsernameAndPassword(String username, String password);
    Boolean existsByUsername(String username);
    Optional<UserD> findByUsername(String username);

    List<UserD> findByRole(Role role);
}
