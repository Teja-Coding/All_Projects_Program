package com.bookRestApi.service;

import java.util.List;

import com.bookRestApi.entity.Book;

public interface BookService {
	
	
	public List<Book> getAllBook();
	
	public String upSert(Book book);
	
	public String deleteBook(Integer bookId);

}
