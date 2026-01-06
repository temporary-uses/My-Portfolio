package com.example.Email.Management.Projectt.service;

import org.springframework.stereotype.Service;

import com.example.Email.Management.Projectt.dto.ContactFormDTO;
import com.resend.Resend;
import com.resend.core.exception.ResendException;

import org.springframework.beans.factory.annotation.Value;
import com.resend.services.emails.model.CreateEmailOptions;

// this is the original logic for this project 


//@MailSessionDefinition
//@MailSessionDefinitions
@Service

public class EmailServiceLogic{
	
	private final Resend resend;
	
	@Value("${RESEND_API_KEY}") // We add this to easily get your 'FROM' email from application.properties
	private String apikey;
	
	// 2. THE FIX: Constructor Injection
    // This method sets the final field, solving the error.
    public EmailServiceLogic(Resend rEsend) {
        // We assign the object received from Spring to your field.
        this.resend = rEsend; 
    }
    
    
    
    public void sendContactEmail(ContactFormDTO data) {
    	String body = String.format(
    			"""
                <h2>New Contact Message</h2>
                <p><strong>Name:</strong> %s</p>
                <p><strong>Email:</strong> %s</p>
                <p><strong>Message:</strong></p>
                <p>%s</p>
            """,
    			data.getName(),
    			data.getEmail(),
    			data.getMessage()
    			);
    	
    	String subject = String.format(" New Work : %s ", data.getSubject());
    	
    	
    	
    	CreateEmailOptions emailOptions = CreateEmailOptions.builder()

    	.from("onboarding@resend.dev")
    	
    	.to("teambca2023@gmail.com")
    	
    	.subject(subject)
    	
    	.html(body)
    	
    	// 3e. Dispatch the email using the final field
    	.build();
    	try {
    	resend.emails().send(emailOptions); // Now you can use the tool!
    	} catch (ResendException ex) {
    		throw new RuntimeException("Failed to send Email", ex);
    	}
	}
    
}