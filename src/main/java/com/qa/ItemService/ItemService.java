package com.qa.ItemService;

import java.util.List;

import com.qa.databases.Dao;
import com.qa.domain.Item;

public class ItemService implements CrudForItemService<Item>{
	
Dao<Item> itemDao;
	
	public ItemService(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}

	public List<Item> readAll() {
		return itemDao.readAll();
	}

	public Item create(Item item) {
		return itemDao.create(item);
	}

	public Item update(Item item) {
		return itemDao.update(item);
	}

	public void delete(Long id) {
		itemDao.delete(id);
	}

}
