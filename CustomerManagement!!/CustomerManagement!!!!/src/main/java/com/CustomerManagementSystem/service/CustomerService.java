package com.CustomerManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerManagementSystem.CustomerServiceImpl;
import com.CustomerManagementSystem.entities.CommunicationAddress;
import com.CustomerManagementSystem.entities.Customer;
import com.CustomerManagementSystem.entities.PermanentAddress;
import com.CustomerManagementSystem.exception.ResourceNotFoundException;
import com.CustomerManagementSystem.repository.CustomerRepository;

@Service
public class CustomerService  implements CustomerServiceImpl{
	
	@Autowired
	private CustomerRepository cr;
	
	@Override
	public List<Customer> getAllCustomer(){
		List<Customer> customersList = cr.findAll();
		return customersList;
	}
	
	@Override
	public String addCustomer (Customer C) {
		cr.save(C);
		return "success";
	}
	@Override
	public Customer getCustomer(int id) throws ResourceNotFoundException  {
		Customer customer= cr.findById(id).orElse(null);
		if(customer==null) {
			throw new ResourceNotFoundException("No customer found" + id);
		}
		return customer;
		}
	
	
	
	@Override
	public String updateCustomer (int id,Customer updatedCustomer) throws ResourceNotFoundException {
	Customer customer = cr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id)); 
	customer.setFirstName(updatedCustomer.getFirstName());
	customer.setLastName(updatedCustomer.getLastName());
	customer.setNickName(updatedCustomer.getNickName());
	customer.setSex(updatedCustomer.getSex());
	customer.setAge(updatedCustomer.getAge());
	customer.setQualification(updatedCustomer.getQualification());
	
	PermanentAddress pa = customer.getPa();
	pa.setHouseno(updatedCustomer.getPa().getHouseno());
	pa.setStreet(updatedCustomer.getPa().getStreet());
	pa.setLandmark(updatedCustomer.getPa().getLandmark());
	pa.setCity(updatedCustomer.getPa().getCity());
	pa.setState(updatedCustomer.getPa().getState());
	pa.setPin(updatedCustomer.getPa().getPin());
	
	CommunicationAddress ca = customer.getCa();
	ca.setHouseno(updatedCustomer.getCa().getHouseno());
	ca.setStreet(updatedCustomer.getCa().getStreet());
	ca.setLandmark(updatedCustomer.getCa().getLandmark());
	ca.setCity(updatedCustomer.getCa().getCity());
	ca.setState(updatedCustomer.getCa().getState());
	ca.setPin(updatedCustomer.getCa().getPin());
	customer.setNotes(updatedCustomer.getNotes());
	

	return "updated";
}
	
	@Override
	public String deleteCustomer(int id) {
		if(cr.existsById(id)) {
		cr.deleteById(id);	
		return "Deleted";
	}
		return "No records found";
	}
}
