package app.greatreadsfinal.services;

import app.greatreadsfinal.dtos.AuthorDto;
import app.greatreadsfinal.dtos.updatesBody.UpdateAuthorDto;
import app.greatreadsfinal.entities.Author;
import app.greatreadsfinal.exceptions.AlreadyExistsException;
import app.greatreadsfinal.exceptions.DoesNotExistException;
import app.greatreadsfinal.mappers.AuthorMapper;
import app.greatreadsfinal.repositories.AuthorRepo;
import app.greatreadsfinal.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepo authorRepository;
    private final AuthorMapper authorMapper;
    private final BookRepo bookRepository;

    @Autowired
    public AuthorService(AuthorRepo authorRepository, AuthorMapper authorMapper, BookRepo bookRepository) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.bookRepository = bookRepository;
    }

    public void createAuthor(AuthorDto authorDTO) {
        try {
            Author author = authorMapper.mapToEntity(authorDTO);
            Author savedAuthor = authorRepository.save(author);
            authorMapper.mapToDTO(savedAuthor);
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("Author already exists");
        }
    }

    public void updateAuthor(Long id, UpdateAuthorDto authorDetails) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new DoesNotExistException("Author not found with id " + id));

        if (authorDetails.getFirstName() != null) {
            author.setFirstName(authorDetails.getFirstName());
        }
        if (authorDetails.getLastName() != null) {
            author.setLastName(authorDetails.getLastName());
        }
        if (authorDetails.getDescription() != null) {
            author.setDescription(authorDetails.getDescription());
        }
        if (authorDetails.getCountry() != null) {
            author.setCountry(authorDetails.getCountry());
        }
        author.setUpdatedAt(LocalDateTime.now());
        authorRepository.save(author);
    }

    public List<AuthorDto> getAuthorsByCountry(String country) {
        List<Author> authors = authorRepository.findByCountry(country);
        if (authors.isEmpty()) {
            throw new DoesNotExistException("No authors found from country: " + country);
        }
        return authors.stream()
                .map(authorMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(authorMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new DoesNotExistException("Author not found with id " + id));
        authorRepository.delete(author);
    }

    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new DoesNotExistException("Author not found with id " + id));
        return authorMapper.mapToDTO(author);
    }

    public Set<AuthorDto> getAuthorsByBook(Long bookId) {
        return bookRepository.findById(bookId).map(book -> {
            return book.getAuthors().stream()
                    .map(authorMapper::mapToDTO)
                    .collect(Collectors.toSet());
        }).orElseThrow(() -> new DoesNotExistException("Book not found with id " + bookId));
    }
    public void addBookToAuthor(Long authorId, Long bookId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new DoesNotExistException("Author not found with id " + authorId));
        var book = bookRepository.findById(bookId)
                .orElseThrow(() -> new DoesNotExistException("Book not found with id " + bookId));

        author.getPublishedBooks().add(book);
        authorRepository.save(author);
    }

    public void removeBookFromAuthor(Long authorId, Long bookId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new DoesNotExistException("Author not found with id " + authorId));
        var book = bookRepository.findById(bookId)
                .orElseThrow(() -> new DoesNotExistException("Book not found with id " + bookId));

        author.getPublishedBooks().remove(book);
        authorRepository.save(author);
    }
    public void createClassicAuthor(AuthorDto authorDto){
        Author author = authorMapper.mapToEntity(authorDto);
        author.setUserId(null);
        authorRepository.save(author);
    }
}
