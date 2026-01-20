package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.entity.Book;
import com.library.service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@PutMapping
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable int id) {
		return bookService.getBookById(id);
	}

	@GetMapping
	public List<Book> getAll() {
		return bookService.getAllBooks();
	}

}
