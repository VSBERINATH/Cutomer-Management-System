package com.CustomerManagementSystem;

import java.util.List;

import com.CustomerManagementSystem.entities.Customer;
import com.CustomerManagementSystem.exception.ResourceNotFoundException;

public interface CustomerServiceImpl {

	public String addCustomer(Customer customer);

	public Customer getCustomer(int id) throws ResourceNotFoundException;
	
	public List<Customer> getAllCustomer();
	
	public String deleteCustomer(int id);


	String updateCustomer(int id, Customer updatedCustomer) throws ResourceNotFoundException;

//	String updateCustomer(Customer C);




}
