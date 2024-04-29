package app.greatreadsfinal.controllers;

import app.greatreadsfinal.dtos.BooksDto;
import app.greatreadsfinal.dtos.ReviewDto;
import app.greatreadsfinal.entities.Books;
import app.greatreadsfinal.services.BookManagementService;
import app.greatreadsfinal.services.BookService;
import app.greatreadsfinal.services.ReviewService;
import app.greatreadsfinal.services.TextModeratorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private BookManagementService bookManagementService;
    private BookService bookService;
    private ReviewService reviewService;
    private TextModeratorService textModerationService;

    @PostMapping(value = "/create", consumes = "multipart/form-data") //TODO ONLY THE AUTHOR OR ADMIN CAN DO THIS
    public ResponseEntity<String> createBook(
            @RequestPart("bookDto") BooksDto bookDto,
            @RequestPart(required = false) MultipartFile file
    ) {
        try {
            if (file != null && !file.isEmpty()) {
                bookDto.setPdfContent(file.getBytes());
            }
            bookManagementService.createBook(bookDto);
            return ResponseEntity.ok("Book created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error processing request: " + e.getMessage());
        }
    }

    @PatchMapping("/update/{bookId}") //TODO only an admin OR THE AUTHOR HIMSELF can DO this/
    public ResponseEntity<String> updateBook(@PathVariable Long bookId, @RequestBody BooksDto bookDto) {
        bookManagementService.updateBook(bookId, bookDto);
        return ResponseEntity.ok("Book updated successfully");
    }

    @DeleteMapping("/delete/{bookId}")//TODO only admin OR THE AUTHOR HIMSELF can delete
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Book deleted successfully");
    }

    @GetMapping("/rating/{bookId}")
    public ResponseEntity<String> getRatings(@PathVariable Long bookId) {
        Double averageRating = reviewService.getAverageRating(bookId); //todo change message
        return ResponseEntity.ok("Ratings retrieved for bookId: " + bookId + "is: " + averageRating);
    }

    @GetMapping("/byAuthor/{authorId}")
    public ResponseEntity<List<BooksDto>> getBooksByAuthor(@PathVariable Long authorId) {
        List<BooksDto> books = bookService.getBooksByAuthor(authorId);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/byGenre/{genreId}")
    public ResponseEntity<List<BooksDto>> getBooksByGenre(@PathVariable Long genreId) {
        List<BooksDto> books = bookService.getBooksByGenre(genreId);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/byLanguage/{languageId}")
    public ResponseEntity<List<BooksDto>> getBooksByLanguage(@PathVariable Long languageId) {
        List<BooksDto> books = bookService.getBooksByLanguage(languageId);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/byCollection/{collectionId}")
    public ResponseEntity<List<BooksDto>> getBooksByCollection(@PathVariable Long collectionId) {
        List<BooksDto> books = bookService.getBooksByCollection(collectionId);
        return ResponseEntity.ok(books);
    }

    @GetMapping("all")
    public ResponseEntity<List<BooksDto>> getAllBooks() {
        List<BooksDto> books = bookManagementService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BooksDto> getBook(@PathVariable Long bookId) {
        BooksDto book = bookService.getBook(bookId);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/{bookId}/addReview/{userId}") //TODO ONLY AN USER OR AN ADMIN CAN DO THIS
    public ResponseEntity<String> addReviewToBook(@PathVariable Long bookId, @PathVariable Long userId,
                                                  @RequestBody @Valid ReviewDto reviewDto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation error: " + result.getFieldError().getDefaultMessage());
        }

        if (reviewDto.getReviewText() != null && !textModerationService.isTextAppropriate(reviewDto.getReviewText())) {
            return ResponseEntity.badRequest().body("Review text contains inappropriate content");
        }

        reviewService.addReviewToBook(bookId, userId, reviewDto);
        return ResponseEntity.ok("Review added to book successfully");
    }

    @GetMapping("top10books")
    public ResponseEntity<List<Books>> getTopTen() {
        return ResponseEntity.ok(bookManagementService.getTop10RatedBooks());
    }
    //TODO ADD METHOD TO DELETE REVIEW BY THE USER WHO ADD IT AND ADMIN => ADMIN CAN DELETE ANY REVIEW (AUTHORIZATION)

    //TODO DOWNLOAD BOOK ON PC?
    @GetMapping("/download/{bookId}")
    public ResponseEntity<byte[]> downloadBook(@PathVariable Long bookId) {
        return bookService.getBookPdfContent(bookId)
                .map(data -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_PDF)
                        .header("Content-Disposition", "attachment; filename=\"book_" + bookId + ".pdf\"")
                        .body(data))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
