package com.CustomerManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerManagementSystem.entities.Customer;
import com.CustomerManagementSystem.exception.ResourceNotFoundException;
import com.CustomerManagementSystem.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService cService;

	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCsutomer(@Valid @RequestBody  Customer customer) {
		String s = cService.addCustomer(customer);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) throws ResourceNotFoundException {
		Customer customer = cService.getCustomer(id);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers= cService.getAllCustomer();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer , @PathVariable int id) throws ResourceNotFoundException {
		String s = cService.updateCustomer( id, customer);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		String S=cService.deleteCustomer(id);
		return new ResponseEntity<>(S,HttpStatus.ACCEPTED);
	}
	
}
