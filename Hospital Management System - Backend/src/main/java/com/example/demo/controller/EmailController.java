package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmailService;
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class EmailController 
{
	@Autowired
	private EmailService emailService;
	@RequestMapping("/send")

	public ResponseEntity<String> checkEmail()
	{
	emailService.sendEmail("bhargavpulipati357@gmail.com", "Confirmation!", "Dear Patient You  have registerd Successfully in Life Hospital");
	return new ResponseEntity<>("Message Send",HttpStatus.CREATED);
	}
	

}
