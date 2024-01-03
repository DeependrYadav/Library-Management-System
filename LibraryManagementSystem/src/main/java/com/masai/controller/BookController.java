package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Book;
import com.masai.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService us;
	
	
	@PostMapping("/addBook")
	public ResponseEntity<Book> createBook(Book book){
		return new ResponseEntity<Book>(us.createBook(book),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllBook")
	public ResponseEntity<List<Book>> viewAllBook(){
		return new ResponseEntity<List<Book>>(us.viewAllBook(),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateBook")
	public ResponseEntity<Book> updateBook(Book book){
		return new ResponseEntity<Book>(us.updateBook(book),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteBookById/{book_id}")
	public ResponseEntity<Book> deleteBook(@PathVariable Integer book_id){
		return new ResponseEntity<Book>(us.deleteBook(book_id),HttpStatus.ACCEPTED);
	}
	
	
}
