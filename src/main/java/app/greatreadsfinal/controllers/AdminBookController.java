package app.greatreadsfinal.controllers;

import app.greatreadsfinal.dtos.CollectionDto;
import app.greatreadsfinal.dtos.GenreDto;
import app.greatreadsfinal.services.BookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminBookController {

    @Autowired
    private BookManagementService bookManagementService;
    @PostMapping("/accept/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> acceptBook(@PathVariable Long bookId) {
        bookManagementService.acceptBook(bookId);
        return ResponseEntity.ok("Book accepted");
    }

    @PostMapping("/reject/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> rejectBook(@PathVariable Long bookId) {
        bookManagementService.rejectBook(bookId);
        return ResponseEntity.ok("Book rejected");
    }
    @PostMapping("/addGenre")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addGenre(@RequestBody GenreDto genreDto) {
        bookManagementService.addGenre(genreDto);
        return ResponseEntity.ok("Genre: " + genreDto.getGenreName() + " added.");
    }

    @PostMapping("/addCollection")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addGenre(@RequestBody CollectionDto collectionDto) {
        bookManagementService.addCollection(collectionDto);
        return ResponseEntity.ok("Collection: " + collectionDto.getName() + " added.");
    }
}
