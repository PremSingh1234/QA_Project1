package com.qa.customer;

import org.apache.log4j.Logger;

import com.qa.utils.Utils;

/**
 * Action is a collection of commands which are used to determine the type of function to apply to an entity.
 *
 */
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

	/**
	 * Describes the action
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	/**
	 * Prints out all possible actions
	 */
	public static void printActions() {
		for (Actions actions : Actions.values()) {
			LOGGER.info(actions.getDescription());
		}
	}

	/**
	 * Gets an action based on a users input.
	 * If user enters a non-specified enumeration, it will ask for another input.
	 * @return Action type
	 */
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
