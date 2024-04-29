package app.greatreadsfinal.controllers;

import app.greatreadsfinal.dtos.AuthorDto;
import app.greatreadsfinal.dtos.updatesBody.UpdateAuthorDto;
import app.greatreadsfinal.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity<String> createAuthor(@RequestBody AuthorDto authorDTO) {
        authorService.createAuthor(authorDTO);
        return new ResponseEntity<>("Created author.", HttpStatus.CREATED);
    }

    @PatchMapping ("update/{id}") //TODO only an admin OR THE AUTHOR HIMSELF can DO this
    public ResponseEntity<String> updateAuthor(@PathVariable Long id, @RequestBody UpdateAuthorDto authorDTO) {
        authorService.updateAuthor(id, authorDTO);
        return ResponseEntity.ok("Updated.");
    }
    @DeleteMapping("delete/{id}") //TODO only an admin OR THE AUTHOR HIMSELF can DO this
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("deletedAuthorDTO");
    }
    @GetMapping("/byCountry/{country}")
    public ResponseEntity<List<AuthorDto>> getAuthorByCountry(@PathVariable String country) {
        return ResponseEntity.ok(authorService.getAuthorsByCountry(country));
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
    @GetMapping("/byBook/{bookId}")
    public ResponseEntity<Set<AuthorDto>> getAuthorsByBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(authorService.getAuthorsByBook(bookId));
    }
    @PostMapping("/{authorId}/addBook/{bookId}") //TODO only an admin OR THE AUTHOR HIMSELF can DO this
    public ResponseEntity<String> addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        authorService.addBookToAuthor(authorId, bookId);
        return ResponseEntity.ok("Book added to author successfully");
    }
    @DeleteMapping("/{authorId}/removeBook/{bookId}")  //TODO only an admin OR THE AUTHOR HIMSELF can DO this
    public ResponseEntity<String> removeBookFromAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        authorService.removeBookFromAuthor(authorId, bookId);
        return ResponseEntity.ok("Book removed from author successfully");
    }
    @PostMapping("/classicauthor") //TODO only an admin can DO this
    public ResponseEntity<String> createClassicAuthor(@RequestBody AuthorDto authorDto){
        authorService.createClassicAuthor(authorDto);
        return ResponseEntity.ok("Added a classic author");
    }
}
