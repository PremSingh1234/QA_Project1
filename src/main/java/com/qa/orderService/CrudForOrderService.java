package com.qa.orderService;

import java.util.List;

public interface CrudForOrderService<T> {
	
    public List<T> readAll();
    
    T create(T t);
     
    T update(T t);
 
    void delete(Long id);
	
}
