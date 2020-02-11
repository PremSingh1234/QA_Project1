package com.qa.CustomerServices;

import java.util.List;

import com.qa.databases.Dao;
import com.qa.domain.Customer;

public class CsutomerService implements CrudForService<Customer> {
	
	Dao<Customer> customerDao;
	
	public CsutomerService(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customer> readAll() {
		return customerDao.readAll();
	}

	public Customer create(Customer customer) {
		return customerDao.create(customer);
	}

	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}

	public void delete(Long id) {
		customerDao.delete(id);
	}

}
