package com.masai.service;

import java.util.List;

import com.masai.entity.Book;

public interface BookService {

	Book createBook(Book book);
	List<Book> viewAllBook();
	Book updateBook(Book book);
	Book deleteBook(Integer book_id);
}
