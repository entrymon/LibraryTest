package com.cursivetech.test.libraryapp;

import java.util.Date;
import java.util.*;
public class Book {
	
	private int isbn;
	
	private String title;
	
	private Date releaseDate;
	

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

public ArrayList<Book> viewBooksByAuthor(String author){
         ArrayList<Book> result=new ArrayList<Book>();
         Iterator iter=bookList.iterator();
         while(iter.hasNext())
         {
             Book b=(Book)iter.next();
             if(b.getAuthor().equalsIgnoreCase(author))
             result.add(b);
         }
         return result;
     }
     public int countnoofbook(String bname){
         int count=0;
         Iterator iter=bookList.iterator();
         while(iter.hasNext())
         {
             Book b=(Book)iter.next();
             if(b.getBookName().equalsIgnoreCase(bname))
             count++;
         }
         return count;
     }
 }

}
