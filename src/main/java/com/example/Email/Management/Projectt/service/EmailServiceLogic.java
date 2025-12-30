package com.example.Email.Management.Projectt.service;

import org.springframework.stereotype.Service;

import com.example.Email.Management.Projectt.dto.ContactFormDTO;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender; // this is the original logic for this project 


//@MailSessionDefinition
//@MailSessionDefinitions
@Service

public class EmailServiceLogic{
	
	private final JavaMailSender javamailsender;
	
	@Value("${spring.mail.username}") // We add this to easily get your 'FROM' email from application.properties
	private String senderEmail;
	
	// 2. THE FIX: Constructor Injection
    // This method sets the final field, solving the error.
    public EmailServiceLogic(JavaMailSender javaMailSender) {
        // We assign the object received from Spring to your field.
        this.javamailsender = javaMailSender; 
    }
    
    public void sendContactEmail(ContactFormDTO data) {
    	SimpleMailMessage message = new SimpleMailMessage();
    	
    	message.setFrom(senderEmail);
    	
    	message.setTo("nandasanskar2233@gmail.com");
    	
    	String subject = String.format(" New Work : %s ", data.getSubject());
    	message.setSubject(subject);
    	
    	String body = String.format(
    			"Sender Name : %s \n Sender Email : %s  \n Message : %s",
    			data.getName(),
    			data.getEmail(),
    			data.getMessage()
    			);
    	message.setText(body);
    	// 3e. Dispatch the email using the final field
        this.javamailsender.send(message); // Now you can use the tool!
	}
    
}