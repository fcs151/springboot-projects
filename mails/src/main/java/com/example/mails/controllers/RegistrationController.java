package com.example.mails.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mails.domain.User;
import com.example.mails.services.NotificationService;

@RestController
public class RegistrationController {
    
    private static final Logger logger = Logger.getLogger(RegistrationController.class);
    
    @Autowired
    private NotificationService notificationService;
    
    @RequestMapping("/signup")
    public String singup(){
        return "Please sign up for our service.";
    }
    
    @RequestMapping("/signup-success")
    public String singupSuccess(){
        
        logger.info("Entro"); 
        User user = new User();
        user.setFirstName("Fede");
        user.setLastName("Schaefer");
        user.setEmailAddress("federico.schaefer@santexgroup.com");
        
        try {
            notificationService.sendNotification(user);
        } catch(MailException e) {
            logger.info("Exception: " + e.getMessage()); 
        }
        return "Thank you for registering with us.";
    }
}
