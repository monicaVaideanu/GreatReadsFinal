package app.greatreadsfinal.dtos;

import app.greatreadsfinal.entities.enums.Role;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsDto {
    @NotBlank(message = "First name cannot be blank.")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank.")
    private String lastName;
    @Nullable
    private String middleName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String username;
    @NotBlank(message = "Password is required, 5-20 characters, at least one lowercase letter &  one uppercase, " +
            "one digit, and one special character")
    @Size(min = 5)
    @Size(max = 20)
    @Pattern(regexp = "^(?!.*(?i)password).*$")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).*")
    @Pattern(regexp = ".*\\d.*")
    @Pattern(regexp = ".*[@#$%^&+=;!].*")
    @Pattern(regexp = "^\\S*$")
    @ToString.Exclude
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
