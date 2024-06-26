package app.greatreadsfinal.controllers;

import app.greatreadsfinal.dtos.LoginDTO;
import app.greatreadsfinal.dtos.LoginResponse;
import app.greatreadsfinal.dtos.UserDetailsDto;
import app.greatreadsfinal.dtos.updatesBody.PromoteToAuthor;
import app.greatreadsfinal.dtos.updatesBody.UpdateUserDto;
import app.greatreadsfinal.exceptions.DoesNotExistException;
import app.greatreadsfinal.services.UserDService;
import jakarta.mail.AuthenticationFailedException;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserDService userService;

    @PostMapping("/create") //done in fe
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDetailsDto userDetails) {
        userService.saveUser(userDetails);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }
    @PostMapping("/login") //done in fe
    public ResponseEntity<LoginResponse> loginUser(@RequestBody @Valid LoginDTO loginDTO) throws AuthenticationFailedException {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PatchMapping("update/{userId}")
    @PreAuthorize("hasRole('ADMIN') or @authenticateUserService.hasId(#userId)")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody @Valid UpdateUserDto userDetails) {
        userService.updateUser(userId, userDetails);
        return ResponseEntity.ok("User updated");
    }
    @DeleteMapping("delete/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted");
    }
    @PostMapping("/{userId}/promoteToAuthor") //done in fe
    @PreAuthorize("hasRole('ADMIN') or @authenticateUserService.hasId(#userId)")
    public ResponseEntity<String> promoteToAuthor(@PathVariable Long userId, @RequestBody PromoteToAuthor authorDto) {
        try {
            userService.promoteToAuthor(userId, authorDto);
            return ResponseEntity.ok("User has been successfully promoted to author.");
        } catch (DoesNotExistException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
