package com.qa.ims;

import org.apache.log4j.Logger;

import com.qa.CustomerServices.CsutomerService;
import com.qa.ItemService.ItemService;
import com.qa.customer.Actions;
import com.qa.customer.CrudForCustomer;
import com.qa.customer.CustomerCreateSystem;
import com.qa.customer.MysqlCustomerDao;
import com.qa.domain.TheDomain;
import com.qa.item.CrudForItem;
import com.qa.item.ItemCreateSystem;
import com.qa.item.MysqlItemDao;
import com.qa.order.CrudForOrder;
import com.qa.order.MysqlOrderDao;
import com.qa.order.OrderCreateSystem;
import com.qa.orderService.OrderService;
import com.qa.utils.Utils;

public class MyIms {

	public static final Logger LOGGER = Logger.getLogger(MyIms.class);

	public void imsSystem() {
		LOGGER.info("What is your username");
		String username = Utils.getInput();
		LOGGER.info("What is your password");
		String password = Utils.getInput();

		boolean looper = false;
		while (!looper) {
			LOGGER.info("Which entity would you like to use?");
			TheDomain.printTheDomains();
			TheDomain theDomain = TheDomain.getTheDomain();
			Actions actions = null;
			if (theDomain != TheDomain.STOP) {
				LOGGER.info("What would you like to do with " + theDomain.name().toLowerCase() + ":");
				Actions.printActions();
				actions = Actions.getActions();
			}
			switch (theDomain) {
			case CUSTOMER:
				CustomerCreateSystem customerCreateSyetem = new CustomerCreateSystem(
						new CsutomerService(new MysqlCustomerDao(username, password)));
				doActions(customerCreateSyetem, actions);
				break;
			case ITEM:
				ItemCreateSystem itemCreateSystem = new ItemCreateSystem(
						new ItemService(new MysqlItemDao(username, password)));
				doActionsItems(itemCreateSystem, actions);
				break;
			case ORDER:
				OrderCreateSystem orderCreateSystem = new OrderCreateSystem(
						new OrderService(new MysqlOrderDao(username, password)));
				doActionsOrders(orderCreateSystem, actions);
				break;
			case STOP:
				looper = true;
				break;
			}
		}
	}

	public void doActions(CrudForCustomer<?> crudForCustomer, Actions actions) {
		switch (actions) {
		case CREATE:
			crudForCustomer.create();
			break;
		case READ:
			crudForCustomer.readAll();
			break;
		case UPDATE:
			crudForCustomer.update();
			break;
		case DELETE:
			crudForCustomer.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}

	public void doActionsItems(CrudForItem<?> crudForItems, Actions actions) {
		switch (actions) {
		case CREATE:
			crudForItems.create();
			break;
		case READ:
			crudForItems.readAll();
			break;
		case UPDATE:
			crudForItems.update();
			break;
		case DELETE:
			crudForItems.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}

	}

	private void doActionsOrders(CrudForOrder<?> crudForOrder, Actions actions) {
		switch (actions) {
//		case CREATE:
//			crudForOrder.create();
//			break;
		case READ:
			crudForOrder.readAll();
			break;
//		case UPDATE:
//			crudForOrder.update();
//			break;
		case DELETE:
			crudForOrder.delete();
			break;
		case RETURN:
			break;
		default:
			break;

		}
	}
}
