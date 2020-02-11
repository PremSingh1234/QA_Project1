package com.qa.domain;

import org.apache.log4j.Logger;
import com.qa.utils.Utils;

public enum TheDomain {
	
	CUSTOMER("Information about customers"),
	ITEM("Individual Items"),
	ORDER("Purchases of items"),
	STOP("To close the application");
	
	public static final Logger LOGGER = Logger.getLogger(TheDomain.class);
	
	private String description;
		
	private TheDomain(String description) {
		this.description = description;
		}
		
	public String description() {
		return this.name() + ": " +this.description;
		}
		
	public static void printTheDomains() {
		for (TheDomain theDomain : TheDomain.values()) {
			LOGGER.info(theDomain.description());
			}
		}
		
	public static TheDomain getTheDomain() {
		TheDomain theDomain;
		while (true) {
			try {
				theDomain = TheDomain.valueOf(Utils.getInput().toUpperCase());
				break;
				} catch (IllegalArgumentException e) {
					LOGGER.error("Invalid selection please try again");
				}
			}
			return theDomain;
		}
	}
