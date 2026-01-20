package com.library.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

//@Entity
//@Table(name = "borrow_books")
//public class BorrowBook {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "book_id", nullable = false)
//    private long bookId;
//
//    @Column(name = "user_id", nullable = false)
//    private Long userId;
//
//    @Column(name = "borrow_date")
//    private LocalDate borrowDate;
//
//    @Column(name = "due_date")
//    private LocalDate dueDate;
//
//    @Column(name = "return_date")
//    private LocalDate returnDate;
//
//    @Column(name = "status")
//    private String status;
//
//    // 🔴 REQUIRED: No-arg constructor
//    public BorrowBook() {}
//
//    // ✅ GETTERS & SETTERS (DO NOT SKIP)
//
//    public Long getId() {
//        return id;
//    }
//
//    public long getBookId() {
//        return bookId;
//    }
//
//    public void setBookId(long book) {
//        this.bookId = book;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public LocalDate getBorrowDate() {
//        return borrowDate;
//    }
//
//    public void setBorrowDate(LocalDate borrowDate) {
//        this.borrowDate = borrowDate;
//    }
//
//    public LocalDate getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(LocalDate dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    public LocalDate getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(LocalDate returnDate) {
//        this.returnDate = returnDate;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//	public void setBookName(String bookName) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void setImageUrl(String imageUrl) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	
//}

@Entity
@Table(name = "borrow_books")
public class BorrowBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "book_id")
	private long bookId;

	@Column(name = "user_id")
	private Long userId;

	// 🔥 THESE TWO MUST EXIST
	@Column(name = "book_name")
	private String bookName;

	@Column(name = "image_url")
	private String imageUrl;

	private String status;
	private LocalDate borrowDate;
	private LocalDate dueDate;
	private LocalDate returnDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

//    // 🔴 THESE GETTERS MUST EXIST (VERY IMPORTANT)
//    public String getBookName() {
//        return bookName;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }

	// setters

}
