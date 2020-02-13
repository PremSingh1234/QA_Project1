package com.qa.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.databases.Dao;
import com.qa.domain.Order;

public class MysqlOrderDao implements Dao<Order> {
public static final Logger LOGGER = Logger.getLogger(MysqlOrderDao.class);
	
	private String jdbcConnectionUrl;
	private String username;
	private String password;
	
	public MysqlOrderDao(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.189.111.39:3306/IMS";
		this.username = username;
		this.password = password;
	}
	
	public MysqlOrderDao(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}
	
	Order orderFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long customersId = resultSet.getLong("customers_id");
		return new Order(orderId, customersId);
	}

	@Override
	public List<Order> readAll() {
		try (Connection connection = DriverManager
				.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders" + ";")) {
			ArrayList<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(orderFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1" + ";")) {
			resultSet.next();
			return orderFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order create(Order order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orders(order_id, customers_id) values('" + order.getOrderId()+ "','" + order.getCustomersId()+"')" + ";");
			
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	return null;
	}

	public Order readOrder(Order order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where order_id = "+order+";")) {
			resultSet.next();
			return orderFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Order update(Order order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update orders set order_id ='" + order.getOrderId() +";" + "' where customers_id ='" + order.getCustomersId() + ";");
			return readOrder(order);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from orders where order_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
}