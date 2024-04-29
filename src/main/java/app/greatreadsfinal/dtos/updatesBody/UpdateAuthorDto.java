package app.greatreadsfinal.dtos.updatesBody;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAuthorDto {
    private String firstName;
    private String lastName;
    private String description;
    private String country;
}