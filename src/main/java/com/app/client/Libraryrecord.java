package com.app.client;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.config.HibernateUtil;
import com.app.model.Registerlibrary;

public class Libraryrecord {
	 Session session =HibernateUtil.getSessionFactory().openSession();
	 Scanner sc = new Scanner(System.in);
	 public void readbook() {
		 Transaction tx = session.beginTransaction();
		 Registerlibrary r = new Registerlibrary();
		 System.out.println("enter number");
		 r.setBookid(sc.nextInt());
		 System.out.println("enter name");
		 r.setAuthor(sc.next());
		 System.out.println("enter rate 1-5");
		 r.setRate(sc.nextInt());
		 
		 session.persist(r);
		 tx.commit();
		 System.out.println("book record inserted successfully");

		 
	 }
	 public void addbook() {
		 
		 int bookid = sc.nextInt();
		 System.out.println(bookid);
		 Transaction tx = session.beginTransaction();
		 Registerlibrary ab = session.get(Registerlibrary.class, bookid);
		 
		 if(ab != null) {
		 String bookname = sc.next();
		 ab.setAuthor(bookname);
		 session.merge(ab);
		 tx.commit();
		 System.out.println("book record updated");}
		 else {
			 System.out.println("book id is not available");
		 }
		 
		 
	 }
	 public void Search() {
		 int bookid = sc.nextInt();
		 System.out.println(bookid);
		 
		 Registerlibrary search = session.get(Registerlibrary.class, bookid);
		 if(search != null) {
		 System.out.println(search.getBookid());
		 System.out.println(search.getAuthor());
		 System.out.println(search.getRate());
		 }else {
			 System.out.println("no book ");
		 }
		 
	 }
	 public void Borrow() {
		 int bookid = sc.nextInt();
		 System.out.println(bookid);
		 Transaction tx = session.beginTransaction();
		 Registerlibrary track = session.get(Registerlibrary.class, bookid);
		 
		 session.remove(track);
		 tx.commit();
		 session.beginTransaction().commit();
	 }
	 public void Track() {
		 int bookid = sc.nextInt();
		 System.out.println(bookid);
		 Registerlibrary track = session.get(Registerlibrary.class, bookid);
		 session.merge(track);
		 session.beginTransaction().commit();
		 
	 }
	 
	 public void Rating() {
		 System.out.println("enter book id");
		 int bookid = sc.nextInt();
		
		 Transaction tx = session.beginTransaction();
		 Registerlibrary rate = session.get(Registerlibrary.class, bookid);
		 System.out.println("enter new rating");
		 rate.setRate(sc.nextInt());
		 session.update(rate);
		 tx.commit();
		 session.beginTransaction().commit();
	 }
	 
	 public static void main(String[] args) {
		 
		 Scanner scanner = new Scanner(System.in);
		 Libraryrecord l = new Libraryrecord();
		 while(true) {
			 
			 System.out.println("1. read book");
			 System.out.println("2. add book");
			 System.out.println("3. search book");
			 System.out.println("4. borrow book");
			 System.out.println("5. track book");
			 System.out.println("6. rate book");
			 System.out.println("7. exist");
			 
			int choice = scanner.nextInt();
			switch(choice) {
			case 1 :
				l.readbook();
				break;
			case 2:
				 l.addbook();
				break;
			case 3 :
				 l.Search();
				break;
			case 4:
				 l.Borrow();
				break;
			case 5 :
				 l.Track();
				break;
			case 6 :
				 l.Rating();
				break;
			case 7 :
			    System.out.println("exiting application");
			    System.exit(0);		
			default :
				System.out.println("invalid");
			}
		 }
	 }
}
