package app.greatreadsfinal.services;

import app.greatreadsfinal.entities.Books;
import app.greatreadsfinal.entities.UserD;
import app.greatreadsfinal.entities.enums.Role;
import app.greatreadsfinal.repositories.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserDetailsRepo userDetailsRepo;
    public void notifyAdmins(Books book) {
        List<UserD> admins = userDetailsRepo.findByRole(Role.ADMIN);
        for (UserD admin : admins) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(admin.getEmail());
            message.setSubject("New Book Pending Approval");
            message.setText("A new book titled '" + book.getName() + "' is pending approval.");
            try{
                mailSender.send(message);
            } catch (MailException e) {
                e.printStackTrace();
            }
        }
    }
}
