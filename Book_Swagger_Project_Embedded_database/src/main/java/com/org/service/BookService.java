package com.org.service;

import java.util.List;

import com.org.entity.Book;



public interface BookService {
	
	
	
	List<Book> getAllBook();
	
	String bookInsert(Book book);
	
	String deleteBook(Integer bookId);

	Book getBookById(Integer bookId);
	
	Book updateBookDate(Integer id,Book book);

	
}
