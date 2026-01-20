package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.BookDao;
import com.library.entity.Book;
import com.library.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book addBook(Book book) {
		book.setAvailableCopies(book.getTotalCopies());
		return bookRepository.save(book);
	}

	public Book updateBook(Book book) {
		return bookRepository.findById(book.getBookId()).map(b -> bookRepository.save(book))
				.orElseThrow(() -> new RuntimeException("Book not found"));
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
}
