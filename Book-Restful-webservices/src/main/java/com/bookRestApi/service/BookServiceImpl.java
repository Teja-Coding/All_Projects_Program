package com.bookRestApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookRestApi.entity.Book;
import com.bookRestApi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	
	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllBook() {
		
		return bookRepository.findAll();
	}

	@Override
	public String upSert(Book book) {
		
		
		Integer bookId=book.getBookId();
		System.out.println(book);
		Book saveBook=bookRepository.save(book);
		if(bookId==null) {
			return "Book Inserted Successfully";
		}else {
			return "Book Updated Successfully";
		}
	}

	@Override
	public String deleteBook(Integer bookId) {
		
		 bookRepository.deleteById(bookId);
		 
		 return "Book deleted Successfully";
	}

	
}
