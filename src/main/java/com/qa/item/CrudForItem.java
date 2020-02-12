package com.qa.item;

import java.util.List;

public interface CrudForItem<T> {
    
	List<T> readAll();
    
    T create();
     
    T update();
     
    void delete();

}
