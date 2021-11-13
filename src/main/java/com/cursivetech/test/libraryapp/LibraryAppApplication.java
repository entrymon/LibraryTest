package com.cursivetech.test.libraryapp;

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
			bookService.sortBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
