package com.masai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

	@Id
	private int book_id;
	
	@Column(nullable = false)
	private String title;
	
	private String author;
	
	@Column(nullable = false,unique = true)
	private String ISBN;
	
	private String genre;
}
