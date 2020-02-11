package com.qa.customer;

import java.util.List;

public interface CrudForCustomer<T> {
    
    List<T> readAll();
     
    T create();
     
    T update();
     
    void delete();

}
