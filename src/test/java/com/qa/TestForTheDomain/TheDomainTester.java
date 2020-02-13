package com.qa.TestForTheDomain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qa.domain.TheDomain;

public class TheDomainTester {

	@Test
	public void customerTest() {
		TheDomain theDomain = TheDomain.CUSTOMER;
		assertTrue(theDomain.description().toLowerCase().contains("customer"));
	}
	
	@Test
	public void itemTest() {
		TheDomain theDomain = TheDomain.ITEM;
		assertTrue(theDomain.description().toLowerCase().contains("item"));
	}
	
	@Test
	public void orderTest() {
		TheDomain theDomain = TheDomain.ORDER;
		assertTrue(theDomain.description().toLowerCase().contains("items"));
	}
	
	@Test
	public void stopTest() {
		TheDomain theDomain = TheDomain.STOP;
		assertTrue(theDomain.description().toLowerCase().contains("close"));
	}
}
