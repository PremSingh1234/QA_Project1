package com.qa.customer;

import java.util.List;

/**
 * Create, Read, Update and Delete controller.
 * Takes in inputs for each action to be sent to a service class
 */
public interface CrudForCustomer<T> {
    
    List<T> readAll();
     
    T create();
     
    T update();
     
    void delete();

}
