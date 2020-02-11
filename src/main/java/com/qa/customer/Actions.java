package com.qa.customer;

import org.apache.log4j.Logger;

import com.qa.utils.Utils;

public enum Actions {
	
	CREATE("To save a new item into the database"), 
	READ("To read an item from the database"),
	UPDATE("To change an item already in the database"), 
	DELETE("To remove an item from the database"),
	RETURN("To return to domain selection");

	public static final Logger LOGGER = Logger.getLogger(Actions.class);

	private String description;

	Actions(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	public static void printActions() {
		for (Actions actions : Actions.values()) {
			LOGGER.info(actions.getDescription());
		}
	}

	public static Actions getActions() {
		Actions actions;
		while (true) {
			try {
				actions = Actions.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return actions;
	}
}
