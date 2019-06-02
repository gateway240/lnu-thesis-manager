package se.lnu.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Example:
 * GmailSender gmail = new GmailSender("username", "password");
 * EmailService emailService = new EmailService(gmail.getJavaMailSender());
 * emailService.sendEmail("example@gmail.com", "Subject", "Message");
 */
public class EmailService {
    private JavaMailSender emailSender;

    public EmailService (JavaMailSender emailSender) {
    	this.emailSender = emailSender;
    }
    
    public void sendEmail(String recipient, String subject, String message) {
        SimpleMailMessage mail = new SimpleMailMessage(); 
        mail.setTo(recipient); 
        mail.setSubject(subject); 
        mail.setText(message);
        emailSender.send(mail);
    }
} 