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
		String dateInString = "05 Nov 2020";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
		LocalDate dateTime = LocalDate.parse(dateInString, formatter);	
		book.setReleaseDate(dateTime);
		this.books.add(book);
		
		// Book 2
		book = new Book();
		book.setIsbn(123);
		book.setTitle("Learn Angular");
		// Set Book date to 2rd oct 2012
		String dateInString = "02 Oct 2012";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
		LocalDate dateTime = LocalDate.parse(dateInString, formatter);
		book.setReleaseDate(dateTime);
		this.books.add(book);
		
		// Book 3
		book = new Book();
		book.setIsbn(123);
		book.setTitle("Learn Spring");
		// Set Book date to 21st Nov 2021
		String dateInString = "21 Nov 2021";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
		LocalDate dateTime = LocalDate.parse(dateInString, formatter);
		book.setReleaseDate(dateTime);
		this.books.add(book);
		
		System.out.println(this.books.size() + " Books in Library");
		
	}
	
	public void sortBooks() {
		System.out.println("Inside Sort books");
		Book book;
		Iterator booksIterator = this.books.iterator();
		System.out.println("Before Sort books");
		while(booksIterator.hasNext()) {
			book = (Book) booksIterator.next();
			System.out.println(book.getIsbn() + " -- " + book.getTitle() + " -- " + book.getReleaseDate());
		}
		
		// Sort Logic
		List<?> sortedList = new ArrayList<>(books);
		Collections.sort(sortedList , new Comparator<Score>() {

			public Date compare(Book o1, Book o2) {
				return o2.getReleaseDate().before(o1.getReleaseDate());
			}
		});
		
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
		if(book1.getTitle() == book2.getTitle())
		{
			Date date1 = book1.getReleaseDate();
			Date date2 = book2.getReleaseDate();
			if( date1.after(date2) && date1.equals(date2)){
				purgedBook.setIsbn(book1.getIsbn());
				purgedBook.setTitle(book1.getTitle());
				purgedBook.setReleaseDate(book1.getReleaseDate());
			}else{
				purgedBook.setIsbn(book2.getIsbn());
				purgedBook.setTitle(book2.getTitle());
				purgedBook.setReleaseDate(book2.getReleaseDate());
			}
		}
		
		if(purgedBook == null) {
			System.out.println("Unable to purge books");
		}
		else {
			System.out.println("Purged book with release date " + purgedBook.getReleaseDate());
		}
		return purgedBook;
		
	}
}
