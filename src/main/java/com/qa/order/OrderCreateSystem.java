package com.qa.order;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.domain.Order;
import com.qa.orderService.CrudForOrderService;
import com.qa.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderCreateSystem implements CrudForOrder<Order> {
	
	public static final Logger LOGGER = Logger.getLogger(OrderCreateSystem.class);
	
	private CrudForOrderService<Order> orderService;
	
	public OrderCreateSystem(CrudForOrderService<Order> orderService) {
		this.orderService = orderService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for(Order order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}
		
	/**
	 * Creates a customer by taking in user input
	 */		
	@Override
	public Order create() {
		LOGGER.info("Please enter a order_id you would like");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter a customer_id you would like");
		Long customerId = Long.valueOf(getInput());
		Order order = orderService.create(new Order(orderId, customerId));
		LOGGER.info("Order Created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the order_id of the order you would like to update");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter a customer_id");
		Long customerId = Long.valueOf(getInput()); 
		Order order = orderService.update(new Order(orderId, customerId));
		LOGGER.info("Order Updated");
		return order;
		
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = Long.valueOf(getInput());
		orderService.delete(id);
		LOGGER.info("Order Deleted");
	}

}