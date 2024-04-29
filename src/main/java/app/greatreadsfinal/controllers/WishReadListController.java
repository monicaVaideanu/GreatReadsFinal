package app.greatreadsfinal.controllers;

import app.greatreadsfinal.dtos.WishReadListDto;
import app.greatreadsfinal.entities.WishReadList;
import app.greatreadsfinal.entities.enums.Wish;
import app.greatreadsfinal.services.WishReadListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books/list")
public class WishReadListController {
    WishReadListService service;
    @Autowired
    public WishReadListController(WishReadListService service){
        this.service = service;
    }
    @PostMapping("/addBook") //TODO only THE USER HIMSELF can do this
    public ResponseEntity<String> saveBook(@Valid @RequestBody WishReadListDto wishDto) {
        service.saveWishReadList(wishDto);
        return ResponseEntity.ok("Book added to wish list.");
    }
    @PostMapping("/updateStatus") //TODO only THE USER HIMSELF can do this
    public ResponseEntity<String> updateStatus(@Valid @RequestParam Wish wish, @RequestParam Long userId,
                                               @RequestParam Long bookId){
        service.updateStatus(wish,userId,bookId);
        return ResponseEntity.ok("Status updated.");
    }
    @DeleteMapping("/{userId}/{bookId}")  //TODO only THE USER HIMSELF can do this
    public ResponseEntity<?> deleteWishReadList(@PathVariable Long userId, @PathVariable Long bookId) {
        service.deleteWishReadList(userId, bookId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/user/{userId}/all")  //TODO only THE USER HIMSELF can do this
    public ResponseEntity<?> deleteAllWishReadListsByUserId(@PathVariable Long userId) {
        service.deleteAllWishReadListsByUserId(userId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/user/{userId}") //TODO only THE USER HIMSELF can do this
    public ResponseEntity<List<WishReadList>> getWishReadListsByUserId(@PathVariable Long userId) {
        List<WishReadList> wishReadLists = service.findWishReadListsByUserId(userId);
        return ResponseEntity.ok(wishReadLists);
    }

    @GetMapping("/user/{userId}/status")  //TODO only THE USER HIMSELF can do this
    public ResponseEntity<List<WishReadList>> getWishReadListsByUserIdAndWish(
            @PathVariable Long userId,
            @RequestParam Wish wish) {
        List<WishReadList> wishReadLists = service.findWishReadListsByUserIdAndWish(userId, wish);
        return ResponseEntity.ok(wishReadLists);
    }
}
