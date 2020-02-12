package ItemService;

import java.util.List;

public interface CrudForItemService<T> {

    public List<T> readAll();
    
    T create(T t);
     
    T update(T t);
 
    void delete(Long id);
	
}
