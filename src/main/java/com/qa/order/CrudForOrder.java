package com.qa.order;

import java.util.List;

/**
 * Create, Read, Update and Delete controller.
 * Takes in inputs for each action to be sent to a service class
 */
public interface CrudForOrder<T> {

	List<T> readAll();
    
    T create();
     
    T update();
     
    void delete();

}

