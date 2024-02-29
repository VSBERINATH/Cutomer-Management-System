package com.CustomerManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.CustomerManagementSystem.entities.Customer;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Customer> resourceNotFoundExceptionHandler(ResourceNotFoundException Ex){
		String message=Ex.getMessage();
		Customer c=new Customer();
		return new ResponseEntity<Customer>(c,HttpStatus.NOT_FOUND);
	}
}
