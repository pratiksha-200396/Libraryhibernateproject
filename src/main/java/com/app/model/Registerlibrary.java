package com.app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class  Registerlibrary {
@Id
private int bookid;
private String author;
private int rate;


public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}

	
}
