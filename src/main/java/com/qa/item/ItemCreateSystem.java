package com.qa.item;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.domain.Item;
import com.qa.utils.Utils;
import ItemService.CrudForItemService;

public class ItemCreateSystem implements CrudForItem<Item> {
	
public static final Logger LOGGER = Logger.getLogger(ItemCreateSystem.class);
	
	private CrudForItemService<Item> itemService;
	
	public ItemCreateSystem(CrudForItemService<Item> itemService) {
		this.itemService = itemService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	@Override
	public List<Item> readAll() {
		List<Item> items = itemService.readAll();
		for(Item item: items) {
			LOGGER.info(item.toString());
		}
		return items;
	}
		
		
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

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		itemService.delete(id);
		LOGGER.info("Customer Deleted");
	}

}
