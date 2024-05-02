package app.greatreadsfinal.services;

import app.greatreadsfinal.entities.UserD;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTService {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.accessTokenValiditityMS}")
    private int jwtExpirationMs;

    @Value("${jwt.cookieName}")
    private String jwtCookie;

    public ResponseCookie generateJwtCookie(UserD userPrincipal) {
        String jwt = generateTokenForUser(userPrincipal);
        return ResponseCookie.from(jwtCookie, jwt).maxAge(60 * 60).httpOnly(true).build();
    }

    public boolean validateJwtToken(String authToken) {
        System.out.println("entered validateJwtToken from JWTService");
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return false;
    }

    public String generateTokenForUser(UserD user) {
        System.out.println("entered generateTokenForUser from JWTService");
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }


    public String getEmailFromToken(String token) {
        System.out.println("Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject()  "+ Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject()) ;
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
}
