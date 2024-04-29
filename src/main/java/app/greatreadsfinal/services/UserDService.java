package app.greatreadsfinal.services;

import app.greatreadsfinal.dtos.LoginDTO;
import app.greatreadsfinal.dtos.UserDetailsDto;
import app.greatreadsfinal.dtos.updatesBody.PromoteToAuthor;
import app.greatreadsfinal.dtos.updatesBody.UpdateUserDto;
import app.greatreadsfinal.entities.Author;
import app.greatreadsfinal.entities.UserD;
import app.greatreadsfinal.entities.enums.Role;
import app.greatreadsfinal.exceptions.AlreadyExistsException;
import app.greatreadsfinal.exceptions.DoesNotExistException;
import app.greatreadsfinal.mappers.AuthorMapper;
import app.greatreadsfinal.mappers.UserMapper;
import app.greatreadsfinal.repositories.AuthorRepo;
import app.greatreadsfinal.repositories.UserDetailsRepo;
import jakarta.mail.AuthenticationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserDService {

    @Autowired
    private UserDetailsRepo userDetailsRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    AuthorMapper authorMapper;
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTService jwtService;

    public void saveUser(UserDetailsDto user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        try {
            if (user.getRole() == null) {
                user.setRole(Role.READER);
            } else {
                Role role = Role.valueOf(user.getRole().name());
                user.setRole(role);
            }
            user.setPassword(encodedPassword);
            userDetailsRepository.save(userMapper.toEntity(user));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Provided role is invalid.");
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("User already exists");
        }
    }


    public String loginUser(LoginDTO loginDTO) throws AuthenticationFailedException {
        UserD user = userDetailsRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new DoesNotExistException("User doesn't exist"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new AuthenticationFailedException("Password mismatch");
        }
        return jwtService.generateTokenForUser(user);
    }


    public void updateUser(Long id, UpdateUserDto userDetails) {
        UserD user = userDetailsRepository.findById(id)
                .orElseThrow(() -> new DoesNotExistException("User doesn't exist"));

        if (user.getUsername().equals(userDetails.getUsername()) || userDetailsRepository.existsByUsername(userDetails.getUsername())) {
            throw new AlreadyExistsException("Username already in use.");
        }
        if (user.getEmail().equals(userDetails.getEmail()) || userDetailsRepository.existsByEmail(userDetails.getEmail())) {
            throw new AlreadyExistsException("Email already in use.");
        }

        if (userDetails.getFirstName() != null) {
            user.setFirstName(userDetails.getFirstName());
        }
        if (userDetails.getLastName() != null) {
            user.setLastName(userDetails.getLastName());
        }
        if (userDetails.getMiddleName() != null) {
            user.setMiddleName(userDetails.getMiddleName());
        }
        if (userDetails.getEmail() != null) {
            user.setEmail(userDetails.getEmail());
        }
        if (userDetails.getUsername() != null) {
            user.setUsername(userDetails.getUsername());
        }
        user.setUpdatedAt(LocalDateTime.now());

        userDetailsRepository.save(user);
    }

    public void deleteUser(Long id) {
        UserD user = userDetailsRepository.findById(id)
                .orElseThrow(() -> new DoesNotExistException("User doesn't exist"));
        userDetailsRepository.delete(user);
    }

    @Transactional
    public void promoteToAuthor(Long userId, PromoteToAuthor authorDto) {
        UserD user = userDetailsRepository.findById(userId)
                .orElseThrow(() -> new DoesNotExistException("User doesn't exist"));
        if (!user.getRole().equals(Role.READER)) {
            throw new IllegalArgumentException("User is not a reader or already an author.");
        }
        Author author = new Author();
        author.setFirstName(user.getFirstName());
        author.setLastName(user.getLastName());
        author.setMiddleName(user.getMiddleName());
        author.setUpdatedAt(LocalDateTime.now());
        author.setDescription(authorDto.getDescription());
        author.setCountry(authorDto.getCountry());
        author.setUserId(user);
        authorRepo.save(author);

        user.setRole(Role.AUTHOR);
        userDetailsRepository.save(user);
    }

    public void logoutUser() { //TODO add this
    }
}
