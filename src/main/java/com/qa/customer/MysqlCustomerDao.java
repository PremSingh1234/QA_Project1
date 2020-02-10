package com.qa.customer;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qa.controller.Action;
import com.qa.controller.CrudController;
import com.qa.controller.CustomerController;
import com.qa.databases.Dao;
import com.qa.persistence.dao.CustomerDaoMysql;
import com.qa.persistence.domain.Domain;
import com.qa.services.CustomerServices;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class MysqlCustomerDao implements Dao<Customer> {
	private Connection connection;
	
	public MysqlCustomerDao() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://35.189.111.39/IMS","root","Iamlegend123");
		}
	
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Customers");
			while (resultSet.next()) {
				Long customerId = resultSet.getLong("Customers_ID");
				String name = resultSet.getString("name");
				Customer customer = new Customer(customerId, name);
				customers.add(customer);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return customers;
		
	}
	
	public void create(Customer customer) {
		public void imsSystem() {
			LOGGER.info("What is your username");
			Config.username = Utils.getInput();
			LOGGER.info("What is your password");
			Config.password = Utils.getInput();
			
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();
			
			Domain domain = Domain.getDomain();
			LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

			Action.printActions();
			Action action = Action.getAction();
			
			switch (domain) {
			case CUSTOMER:
				CustomerController customerController = new CustomerController(new CustomerServices(new CustomerDaoMysql()));
				doAction(customerController, action);
			case ITEM:
				break;
			case ORDER:
				break;
			case STOP:
				break;
			}
			
		}
		
		public void doAction(CrudController<?> crudController, Action action) {
			switch (action) {
			case CREATE:
				crudController.create();
				break;
			case READ:
				crudController.readAll();
				break;
			case UPDATE:
				crudController.update();
				break;
			case DELETE:
				crudController.delete();
				break;
			case RETURN:
				break;
			}
		}
	} 
	
	public void update(Customer customer) {
		
		
	}
	
	public void delete(int id) {
		
	}

}