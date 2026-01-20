
package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import com.library.repository.BorrowBookRepository;
import com.library.repository.UserRepository;
//
//@Service
//public class DashboardService {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BorrowBookRepository borrowBookRepository;
//
//    // 🔹 Total DIFFERENT books (Java, Python → 2)
//    public long getTotalDifferentBooks() {
//        return bookRepository.count();
//    }
//
//    // 🔹 Total borrowed books
//    public long getTotalBorrowedBooks() {
//        return borrowBookRepository.countByStatus("BORROWED");
//    }
//
//    // 🔹 Total users
//    public long getTotalUsers() {
//        return userRepository.count();
//    }
//}

@Service
public class DashboardService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BorrowBookRepository borrowBookRepository;

	// 📘 Java, Python → 2
	public long getTotalBooksAdded() {
		return bookRepository.count();
	}

	// 📖 Borrowed books
	public long getBooksBorrowed() {
		return borrowBookRepository.countByStatus("BORROWED");
	}

	// 🔄 Pending return = borrowed
	public long getPendingReturns() {
		return borrowBookRepository.countByStatus("BORROWED");
	}

	// 📚 Total available books (sum of availableCopies)
	public long getTotalAvailableBooks() {
		return bookRepository.findAll().stream().mapToLong(Book::getAvailableCopies).sum();
	}
}
