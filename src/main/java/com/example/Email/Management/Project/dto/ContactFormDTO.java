/**
 * 
 */
package com.example.Email.Management.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactFormDTO {

		String name;
		String email;
		String subject;
		String message;

}