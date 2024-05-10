package app.greatreadsfinal.services;

import app.greatreadsfinal.dtos.AuthorDto;
import app.greatreadsfinal.dtos.BooksDto;
import app.greatreadsfinal.dtos.GenreDto;
import app.greatreadsfinal.dtos.LanguagesDto;
import app.greatreadsfinal.entities.*;
import app.greatreadsfinal.entities.enums.BookStatus;
import app.greatreadsfinal.exceptions.DoesNotExistException;
import app.greatreadsfinal.mappers.BookMapper;
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
        Books book = bookMapper.mapToEntity(booksDto);
        if (booksDto.getCollections() != null && !booksDto.getCollections().isEmpty()) {
            Collection collection = booksDto.getCollections().stream()
                    .findFirst()
                    .map(collectionDto -> findOrCreateCollection(collectionDto.getName()))
                    .orElse(null);
            book.setCollection(collection);
        }
        Set<Genre> genres = findOrCreateGenres(booksDto.getGenres());
        Set<Language> languages = findOrCreateLanguages(booksDto.getLanguages());
        Set<Author> authors = findOrCreateAuthors(booksDto.getAuthors());

        book.setGenres(genres);
        book.setLanguages(languages);
        book.setAuthors(authors);
        book.setStatus(BookStatus.PENDING);

        bookRepo.save(book);
        notificationService.notifyAdmins(book);
    }

    private Collection findOrCreateCollection(String collectionName){
        return collectionRepo.findByCollectionName(collectionName)
                .orElseGet(() -> {
                    Collection newCollection = new Collection();
                    newCollection.setCollectionName(collectionName);
                    return collectionRepo.save(newCollection);
                });
    }

    private Set<Genre> findOrCreateGenres(Set<GenreDto> genreDtos) {
        return genreDtos.stream()
                .map(genreDto -> genreRepo.findByGenreName(genreDto.getGenreName())
                        .orElseGet(() -> {
                            Genre genre = new Genre();
                            genre.setGenreName(genreDto.getGenreName());
                            return genreRepo.save(genre);
                        }))
                .collect(Collectors.toSet());
    }
    private Set<Language> findOrCreateLanguages(Set<LanguagesDto> languageDtos) {
        return languageDtos.stream()
                .map(languageDto -> languageRepo.findByLanguageName(languageDto.getLanguageName())
                        .orElseGet(() -> {
                            Language language = new Language();
                            language.setLanguageName(languageDto.getLanguageName());
                            return languageRepo.save(language);
                        }))
                .collect(Collectors.toSet());
    }
    private Set<Author> findOrCreateAuthors(Set<AuthorDto> authorDtos) {
        return authorDtos.stream()
                .map(authorDto -> authorRepo.findAuthorByFirstNameAndLastName(authorDto.getFirstName(), authorDto.getLastName())
                        .orElseGet(() -> {
                            Author author = new Author();
                            author.setFirstName(authorDto.getFirstName());
                            author.setLastName(authorDto.getLastName());
                            userDetailsRepo.findByFirstNameAndLastName(authorDto.getFirstName(), authorDto.getLastName())
                                    .ifPresent(userDetails -> {
                                        author.setFirstName(userDetails.getFirstName());
                                        author.setLastName(userDetails.getLastName());
                                    });
                            return authorRepo.save(author);
                        }))
                .collect(Collectors.toSet());
    }

    public void updateBook(Long bookId, BooksDto bookDto) {
        Books book = bookRepo.findById(bookId)
                .orElseThrow(() -> new DoesNotExistException("Book not found with id " + bookId));

        updateSimpleFields(book, bookDto);
        updateGenres(book, bookDto);
        updateLanguages(book, bookDto);
        updateCollection(book, bookDto);
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
    private void updateCollection(Books book, BooksDto bookDto) {
        if (bookDto.getCollections() != null && !bookDto.getCollections().isEmpty()) {
            Collection collection = bookDto.getCollections().stream()
                    .findFirst()
                    .map(collectionDto -> collectionRepo.findByCollectionName(collectionDto.getName())
                            .orElseGet(() -> {
                                Collection newCollection = new Collection();
                                newCollection.setCollectionName(collectionDto.getName());
                                return collectionRepo.save(newCollection);
                            }))
                    .orElse(null);

            book.setCollection(collection);
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

}
