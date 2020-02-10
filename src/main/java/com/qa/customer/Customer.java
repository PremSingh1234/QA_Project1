package com.qa.customer;

public class Customer {
	private Long Customers_ID;
	private String name;
	
	public Customer(Long Customers_ID, String name) {
		this.Customers_ID = Customers_ID;
		this.name = name;
	
	}

	public Long getCustomers_ID() {
		return Customers_ID;
	}

	public void setCustomers_ID(Long customers_ID) {
		Customers_ID = customers_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}