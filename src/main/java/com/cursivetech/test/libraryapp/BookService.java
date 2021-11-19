package com.cursivetech.test.libraryapp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    
	Set books = new HashSet<Book>();
	
	public void initBooks() {
		Book book;
		
		// Book 1
		book = new Book();
		book.setIsbn(123);
		book.setTitle("Learn Java");
		// Set Book date to 5th Nov 2020
		// book.setReleaseDate();
		this.books.add(book);
		
		// Book 2
		book = new Book();
		book.setIsbn(123);
		book.setTitle("Learn Angular");
		// Set Book date to 2rd oct 2012
		// book.setReleaseDate();
		this.books.add(book);
		
		// Book 3
		book = new Book();
		book.setIsbn(123);
		book.setTitle("Learn Spring");
		// Set Book date to 21st Nov 2021
		// book.setReleaseDate();
		this.books.add(book);
		
		System.out.println(this.books.size() + " Books in Library");
		
	}
	
	public void sortBooks(int count, String name) {
		System.out.println("Inside Sort books");
		Book book;
		Iterator booksIterator = this.books.iterator();
		System.out.println("Before Sort books");
		while(booksIterator.hasNext()) {
			book = (Book) booksIterator.next();
			System.out.println(book.getIsbn() + " -- " + book.getTitle() + " -- " + book.getReleaseDate());
		}
		
		// Sort Logic
		Book temp;
		for(int i =0; i<count; i++){
		for(int j=0;j<count -i; j++){
			if(books[j].title > books[j+1].title){
				temp= books[j];
				books[j] = books[j+1];
				books[j+1] = temp;
			}
		}
		}
		
		
		// After Sort
		booksIterator = this.books.iterator();
		System.out.println("\n\n\nAfter Sort books");
		while(booksIterator.hasNext()) {
			book = (Book) booksIterator.next();
			System.out.println(book.getIsbn() + " -- " + book.getTitle() + " -- " + book.getReleaseDate());
		}
		
	}
	
	public Book purgeBooks(Book book1, Book book2) {
		Book purgedBook = null;
		// Check if book 1 and book 2 is same if yes then purge the book and return purged object
		
		
		if(purgedBook == null) {
			System.out.println("Unable to purge books");
		}
		else {
			System.out.println("Purged book with release date " + purgedBook.getReleaseDate());
		}
		return purgedBook;
		
	}
}
