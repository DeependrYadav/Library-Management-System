package com.masai.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.masai.entity.Book;
@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository br;
	
	@Test
	void isBookExist() {
		Book expectedBook = new Book(1,"Life", "James", "5648794516231", "Action");
		
//		Book actualBook = br.findById(1).get();
		
		br.save(expectedBook);
		
		boolean actualResult = br.isBookExistByISBN(expectedBook.getISBN());
		
		assertThat(actualResult).isTrue();
		
		br.delete(expectedBook);
		
	}
}
