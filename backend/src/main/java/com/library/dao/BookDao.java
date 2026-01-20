package com.library.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.entity.Book;
import com.library.repository.BookRepository;

@Repository
public class BookDao {

	@Autowired
	private BookRepository bookRepo;

	// Add a new book
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	// Update existing book
	public Book updateBook(Book book) {
		if (bookRepo.existsById(book.getBookId())) {
			return bookRepo.save(book);
		} else {
			return null;
		}
	}

	// Delete a book
	public void deleteBook(int bookId) {
		bookRepo.deleteById(bookId);
	}

	// Get a book by ID
	public Book getBookById(int bookId) {
		Optional<Book> optional = bookRepo.findById(bookId);
		return optional.orElse(null);
	}

	// Get all books
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
}
