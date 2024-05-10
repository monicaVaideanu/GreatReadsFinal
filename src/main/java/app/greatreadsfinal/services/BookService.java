package app.greatreadsfinal.services;

import app.greatreadsfinal.dtos.BooksDto;
import app.greatreadsfinal.entities.Books;
import app.greatreadsfinal.entities.Collection;
import app.greatreadsfinal.entities.Genre;
import app.greatreadsfinal.entities.Language;
import app.greatreadsfinal.exceptions.DoesNotExistException;
import app.greatreadsfinal.mappers.BookMapper;
import app.greatreadsfinal.repositories.BookRepo;
import app.greatreadsfinal.repositories.CollectionRepo;
import app.greatreadsfinal.repositories.GenreRepo;
import app.greatreadsfinal.repositories.LanguageRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepo bookRepo;
    private BookMapper bookMapper;
    private CollectionRepo collectionRepo;
    private GenreRepo genreRepo;
    private LanguageRepo languageRepo;

    @Transactional
    public void deleteBook(Long bookId) {
        if (!bookRepo.existsById(bookId)) {
            throw new DoesNotExistException("Book not found with id " + bookId);
        }
        bookRepo.deleteById(bookId);
    }

    public List<BooksDto> getBooksByAuthor(Long authorId) {
        return bookRepo.findByAuthors_AuthorId(authorId).stream().map(bookMapper::mapToDTO).collect(Collectors.toList());
    }

    public BooksDto getBook(Long bookId) {
        return bookMapper.mapToDTO(bookRepo.findById(bookId)
                .orElseThrow(() -> new DoesNotExistException("Book not found with id " + bookId)));
    }

    public Optional<Books> getBookForDownload(Long bookId) {
        return bookRepo.findById(bookId)
                .filter(Books::getAvailableToDownload);
    }

    public Optional<byte[]> getBookPdfContent(Long bookId) {
        return bookRepo.findById(bookId)
                .map(Books::getPdfContent);
    }

    public List<String> getGenres() {
        List<Genre> genres = genreRepo.findAll();
        return genres
                .stream()
                .map(Genre::getGenreName)
                .toList();
    }

    public List<String> getLanguages() {
        return languageRepo.findAll()
                .stream()
                .map(Language::getLanguageName)
                .toList();

    }

    public List<String> getCollections() {
        List<Collection> collections = collectionRepo.findAll();
        collections.forEach(collection -> {
            System.out.println("Collection ID: " + collection.getCollectionId() + ", Name: " + collection.getCollectionName());
        });
        return collections.stream()
                .map(Collection::getCollectionName)
                .collect(Collectors.toList());
    }

}
