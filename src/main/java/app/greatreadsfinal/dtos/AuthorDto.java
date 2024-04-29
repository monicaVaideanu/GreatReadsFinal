package app.greatreadsfinal.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {
    private String firstName;
    @NotBlank(message = "Last name cannot be blank.")
    private String lastName;

    private String description;
    private String country;
}
