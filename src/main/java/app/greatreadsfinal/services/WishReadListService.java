package app.greatreadsfinal.services;

import app.greatreadsfinal.dtos.WishReadListDto;
import app.greatreadsfinal.entities.WishReadList;
import app.greatreadsfinal.entities.composedId.ComposedId;
import app.greatreadsfinal.entities.enums.Wish;
import app.greatreadsfinal.exceptions.DoesNotExistException;
import app.greatreadsfinal.repositories.BookRepo;
import app.greatreadsfinal.repositories.UserDetailsRepo;
import app.greatreadsfinal.repositories.WishReadListRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WishReadListService {
    private final WishReadListRepo repository;
    private final UserDetailsRepo userRepository;
    private final BookRepo bookRepository;

    @Autowired
    public WishReadListService(WishReadListRepo repository, UserDetailsRepo userRepository, BookRepo bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.repository = repository;
    }

    public void saveWishReadList(WishReadListDto wishDto) {
        WishReadList wishReadList = new WishReadList();
        wishReadList.setUserId(userRepository.findById(wishDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found")));
        wishReadList.setBookId(bookRepository.findById(wishDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found")));

        if (wishDto.getWish() != null) {
            wishReadList.setWish(wishDto.getWish());
        }

        repository.save(wishReadList);
    }

    @Transactional
    public void updateStatus(Wish wish, Long userId, Long bookId) {
        ComposedId composedId = new ComposedId(userId,bookId);
        WishReadList wishReadList = repository.findById(composedId)
                .orElseThrow(()-> new DoesNotExistException("We could not find the book in the list."));
        updateWishStatus(wish, wishReadList);
    }

    private void updateWishStatus(Wish wish, WishReadList wishReadList) {
        switch (wish) {
            case READING:
                wishReadList.setStartReadingDate(LocalDateTime.now());
                wishReadList.setWish(Wish.READING);
                break;
            case DONE_READING:
                wishReadList.setEndReadingDate(LocalDateTime.now());
                wishReadList.setWish(Wish.DONE_READING);
                break;
            default:
                break;
        }
        repository.save(wishReadList);
    }

    public void deleteWishReadList(Long userId, Long bookId) {
        ComposedId id = new ComposedId(userId, bookId);
        WishReadList wishReadList = repository.findById(id)
                .orElseThrow(() -> new DoesNotExistException("WishList not found with given userId and bookId."));
        repository.delete(wishReadList);
    }

    public List<WishReadList> findWishReadListsByUserId(Long userId) {
        return repository.findByWishListId_UserId(userId)
                .orElseThrow(() -> new DoesNotExistException("WishList not found"));
    }

    public List<WishReadList> findWishReadListsByUserIdAndWish(Long userId, Wish wish) {
        return repository.findByWishListId_UserIdAndWish(userId, wish)
                .orElseThrow(() -> new DoesNotExistException("WishList not found"));
    }

    public void deleteAllWishReadListsByUserId(Long userId) {
        repository.deleteByWishListId_UserId(userId);
    }
}
