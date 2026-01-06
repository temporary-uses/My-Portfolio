package com.example.Email.Management.Projectt.config.ResendConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.resend.Resend;

@Configuration
public class ResendConfig {
	
	@Bean
	public Resend resend(@Value("${RESEND_API_KEY}") String apikey) {
		return new Resend (apikey);
	}
}
