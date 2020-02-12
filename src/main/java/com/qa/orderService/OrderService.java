package com.qa.orderService;

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.databases.Dao;

public class OrderService implements CrudForOrderService<Order> {
	
Dao<Order> orderDao;
	
	public OrderService(Dao<Order> orderDao) {
		this.orderDao = orderDao;
	}

	public List<Order> readAll() {
		return orderDao.readAll();
	}

	public Order create(Order order) {
		return orderDao.create(order);
	}

	public Order update(Order order) {
		return orderDao.update(order);
	}

	public void delete(Long id) {
		orderDao.delete(id);
	}

}
