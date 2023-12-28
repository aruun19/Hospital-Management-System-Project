package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(DoctorIdNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(DoctorIdNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DoctorDataAlreadyAvailableFoundException.class)
	public ResponseEntity<String> exceptionHandler(DoctorDataAlreadyAvailableFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StaffIdNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(StaffIdNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StaffDataAlreadyAvailableFoundException.class)
	public ResponseEntity<String> exceptionHandler(StaffDataAlreadyAvailableFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PatientIdNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(PatientIdNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PatientDataAlreadyAvailableFoundException.class)
	public ResponseEntity<String> exceptionHandler(PatientDataAlreadyAvailableFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.BAD_REQUEST);
	}


}
