package app.greatreadsfinal.controllers;

import app.greatreadsfinal.dtos.AuthorDto;
import app.greatreadsfinal.dtos.BooksDto;
import app.greatreadsfinal.dtos.updatesBody.UpdateAuthorDto;
import app.greatreadsfinal.entities.Books;
import app.greatreadsfinal.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/add") // done in fe
    public ResponseEntity<String> createAuthor(@RequestBody AuthorDto authorDTO) {
        authorService.createAuthor(authorDTO);
        return new ResponseEntity<>("Created author.", HttpStatus.CREATED);
    }

    @PatchMapping ("update/{id}")
    @PreAuthorize("hasRole('ADMIN') or @authenticateUserService.isAuthorSelf(#id)")
    public ResponseEntity<String> updateAuthor(@PathVariable Long id, @RequestBody UpdateAuthorDto authorDTO) {
        authorService.updateAuthor(id, authorDTO);
        return ResponseEntity.ok("Updated successfully");
    }
    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasRole('ADMIN') or @authenticateUserService.isAuthorSelf(#id)")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Delete author successfully");
    }
    @GetMapping("/byCountry/{country}")
    public ResponseEntity<List<AuthorDto>> getAuthorByCountry(@PathVariable String country) {
        return ResponseEntity.ok(authorService.getAuthorsByCountry(country));
    }
    @GetMapping("/all") //done in fe
    public ResponseEntity<Iterable<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
    @GetMapping("/byBook/{bookId}")
    public ResponseEntity<Set<AuthorDto>> getAuthorsByBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(authorService.getAuthorsByBook(bookId));
    }
    @PostMapping("/{authorId}/addBook/{bookId}")
    @PreAuthorize("hasRole('ADMIN') or @authenticateUserService.isAuthorSelf(#id)")
    public ResponseEntity<String> addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        authorService.addBookToAuthor(authorId, bookId);
        return ResponseEntity.ok("Book added to author successfully");
    }
    @DeleteMapping("/{authorId}/removeBook/{bookId}")
    @PreAuthorize("hasRole('ADMIN') or @authenticateUserService.isAuthorSelf(#id)")
    public ResponseEntity<String> removeBookFromAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        authorService.removeBookFromAuthor(authorId, bookId);
        return ResponseEntity.ok("Book removed from author successfully");
    }
    @PostMapping("/classicAuthor")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createClassicAuthor(@RequestBody AuthorDto authorDto){
        authorService.createClassicAuthor(authorDto);
        return ResponseEntity.ok("Added a classic author");
    }
    @GetMapping("/{authorId}/published-books")
    public ResponseEntity<Set<BooksDto>> getAuthorPublishedBooks(@PathVariable Long authorId) {
        try {
            Set<BooksDto> publishedBooks = authorService.getPublishedBooksByAuthorId(authorId);
            return ResponseEntity.ok(publishedBooks);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
