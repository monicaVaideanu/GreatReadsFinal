package app.greatreadsfinal.services;

import app.greatreadsfinal.dtos.*;
import app.greatreadsfinal.entities.*;
import app.greatreadsfinal.entities.enums.BookStatus;
import app.greatreadsfinal.exceptions.AlreadyExistsException;
import app.greatreadsfinal.exceptions.DoesNotExistException;
import app.greatreadsfinal.mappers.BookMapper;
import app.greatreadsfinal.mappers.GenreMapper;
import app.greatreadsfinal.repositories.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
@Service
@Slf4j
public class BookManagementService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private GenreRepo genreRepo;
    @Autowired
    private LanguageRepo languageRepo;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CollectionRepo collectionRepo;
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private UserDetailsRepo userDetailsRepo;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private GenreMapper genreMapper;
    public List<BooksDto> getAllBooks() {
        List<Books> books = bookRepo.findAll();

        books.forEach(book -> {
            System.out.println("Book: " + book.getName() + " has collection: " + (book.getCollection() != null ? book.getCollection().getCollectionName() : "null"));
        });

        return books
                .stream()
                .filter(book -> !book.getStatus().equals(BookStatus.PENDING))
                .map(bookMapper::mapToDTO)
                .collect(Collectors.toList());
    }
    @Transactional
    public void createBook(BooksDto booksDto){
        Books book = new Books();
        if (booksDto.getPdfContent() != null && booksDto.getPdfContent().length > 0) {
            System.out.println("BOOK PDF LENGTH: " + booksDto.getPdfContent().length);
            book.setPdfContent(booksDto.getPdfContent());
        }
        book = bookMapper.mapToEntity(booksDto);
        book.setStatus(BookStatus.PENDING);
        bookRepo.save(book);
        notificationService.notifyAdmins(book);
    }
    public void updateBook(Long bookId, BooksDto bookDto) {
        Books book = bookRepo.findById(bookId)
                .orElseThrow(() -> new DoesNotExistException("Book not found with id " + bookId));

        updateSimpleFields(book, bookDto);
        updateGenres(book, bookDto);
        updateLanguages(book, bookDto);
        updateAuthors(book, bookDto);
        bookRepo.save(book);
    }

    private void updateSimpleFields(Books book, BooksDto bookDto) {
        if (bookDto.getName() != null) book.setName(bookDto.getName());
        if (bookDto.getDescription() != null) book.setDescription(bookDto.getDescription());
        if (bookDto.getAvailableToDownload() != null) book.setAvailableToDownload(bookDto.getAvailableToDownload());
        if (bookDto.getPublisher() != null) book.setPublisher(bookDto.getPublisher());
        if (bookDto.getYearPublication() != null) book.setYearPublication(bookDto.getYearPublication());
    }

    private void updateGenres(Books book, BooksDto bookDto) {
        if (bookDto.getGenres() != null && !bookDto.getGenres().isEmpty()) {
            Set<Genre> genres = bookDto.getGenres().stream()
                    .map(genreName -> genreRepo.findByGenreName(genreName.getGenreName())
                            .orElseGet(() -> {
                                Genre newGenre = new Genre();
                                newGenre.setGenreName(genreName.getGenreName());
                                return genreRepo.save(newGenre);
                            }))
                    .collect(Collectors.toSet());
            book.setGenres(genres);
        }
    }

    private void updateLanguages(Books book, BooksDto bookDto) {
        if (bookDto.getLanguages() != null && !bookDto.getLanguages().isEmpty()) {
            Set<Language> languages = bookDto.getLanguages().stream()
                    .map(languageName -> languageRepo.findByLanguageName(languageName.getLanguageName())
                            .orElseGet(() -> {
                                Language newLanguage = new Language();
                                newLanguage.setLanguageName(languageName.getLanguageName());
                                return languageRepo.save(newLanguage);
                            }))
                    .collect(Collectors.toSet());
            book.setLanguages(languages);
        }
    }

    private void updateAuthors(Books book, BooksDto bookDto) {
        if (bookDto.getAuthors() != null && !bookDto.getAuthors().isEmpty()) {
            Set<Author> currentAuthors = book.getAuthors();

            Set<Author> newAuthors = bookDto.getAuthors().stream()
                    .map(authorDto -> authorRepo.findAuthorByFirstNameAndLastName(authorDto.getFirstName(),authorDto.getLastName())
                            .orElseThrow(() -> new RuntimeException("Author not found with Name: " + authorDto.getFirstName()+ " "+ authorDto.getLastName())))
                    .collect(Collectors.toSet());
            Set<Author> authorsToRemove = currentAuthors.stream()
                    .filter(author -> !newAuthors.contains(author))
                    .collect(Collectors.toSet());
            Set<Author> authorsToAdd = newAuthors.stream()
                    .filter(author -> !currentAuthors.contains(author))
                    .collect(Collectors.toSet());

            currentAuthors.removeAll(authorsToRemove);

            currentAuthors.addAll(authorsToAdd);
        } else {
            book.getAuthors().clear();
        }
    }

    public void acceptBook(Long bookId) {
        Books book = bookRepo.findById(bookId).orElseThrow(() -> new DoesNotExistException("Book not found"));
        book.setStatus(BookStatus.ACCEPTED);
        bookRepo.save(book);
    }

    public void rejectBook(Long bookId) {
        Books book = bookRepo.findById(bookId).orElseThrow(() -> new DoesNotExistException("Book not found"));
        bookRepo.delete(book);
    }
    public List<Books> getTop10RatedBooks() {
        Pageable topTen = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "avrRating"));
        return bookRepo.findByStatusAndAvrRatingGreaterThanEqual(BookStatus.ACCEPTED, 0, topTen).getContent();
    }

    public void addGenre(GenreDto genreDto) {
        try{
            genreRepo.save(genreMapper.mapToEntity(genreDto));
        } catch (Exception e) {
            throw new AlreadyExistsException("Genre already exists");
        }
    }

    public void addCollection(CollectionDto collectionDto) {
        Collection collection = new Collection();
        collection.setCollectionName(collectionDto.getName());
        try{
            collectionRepo.save(collection);
        } catch (Exception e) {
            throw new AlreadyExistsException("Collection already exists");
        }
    }

    public List<BooksDto> getAllPendingBooks() {
        List<Books> books = bookRepo.findAll();

        books.forEach(book -> {
            System.out.println("Book: " + book.getName() + " has collection: " + (book.getCollection() != null ? book.getCollection().getCollectionName() : "null"));
        });

        return books
                .stream()
                .filter(book -> book.getStatus().equals(BookStatus.PENDING))
                .map(bookMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}
