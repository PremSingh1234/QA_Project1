package com.qa.TestForCustomer;

import static org.junit.Assert.assertEquals; 

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.CustomerServices.CsutomerService;
import com.qa.customer.CustomerCreateSystem;
import com.qa.domain.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTester {

	/**
	 *  The thing I want to fake functionality for is each customer, item and order so i can see whats wrong without it affecting my original code
	 */
	@Mock
	private CsutomerService customerService;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private CustomerCreateSystem customerCreateSystem;

	/**
	 * This will test if it can read all my customers in the database
	 */
	@Test
	public void readAllTest() {
		CustomerCreateSystem customerCreateSystem = new CustomerCreateSystem(customerService);
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("John"));
		customers.add(new Customer("james"));
		customers.add(new Customer("Ben"));
		customers.add(new Customer("Kevin"));
		Mockito.when(customerService.readAll()).thenReturn(customers);
		assertEquals(customers, customerCreateSystem.readAll());
	}

	/**
	 * This will test if it can create a customer in the database
	 */
	@Test
	public void createTest() {
		String name = "John";
		Mockito.doReturn(name).when(customerCreateSystem).getInput();
		Customer customer = new Customer(name);
		Customer savedCustomer = new Customer(1L, "John");
		Mockito.when(customerService.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerCreateSystem.create());
	}

	/**
	 * This will test if it can update a customer in the database
	 */
	@Test
	public void updateTest() {
		String id = "1";
		String name = "John";
		Mockito.doReturn(id, name).when(customerCreateSystem).getInput();
		Customer customer = new Customer(1L, name);
		Mockito.when(customerService.update(customer)).thenReturn(customer);
		assertEquals(customer, customerCreateSystem.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerCreateSystem).getInput();
		customerCreateSystem.delete();
		Mockito.verify(customerService, Mockito.times(1)).delete(1L);
	}
	
}
