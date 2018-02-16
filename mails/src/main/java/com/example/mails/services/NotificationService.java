package com.example.mails.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.mails.domain.User;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;
    
    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
    public void sendNotification(User user) throws MailException{
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmailAddress());
        mail.setFrom("fedeschaefer@gmail.com");
        mail.setSubject("Asunto");
        mail.setText("Body");
        
        javaMailSender.send(mail);
    }
}
