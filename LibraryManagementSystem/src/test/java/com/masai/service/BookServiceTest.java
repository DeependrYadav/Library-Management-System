package com.masai.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.masai.entity.Book;
import com.masai.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	private BookRepository br;
	
	@InjectMocks
	private BookService bs = new BookServiceImpl();
	
	@Test
	public void viewAllBook() {
		List<Book> mockBookList = Arrays.asList(
                new Book(1,"Book1", "Author1", "123456789", "Fiction"),
                new Book(2,"Book2", "Author2", "987654321", "Non-Fiction")
        );

        when(br.findAll()).thenReturn(mockBookList);
        
        List<Book> actualList = bs.viewAllBook();
        
        assertThat(mockBookList.equals(actualList)).isTrue();
	}
	
	@Test
	public void updateBook() {
		Book bookToUpdate = new Book(1,"Book1", "Author1", "123456789", "Fiction");
		
		when(br.findById(1)).thenReturn(Optional.of(bookToUpdate));
		
		Book updatedBook = bs.updateBook(bookToUpdate);
		
		assertNotNull(updatedBook);
		assertEquals("Book1", updatedBook.getTitle());
		assertEquals("Author1", updatedBook.getAuthor());
		assertEquals("123456789", updatedBook.getISBN());
		assertEquals("Fiction", updatedBook.getGenre());

		verify(br, times(1)).findById(1);
		
	}
	
	@Test
	public void deleteBook() {
		Book bookToDelete = new Book(1,"Book1", "Author1", "123456789", "Fiction");
		
		when(br.findById(1)).thenReturn(Optional.of(bookToDelete));
		
		Book deleteBook = bs.deleteBook(1);
		
		assertNotNull(deleteBook);
		assertEquals("Book1", deleteBook.getTitle());
		assertEquals("Author1", deleteBook.getAuthor());
		assertEquals("123456789", deleteBook.getISBN());
		assertEquals("Fiction", deleteBook.getGenre());

		verify(br, times(1)).findById(1);
		verify(br, times(1)).deleteById(1);
		
	}
	
}
