package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masai.entity.Book;


public interface BookRepository extends JpaRepository<Book, Integer>{

	@Query("SELECT COUNT(b) > 0 FROM Book b WHERE b.ISBN = :isbn")
	boolean isBookExistByISBN(@Param("isbn") String ISBN);
}
