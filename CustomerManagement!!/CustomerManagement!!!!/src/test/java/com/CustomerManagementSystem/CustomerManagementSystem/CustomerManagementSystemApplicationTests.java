package com.CustomerManagementSystem.CustomerManagementSystem;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.CustomerManagementSystem.entities.CommunicationAddress;
import com.CustomerManagementSystem.entities.Customer;
import com.CustomerManagementSystem.entities.PermanentAddress;
import com.CustomerManagementSystem.repository.CustomerRepository;

@SpringBootTest
class CustomerManagementSystemApplicationTests {

	 @Autowired
	    private CustomerRepository cr;

	    
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer("John", "Doe", null, 'M', 25, "MBA",
			 new PermanentAddress(1, "Main St", "Near Park", "City1", "State1", 12345),
				new CommunicationAddress(2, "2nd St", "Near School", "City1", "State1", 12345), "sdfghfd");
				cr.save(customer);
		assertNotNull(cr.findById(19).get());
	}

}
