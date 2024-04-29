package app.greatreadsfinal.services;

import app.greatreadsfinal.dtos.BooksDto;
import app.greatreadsfinal.entities.Books;
import app.greatreadsfinal.entities.Collection;
import app.greatreadsfinal.exceptions.DoesNotExistException;
import app.greatreadsfinal.mappers.BookMapper;
import app.greatreadsfinal.repositories.BookRepo;
import app.greatreadsfinal.repositories.CollectionRepo;
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

    public void deleteBook(Long bookId) {
        if (!bookRepo.existsById(bookId)) {
            throw new DoesNotExistException("Book not found with id " + bookId);
        }
        bookRepo.deleteById(bookId);
    }

    public List<BooksDto> getBooksByAuthor(Long authorId) {
        return bookRepo.findByAuthors_AuthorId(authorId).stream().map(bookMapper::mapToDTO).collect(Collectors.toList());
    }

    public List<BooksDto> getBooksByGenre(Long genreId) {
        return bookRepo.findByGenres_GenreId(genreId)
                .stream()
                .map(bookMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<BooksDto> getBooksByLanguage(Long languageId) {
        return bookRepo.findByLanguages_LanguageId(languageId)
                .stream()
                .map(bookMapper::mapToDTO)
                .collect(Collectors.toList());
    }


    public List<BooksDto> getBooksByCollection(Long collectionId) {
        Optional<Collection> collection = collectionRepo.findById(collectionId);
        return collection
                .map(c -> bookRepo.findBooksByCollection(c)
                        .stream()
                        .map(book -> bookMapper.mapToDTO(book))
                        .collect(Collectors.toList()))
                .orElseGet(List::of);
    }

    public BooksDto getBook(Long bookId) {
        return bookMapper.mapToDTO(bookRepo.findById(bookId)
                .orElseThrow(() -> new DoesNotExistException("Book not found with id " + bookId)));
    }
    public Optional<Books> getBookForDownload(Long bookId) { //TODO
        return bookRepo.findById(bookId)
                .filter(Books::getAvailableToDownload);
    }
    public Optional<byte[]> getBookPdfContent(Long bookId) {
        return bookRepo.findById(bookId)
                .map(Books::getPdfContent);
    }
}
