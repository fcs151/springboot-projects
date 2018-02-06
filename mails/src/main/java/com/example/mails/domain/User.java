package com.example.mails.domain;

import lombok.Data;

@Data
public class User {
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    
    public User(){
        
    }
    
}
