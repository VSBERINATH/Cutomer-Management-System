package com.CustomerManagementSystem.CustomerManagementSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.CustomerManagementSystem.controller.CustomerController;
import com.CustomerManagementSystem.entities.CommunicationAddress;
import com.CustomerManagementSystem.entities.Customer;
import com.CustomerManagementSystem.entities.PermanentAddress;
import com.CustomerManagementSystem.exception.ResourceNotFoundException;
import com.CustomerManagementSystem.service.CustomerService;
public class CustomerControllerTestcase {

	@Mock
	private CustomerService customerService;

	@InjectMocks
	private CustomerController customerController;

	private Customer testCustomer;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		PermanentAddress pa = new PermanentAddress(1, "2nd Main Road", "Benson Town", "Bangalore", "Karnataka", 560046);
		CommunicationAddress ca = new CommunicationAddress(3, "3rd Cross Road", "Marathahalli", "Bangalore", "Karnataka", 560037);
		testCustomer = new Customer("Test", "User", "TU",'M', 25, "BE", pa, ca, "Test Notes");
		testCustomer.setAge(18);
	}

	@Test
	void testAddCustomer() {
		when(customerService.addCustomer(testCustomer)).thenReturn("Customer added successfully");
		ResponseEntity<String> response = customerController.addCsutomer(testCustomer);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("Customer added successfully", response.getBody());
	}

	@Test
	void testGetCustomer() throws ResourceNotFoundException {
		when(customerService.getCustomer(1)).thenReturn(testCustomer);
		ResponseEntity<Customer> response = customerController.getCustomer(1);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(testCustomer, response.getBody());
	}

	@Test
	void testGetAllCustomers() {
		List<Customer> expectedCustomersList = new ArrayList<>();
		expectedCustomersList.add(testCustomer);

		when(customerService.getAllCustomer()).thenReturn(expectedCustomersList);

		ResponseEntity<List<Customer>> response = customerController.getAllCustomers();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedCustomersList, response.getBody());
	}

	@Test
	void testUpdateCustomer() {
		when(customerService.updateCustomer(testCustomer)).thenReturn("Customer updated successfully");
		ResponseEntity<String> response = customerController.updateCustomer(testCustomer);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("Customer updated successfully", response.getBody());
	}

	@Test
	void testDeleteCustomer() {
		when(customerService.deleteCustomer(2)).thenReturn("Customer deleted successfully");
		ResponseEntity<String> response = customerController.deleteCustomer(2);
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
		assertEquals("Customer deleted successfully", response.getBody());
	}


}
