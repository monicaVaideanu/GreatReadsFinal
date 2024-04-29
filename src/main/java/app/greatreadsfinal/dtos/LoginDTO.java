package app.greatreadsfinal.dtos;

import lombok.*;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDTO {
    String username;
    String password;
}
