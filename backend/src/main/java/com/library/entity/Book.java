package com.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
//
//@Entity
//@Table(name = "books")
//public class Book {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int bookId;
//
//    private String bookName;
//    private String bookAuthor;
//
//    @Column(nullable = false)
//    private int totalCopies;
//
//    @Column(nullable = false)
//    private int availableCopies;
//
//    @Column(nullable = false)
//    private double price;   // ✅ NEW
//
//    private String imageUrl;
//
//    // ✅ Getter & Setter (REQUIRED)
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//  
//
//    // getters & setters
//    public int getBookId() { return bookId; }
//
//    public String getBookName() { return bookName; }
//    public String getBookAuthor() { return bookAuthor; }
//
//    public int getTotalCopies() { return totalCopies; }
//    public void setTotalCopies(int totalCopies) { this.totalCopies = totalCopies; }
//
//    public int getAvailableCopies() { return availableCopies; }
//    public void setAvailableCopies(int availableCopies) { this.availableCopies = availableCopies; }
//
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//    
//    
//}

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "book_author")
	private String bookAuthor;

	@Column(name = "total_copies")
	private int totalCopies;

	@Column(name = "available_copies")
	private int availableCopies;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "price")
	private double price;

	// ✅ GETTERS & SETTERS (ALL REQUIRED)

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
