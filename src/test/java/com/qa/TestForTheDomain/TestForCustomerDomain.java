package com.qa.TestForTheDomain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.domain.Customer;

public class TestForCustomerDomain {

	private Customer customer;
	private Customer other;
	
	@Before
	public void setUp() {
		customer = new Customer(1L, "John");
		other = new Customer(1L, "John");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(customer.getcustomers_id());
		assertNotNull(customer.getName());
		
		customer.setcustomers_id(null);
		assertNull(customer.getcustomers_id());
		customer.setName(null);
		assertNull(customer.getName());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getcustomers_id(), 0);
		assertEquals("John", customer.getName());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setName(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setName("John");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setName(null);
		other.setName(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void nullId() {
		customer.setcustomers_id(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		customer.setcustomers_id(null);
		other.setcustomers_id(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setcustomers_id(2L);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("John");
		assertNull(customer.getcustomers_id());
		assertNotNull(customer.getName());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Customer customer = new Customer(null, null);
		Customer other = new Customer(null, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "customers_id:1 name:John";
		assertEquals(toString, customer.toString());
	}
}
