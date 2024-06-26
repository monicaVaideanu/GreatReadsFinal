package app.greatreadsfinal.controllers;

import app.greatreadsfinal.dtos.WishReadListDto;
import app.greatreadsfinal.entities.WishReadList;
import app.greatreadsfinal.entities.enums.Wish;
import app.greatreadsfinal.services.WishReadListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books/list")
@CrossOrigin(origins = "http://localhost:3000")
public class WishReadListController {
    WishReadListService service;
    @Autowired
    public WishReadListController(WishReadListService service){
        this.service = service;
    }
    @PostMapping("/addBook") //TODO IN FE
    @PreAuthorize("@authenticateUserService.hasId(#wishDto.userId)")
    public ResponseEntity<String> saveBook(@Valid @RequestBody WishReadListDto wishDto) {
        service.saveWishReadList(wishDto);
        return ResponseEntity.ok("Book added to wish list.");
    }
    @PostMapping("/updateStatus") //done in fe
    @PreAuthorize("@authenticateUserService.hasId(#userId)")
    public ResponseEntity<String> updateStatus(@Valid @RequestParam Wish wish, @RequestParam Long userId,
                                               @RequestParam Long bookId){
        service.updateStatus(wish,userId,bookId);
        return ResponseEntity.ok("Status updated.");
    }
    @DeleteMapping("delete/{userId}/{bookId}") //done in fe
    @PreAuthorize("@authenticateUserService.hasId(#userId)")
    public ResponseEntity<?> deleteWishReadList(@PathVariable Long userId, @PathVariable Long bookId) {
        service.deleteWishReadList(userId, bookId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/user/{userId}/all") //done in fe
    @PreAuthorize("@authenticateUserService.hasId(#userId)")
    public ResponseEntity<?> deleteAllWishReadListsByUserId(@PathVariable Long userId) {
        service.deleteAllWishReadListsByUserId(userId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/user/{userId}") //TODO IS DONE IN FE, STH WRONG WITH DB FOR AUTHORS.
    @PreAuthorize("@authenticateUserService.hasId(#userId)")
    public ResponseEntity<List<WishReadList>> getWishReadListsByUserId(@PathVariable Long userId) {
        List<WishReadList> wishReadLists = service.findWishReadListsByUserId(userId);
        return ResponseEntity.ok(wishReadLists);
    }
}
