package app.greatreadsfinal.services;

import app.greatreadsfinal.entities.UserD;
import app.greatreadsfinal.repositories.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticateUserService { //todo do not delete this.
    @Autowired
    private UserDetailsRepo userDetailsRepo;
    public boolean hasId(Long id) {
        System.out.println("entered hasId from AuthenticateUserService");
        var username =  SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<UserD> user = userDetailsRepo.findByUsername(username);
        return user
                .map(u -> u.getUserDetailsId().equals(id))
                .orElse(false);
    }
}
