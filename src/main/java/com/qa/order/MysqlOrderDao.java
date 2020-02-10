package com.qa.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qa.databases.Dao;

public class MysqlOrderDao implements Dao<Order> {
	private Connection connection;
	
	public MysqlOrderDao() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://35.189.111.39/IMS","root","Iamlegend123");
		}
	
	public ArrayList<Order> readAll() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Orders");
			while (resultSet.next()) {
				Long orderId = resultSet.getLong("Order_ID");
				Long customerId = resultSet.getLong("Customers_ID");
				Long qty = resultSet.getLong("Qty");
				String item = resultSet.getString("item");
				Long itemPrice = resultSet.getLong("price_per_item");
				Order order = new Order(orderId, customerId, qty, item, itemPrice);
				orders.add(order);
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return orders;
		
	}	

	public void create(Order order) {
		
	}
	


	public void update(Order order) {
	
		}

	public void delete(int id) {
		
		}
	
}