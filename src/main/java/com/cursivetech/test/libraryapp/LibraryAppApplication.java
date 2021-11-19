package com.cursivetech.test.libraryapp;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibraryAppApplication {
	
	

	public static void main(String[] args) {
		System.out.println("Test application Started");
		ApplicationContext applicationContext = SpringApplication.run(LibraryAppApplication.class, args);
		BookService bookService = applicationContext.getBean(BookService.class);;
		
		try {
			bookService.initBooks();
			Book b1 = new Book();
			b1.setTitle("Java");
			b1.setReleaseDate(new Date());
			
			Book b2 = new Book();
			b2.setTitle("Java");
			b2.setReleaseDate(new Date(System.currentTimeMillis() - 1000));
			
			Book b3 = new Book();
			b3.setTitle("Spring");
			b3.setReleaseDate(new Date(System.currentTimeMillis() - 1000));
			
			bookService.purgeBooks(b1, b2);
			bookService.purgeBooks(b2, b3);
			
			//bookService.sortBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
