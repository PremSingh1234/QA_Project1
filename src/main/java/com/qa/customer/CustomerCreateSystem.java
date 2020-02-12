package com.qa.customer;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.CustomerServices.CrudForService;
import com.qa.domain.Customer;
import com.qa.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerCreateSystem implements CrudForCustomer<Customer> {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerCreateSystem.class);
	
	private CrudForService<Customer> customerService;
	
	public CustomerCreateSystem(CrudForService<Customer> customerService) {
		this.customerService = customerService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Customer> readAll() {
		List<Customer> customers = customerService.readAll();
		for(Customer customer: customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}
	
	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name");
		String name = Utils.getInput();
		Customer customer = customerService.create(new Customer(name));
		LOGGER.info("customer created");
		return customer;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Customer update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a first name");
		String name = getInput();
		Customer customer = customerService.update(new Customer(id, name));
		LOGGER.info("Customer Updated");
		return customer;
		
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		customerService.delete(id);
		LOGGER.info("Customer Deleted");
	}

}