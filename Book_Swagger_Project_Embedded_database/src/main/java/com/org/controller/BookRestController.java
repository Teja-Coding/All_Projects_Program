package com.org.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.entity.Book;
import com.org.service.BookService;



@RestController
public class BookRestController {
	
	private BookService bookService;
	
	public BookRestController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping(value="/allBooks")
		//	produces= {"application/json","application/xml"}
			
	public ResponseEntity<List<Book>>   getAllBooks(){
		
		List<Book> allBooks=bookService.getAllBook();
		return new ResponseEntity<List<Book>>(allBooks,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/insertBook")
		//	produces= {"application/json","application/xml"},
		//	consumes= {"application/json","application/xml"})
	public ResponseEntity<String> upSertBook(@RequestBody Book book){
		
		String msg=bookService.bookInsert(book);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(value="/deleteBook/{bookId}")
		//	produces= {"application/json","application/xml"},
		//	consumes= {"application/json","application/xml"})
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId){
		
		String msg=bookService.deleteBook(bookId);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	@GetMapping("/bookById/{Bookid}")
	public ResponseEntity<Book> getBookById(@PathVariable("Bookid")   Integer BookId){
		
		return new ResponseEntity<Book>(bookService.getBookById(BookId),HttpStatus.OK);
	}
	
	/*  @PutMapping("/{id}")
	    public ResponseEntity<DataEntity> updateData(@PathVariable("id") Long id, @RequestBody DataEntity updatedData) {
	        DataEntity updated = dataService.updateData(id, updatedData);
	        return ResponseEntity.status(HttpStatus.OK).body(updated); */
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updataData(@PathVariable("id") Integer id,@RequestBody Book updatebook){
		Book updated=bookService.updateBookDate(id, updatebook);
		
		return ResponseEntity.status(HttpStatus.OK).body(updated);
		
	}
}
