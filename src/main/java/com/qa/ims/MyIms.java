package com.qa.ims;

import org.apache.log4j.Logger;

import com.qa.CustomerServices.CsutomerService;
import com.qa.customer.Actions;
import com.qa.customer.CrudForCustomer;
import com.qa.customer.CustomerCreateSystem;
import com.qa.customer.MysqlCustomerDao;
import com.qa.domain.TheDomain;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class MyIms {
	
	public static final Logger LOGGER = Logger.getLogger(MyIms.class);

	public void imsSystem() {
		LOGGER.info("What is your username");
		Config.username = Utils.getInput();
		LOGGER.info("What is your password");
		Config.password = Utils.getInput();
		
		LOGGER.info("Which entity would you like to use?");
		TheDomain.printTheDomains();
		
		TheDomain theDomain = TheDomain.getTheDomain();
		LOGGER.info("What would you like to do with " + theDomain.name().toLowerCase() + ":");
		
		Actions.printActions();
		Actions actions = Actions.getActions();
		
		switch (theDomain) {
		case CUSTOMER:
			CustomerCreateSystem customerCreateSystem = new CustomerCreateSystem(new CsutomerService(new MysqlCustomerDao(Config.username, Config.password)));
			doActions(customerCreateSystem, actions);
			break;
		case ITEM:
			break;
		case ORDER:
			break;
		case STOP:
			break;
		default:
			break;
		}
		
	}
	
	public void doActions(CrudForCustomer crudForCustomer, Actions actions) {
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
}
