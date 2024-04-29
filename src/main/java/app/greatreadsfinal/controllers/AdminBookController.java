package app.greatreadsfinal.controllers;

import app.greatreadsfinal.services.BookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminBookController {

    @Autowired
    private BookManagementService bookManagementService;
    @PostMapping("/accept/{bookId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> acceptBook(@PathVariable Long bookId) {
        bookManagementService.acceptBook(bookId);
        return ResponseEntity.ok("Book accepted");
    }

    @PostMapping("/reject/{bookId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> rejectBook(@PathVariable Long bookId) {
        bookManagementService.rejectBook(bookId);
        return ResponseEntity.ok("Book rejected");
    }
}
