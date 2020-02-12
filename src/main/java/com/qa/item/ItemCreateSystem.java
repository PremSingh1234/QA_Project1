package com.qa.item;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ItemService.CrudForItemService;
import com.qa.domain.Item;
import com.qa.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class ItemCreateSystem implements CrudForItem<Item> {
	
public static final Logger LOGGER = Logger.getLogger(ItemCreateSystem.class);
	
	private CrudForItemService<Item> itemService;
	
	public ItemCreateSystem(CrudForItemService<Item> itemService) {
		this.itemService = itemService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemService.readAll();
		for(Item item: items) {
			LOGGER.info(item.toString());
		}
		return items;
	}
		
	/**
	 * Creates a customer by taking in user input
	 */	
	@Override
	public Item create() {
		LOGGER.info("Please enter a item name");
		String name = Utils.getInput();
		LOGGER.info("Please enter a item price");
		Double price = Double.parseDouble(Utils.getInput());
		Item item = itemService.create(new Item(name,price));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a item name");
		String name = getInput();
		LOGGER.info("Please enter price for item");
		Double price = Double.parseDouble(Utils.getInput()); 
		Item item = itemService.update(new Item(id, name, price));
		LOGGER.info("Item Updated");
		return item;
		
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		itemService.delete(id);
		LOGGER.info("Customer Deleted");
	}

}
