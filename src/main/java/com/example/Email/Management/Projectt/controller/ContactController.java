package com.example.Email.Management.Projectt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Email.Management.Projectt.dto.ContactFormDTO;
import com.example.Email.Management.Projectt.service.EmailServiceLogic;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://my-portfolio-293.pages.dev/")
public class ContactController {
	
	private final EmailServiceLogic emailservice; // 1. Declare the Service Tool
	
	public ContactController( EmailServiceLogic emailService) {
		this.emailservice = emailService;
		
		// 2. Constructor Injection (The 'Hiring Interview')
	    // This connects the Controller to the Service
	}
	
	
	@PostMapping("/contact")
	public String handleContactForm(@RequestBody ContactFormDTO data) {
		//TODO: process POST request
		
		emailservice.sendContactEmail(data);
		
		return " Message Sent Suceessfully ";
	}
	
}
