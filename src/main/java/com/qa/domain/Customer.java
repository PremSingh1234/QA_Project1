package com.qa.domain;

public class Customer {
	private Long customers_id;
	private String name;
	
	public Customer(String name) {
		this.name = name;
	}
	
	public Customer(Long customers_id, String name) {
		this.customers_id = customers_id;
		this.name = name;
		
	}
	
	public Long getcustomers_id() {
		return customers_id;
	}

	public void setcustomers_ic(Long customers_ic) {
		this.customers_id = customers_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((customers_id == null) ? 0 : customers_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (customers_id == null) {
			if (other.customers_id != null)
				return false;
		} else if (!customers_id.equals(other.customers_id))
			return false;
		return true;
	}
	
}