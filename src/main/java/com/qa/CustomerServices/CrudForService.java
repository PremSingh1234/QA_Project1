package com.qa.CustomerServices;

import java.util.List;

public interface CrudForService<T> {

    public List<T> readAll();
     
    T create(T t);
     
    T update(T t);
 
    void delete(Long id);

}