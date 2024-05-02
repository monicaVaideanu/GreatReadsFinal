package app.greatreadsfinal.services;

import app.greatreadsfinal.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookSecurityService {
    @Autowired
    private BookRepo bookRepository;

    public boolean isBookAuthor(Long bookId, String username) {
        return bookRepository.findById(bookId)
                .map(book -> book.getAuthors().stream().anyMatch(author -> author.equals(username))
                )
                .orElse(false);
    }
}
