package com.example.Email.Management.Projectt.service;

import org.springframework.stereotype.Service;

import com.example.Email.Management.Projectt.dto.ContactFormDTO;
import com.resend.Resend;

import org.springframework.beans.factory.annotation.Value;
import com.resend.services.emails.model.SendEmailRequest;

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
    	SendEmailRequest message = SendEmailRequest.builder(); // ' SimpleMailMessage ' comes from spring boot but ' CreateEmailOptions ' comes from the service provider 
    	
    	message.from(apikey);
    	
    	message.To("nandasanskar2233@gmail.com");
    	
    	String subject = String.format(" New Work : %s ", data.getSubject());
    	message.Subject(subject);
    	
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
    	message.html(body);
    	// 3e. Dispatch the email using the final field
    	message.build();
    	resend.emails().send(body); // Now you can use the tool!
	}
    
}