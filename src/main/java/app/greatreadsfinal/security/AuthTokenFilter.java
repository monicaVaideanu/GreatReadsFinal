package app.greatreadsfinal.security;

import app.greatreadsfinal.services.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        System.out.println("entered doFilterInternal from AuthTokenFilter");
        try {
            String jwt = parseJwt(request);

            if (jwt != null && jwtService.validateJwtToken(jwt)) {
                String email = jwtService.getEmailFromToken(jwt); //todo refactor
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                System.out.println("-------------------------------" + userDetails);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails,
                                null,
                                userDetails.getAuthorities());
                System.out.println("********************************" + authentication);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;");
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("999999999999999999999999");;
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {username}", e);
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        System.out.println("entered parseJwt from AuthTokenFilter");
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth)) {
            return headerAuth;
        }
        return null;
    }
}
