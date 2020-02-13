package com.qa.TestForItem;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.qa.ItemService.ItemService;
import com.qa.domain.Item;
import com.qa.item.ItemCreateSystem;

public class ItemTester {

	/**
	 *  The thing I want to fake functionality for is each customer, item and order so i can see whats wrong without it affecting my original code
	 */
	@Mock
	private ItemService itemService;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private ItemCreateSystem itemCreateSystem;

	/**
	 * This will test if it can read all my items in the database
	 */
	@Test
	public void readAllTest() {
		ItemCreateSystem itemCreateSystem = new ItemCreateSystem(itemService);
		List<Item> items = new ArrayList<>();
		items.add(new Item("Hats", 2.50));
		items.add(new Item("T-Shirts", 19.99));
		items.add(new Item("jeans", 9.99));
		items.add(new Item("Trainers", 49.99));
		Mockito.when(itemService.readAll()).thenReturn(items);
		assertEquals(items, itemCreateSystem.readAll());
	}

	/**
	 * This will test if it can create a customer in the database
	 */
	@Test
	public void createTest() {
		String name = "Hats";
		Double price = 2.50;
		Mockito.doReturn(name).when(itemCreateSystem).getInput();
		Item item = new Item(name, price);
		Item savedItem = new Item("Hats", 2.50);
		Mockito.when(itemService.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemCreateSystem.create());
	}

	/**
	 * This will test if it can update a customer in the database
	 */
	@Test
	public void updateTest() {
		String id = "1001";
		String name = "Hats";
		Double price = 2.50;
		Mockito.doReturn(id, name, price).when(itemCreateSystem).getInput();
		Item item = new Item(1L, name, price);
		Mockito.when(itemService.update(item)).thenReturn(item);
		assertEquals(item, itemCreateSystem.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1001";
		Mockito.doReturn(id).when(itemCreateSystem).getInput();
		itemCreateSystem.delete();
		Mockito.verify(itemService, Mockito.times(1001)).delete(1001L);
	}
	
}
