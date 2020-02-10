package com.qa.databases;

import java.util.ArrayList;

public interface Dao <T> {
	//C
	public void create(T t);
	//R
	public ArrayList<T> readAll();
	//U
	public void update(T t);
	//D
	public void delete(int id);

}
