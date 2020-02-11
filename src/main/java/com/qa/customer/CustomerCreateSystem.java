package com.qa.customer;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.CustomerServices.CrudForService;
import com.qa.domain.Customer;
import com.qa.utils.Utils;

public class CustomerCreateSystem implements CrudForCustomer<Customer> {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerCreateSystem.class);
	
	private CrudForService<Customer> customerService;
	
	public CustomerCreateSystem(CrudForService<Customer> customerService) {
		this.customerService = customerService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	@Override
	public List<Customer> readAll() {
		List<Customer> customers = customerService.readAll();
		for(Customer customer: customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}
		
		
	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name");
		String name = Utils.getInput();
		Customer customer = customerService.create(new Customer(name));
		LOGGER.info("customer created");
		return customer;
	}

	@Override
	public Customer update() {
		return null;
		
	}

	@Override
	public void delete() {
		
	}

}