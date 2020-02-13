package com.qa.TestForTheDomain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.domain.Item;

public class TestForItemDomain {

	private Item item;
	private Item other;
	
	@Before
	public void setUp() {
		item = new Item("Hats", 2.50);
		other = new Item("Hats", 2.50);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getName());
		assertNotNull(item.getItem_id());
		
		item.setItem_id(null);
		assertNull(item.getItem_id());
		item.setName(null);
		assertNull(item.getName());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getItem_id(), 0);
		assertEquals("John", item.getName());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setName(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setName("John");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setName(null);
		other.setName(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void nullId() {
		item.setItem_id(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setItem_id(null);
		other.setItem_id(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setItem_id(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Item item = new Item("Hats", 2.50);
		assertNull(item.getItem_id());
		assertNotNull(item.getName());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(null, null);
		Item other = new Item(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "item_id:1 name:Hats price:2.50";
		assertEquals(toString, item.toString());
	}
}
