package app.greatreadsfinal.dtos;

import app.greatreadsfinal.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    String token;
    Long userId;
    String role;
}
