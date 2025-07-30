/*
 * Create a class called BookStore with fields Bookid and Bookname.  Sort using comparator and 
display the output by sorting based on book name and book id.

 */
package myjavacodes;

import java.util.*;

//BookStore class with bookId and bookName
class BookStore {
	private int bookId;
	private String bookName;

	// Constructor
	 public BookStore(int bookId, String bookName) {
	     this.bookId = bookId;
	     this.bookName = bookName;
	 }
	
	 // Getters
	 public int getBookId() {
	     return bookId;
	 }
	
	 public String getBookName() {
	     return bookName;
	 }
	
	 // toString method for display
	 @Override
	 public String toString() {
	     return "Book ID: " + bookId + ", Book Name: " + bookName;
	 }
}

//Comparator to sort by book name
class BookNameComparator implements Comparator<BookStore> {
	 public int compare(BookStore b1, BookStore b2) {
	     return b1.getBookName().compareToIgnoreCase(b2.getBookName());
	 }
}

//Comparator to sort by book id
class BookIdComparator implements Comparator<BookStore> {
	 public int compare(BookStore b1, BookStore b2) {
	     return Integer.compare(b1.getBookId(), b2.getBookId());
	 }
}

public class BookStoreDemo {
	 public static void main(String[] args) {
	     List<BookStore> books = new ArrayList<>();
	
	     // Adding book objects
	     books.add(new BookStore(103, "Java Basics"));
	     books.add(new BookStore(101, "Algorithms"));
	     books.add(new BookStore(102, "Data Structures"));
	
	     System.out.println("Original List:");
	     for (BookStore book : books) {
	         System.out.println(book);
	     }
	
	     // Sorting by book name
	     Collections.sort(books, new BookNameComparator());
	     System.out.println("\nSorted by Book Name:");
	     for (BookStore book : books) {
	         System.out.println(book);
	     }
	
	     // Sorting by book id
	     Collections.sort(books, new BookIdComparator());
	     System.out.println("\nSorted by Book ID:");
	     for (BookStore book : books) {
	         System.out.println(book);
	     }
	 }
}

