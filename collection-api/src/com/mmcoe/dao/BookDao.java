package com.mmcoe.dao;

import java.util.List;

import com.mmcoe.pojo.Book;

public interface BookDao {

	boolean save(Book b);
	
	Book find(int isbn);
	
	List<Book> list();
	
	boolean delete(int isbn);
	
	List<Book> findByPrice(double min, double max);
}
