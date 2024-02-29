package com.CustomerManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerManagementSystem.entities.Customer;
import com.CustomerManagementSystem.exception.ResourceNotFoundException;
import com.CustomerManagementSystem.repository.CustomerRepository;

@Service
public class CustomerService  {
	
	@Autowired
	private CustomerRepository cr;
	
	
	//it will give list of all customers
	public List<Customer> getAllCustomer(){
		List<Customer> customersList = cr.findAll();
		return customersList;
	}
	
	
	//it will add a new customer
	public String addCustomer (Customer C) {
		cr.save(C);
		return "success";
	}
	
	//it finds for an id we give if it's found then return it or else throw a message not null
	public Customer getCustomer(int id) throws ResourceNotFoundException  {
		Customer customer= cr.findById(id).orElse(null);
		if(customer==null) {
			throw new ResourceNotFoundException("Customer ID" + id+ " Not Found");
		}
		return customer;
		}
	
	
	
	//here we will give the id to update if the id found then we'll update their details 
	// If not found throws a message not found
	public String updateCustomer (int id,Customer updatedCustomer) throws ResourceNotFoundException  {
		Customer customer=cr.findById(id).orElse(null);
		
		if(customer==null ) {
			throw new ResourceNotFoundException("There is no Customer With this id"+id+ "to update");
		}
		customer.setFirstName(updatedCustomer.getFirstName());
		customer.setLastName(updatedCustomer.getLastName());
		customer.setNickName(updatedCustomer.getNickName());
		customer.setSex(updatedCustomer.getSex());
		customer.setAge(updatedCustomer.getAge());
		customer.setQualification(updatedCustomer.getQualification());
		customer.setNotes(updatedCustomer.getNotes());
		
	
		 cr.save(updatedCustomer);

	return "updated";
}
	
	
	public String deleteCustomer(int id) {
		if(cr.existsById(id)) {
		cr.deleteById(id);	
		return "Customer ID"+id + " "+"Deleted";
	}
		return "There is no Customer With this id"+id+ "to Delete";
	}
}
