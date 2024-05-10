package app.greatreadsfinal.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguagesDto {
    @NotBlank (message = "Code cannot be blank.")
    @Size(min = 2, max = 2)
    private String code;
    @NotBlank(message = "Name cannot be blank.")
    private String languageName;
}
