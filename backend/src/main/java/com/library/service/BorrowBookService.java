
package com.library.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.entity.BorrowBook;
import com.library.repository.BookRepository;
import com.library.repository.BorrowBookRepository;
import com.library.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class BorrowBookService {

	@Autowired
	private BorrowBookRepository borrowBookRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	// 📖 BORROW BOOK

	@Transactional
	public BorrowBook borrowBook(int bookId, Long userId) {

		Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

		if (book.getAvailableCopies() <= 0) {
			throw new RuntimeException("Book not available");
		}

		if (!userRepository.existsById(userId)) {
			throw new RuntimeException("User not found");
		}

		book.setAvailableCopies(book.getAvailableCopies() - 1);
		bookRepository.save(book);

		BorrowBook borrowBook = new BorrowBook();
		borrowBook.setBookId(bookId);
		borrowBook.setUserId(userId);

		// 🔥 ABSOLUTELY REQUIRED
		borrowBook.setBookName(book.getBookName());
		borrowBook.setImageUrl(book.getImageUrl());

		borrowBook.setStatus("BORROWED");
		borrowBook.setBorrowDate(LocalDate.now());
		borrowBook.setDueDate(LocalDate.now().plusDays(14));

		return borrowBookRepository.save(borrowBook);
	}

	// 📃 SHOW ALL BORROWED BOOKS
	public List<BorrowBook> getAllBorrowedBooks() {
		return borrowBookRepository.findAll();
	}

	// 🔁 RETURN BOOK (protected)
	@Transactional
	public BorrowBook returnBook(Long borrowId, Long userId) {

		BorrowBook borrowBook = borrowBookRepository.findById(borrowId)
				.orElseThrow(() -> new RuntimeException("Borrow record not found"));

		if (!borrowBook.getUserId().equals(userId)) {
			throw new RuntimeException("Unauthorized");
		}

		if ("RETURNED".equals(borrowBook.getStatus())) {
			throw new RuntimeException("Already returned");
		}

		Book book = bookRepository.findById((int) borrowBook.getBookId())
				.orElseThrow(() -> new RuntimeException("Book not found"));

		// 🔺 INCREASE AVAILABLE COUNT
		book.setAvailableCopies(book.getAvailableCopies() + 1);
		bookRepository.save(book);

		borrowBook.setStatus("RETURNED");
		borrowBook.setReturnDate(LocalDate.now());

		return borrowBookRepository.save(borrowBook);
	}
}