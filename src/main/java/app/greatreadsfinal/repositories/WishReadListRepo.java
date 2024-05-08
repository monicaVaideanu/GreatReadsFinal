package app.greatreadsfinal.repositories;

import app.greatreadsfinal.dtos.WishListDtoForTable;
import app.greatreadsfinal.entities.WishReadList;
import app.greatreadsfinal.entities.composedId.ComposedId;
import app.greatreadsfinal.entities.enums.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishReadListRepo extends JpaRepository<WishReadList, ComposedId> {
    Optional<WishReadList> findById(ComposedId id);
    Optional<List<WishReadList>> findByWishListId_UserId(Long userId);
    Optional< List<WishReadList>> findByWishListId_UserIdAndWish(Long userId, Wish wish);

    void deleteByWishListId_UserId(Long userId);
}
