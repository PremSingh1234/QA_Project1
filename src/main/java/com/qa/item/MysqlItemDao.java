package com.qa.item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qa.databases.Dao;

public class MysqlItemDao implements Dao<Item> {
	private Connection connection;
	
	public MysqlItemDao() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://35.189.111.39/IMS","root","Iamlegend123");
		}
	
	public ArrayList<Item> readAll() {
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Items");
			while (resultSet.next()) {
				Long itemId = resultSet.getLong("Item_ID");
				Long orderId = resultSet.getLong("Order_ID");
				String itemName = resultSet.getString("name");
				Long itemPrice = resultSet.getLong("price_per_item");
				Item item = new Item(itemId, orderId, itemName, itemPrice);
				items.add(item);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return items;
		
	}	

	public void create(Item item) {
		
	}
	


	public void update(Item item) {
	
		}

	public void delete(int id) {
		
		}
	
}
