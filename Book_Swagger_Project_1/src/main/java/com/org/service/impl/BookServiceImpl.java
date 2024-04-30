package com.org.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.entity.Book;
import com.org.respository.BookRepository;
import com.org.service.BookService;

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
	public String bookInsert(Book book) {
		
		
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

	@Override
	public Book getBookById(Integer BookId) {
		Optional<Book> findById = bookRepository.findById(BookId);
		if(findById.isPresent()) {
			return findById.get();
		}else
			return null;
	}
	
	
	public Book updateBookData(Integer id, Book book) {
		// TODO Auto-generated method stub
		     Book  existingData = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Data not found with id: " + id));
		     
		     existingData.setBookName(book.getBookName());
		     existingData.setBookPrice(book.getBookPrice());
		return bookRepository.save(existingData);
	}

}
