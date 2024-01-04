package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Book;
import com.masai.exception.SomethingWentWrong;
import com.masai.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookRepository br;
	
	@Override
	public Book createBook(Book book) {

		if(book == null)throw new SomethingWentWrong("Book can't be null");
		return br.save(book);
	}

	@Override
	public List<Book> viewAllBook() {
		return br.findAll();
	}

	@Override
	public Book updateBook(Book book) {
		Book bo = br.findById(book.getBook_id()).orElseThrow(()-> new SomethingWentWrong("Invalid book ID"));
		
		bo.setAuthor(book.getAuthor());
		bo.setGenre(book.getGenre());
		bo.setISBN(book.getISBN());
		bo.setTitle(book.getTitle());
		
		return bo;
	}

	@Override
	public Book deleteBook(Integer book_id) {
		Book book = br.findById(book_id).orElseThrow(()-> new SomethingWentWrong("Invalid book ID"));
		br.deleteById(book_id);
		return book;
	}

}
