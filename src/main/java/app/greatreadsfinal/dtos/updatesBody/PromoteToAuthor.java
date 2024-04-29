package app.greatreadsfinal.dtos.updatesBody;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromoteToAuthor {
    private String description;
    private String country;
}