package com.library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.entity.BorrowBook;
import com.library.entity.User;
import com.library.repository.BorrowBookRepository;
import com.library.service.BorrowBookService;
import com.library.dto.BorrowRequest;

@RestController
@RequestMapping("/api/borrow")
@CrossOrigin(origins = "http://localhost:3000")
public class BorrowBookController {

	@Autowired
	private BorrowBookService borrowBookService;

	@PostMapping
	public BorrowBook borrowBook(@RequestBody BorrowRequest request,
			@RequestHeader(value = "X-USER-ID", required = false) Long userId) {

		if (userId == null) {
			throw new RuntimeException("Unauthorized");
		}

		return borrowBookService.borrowBook(request.getBookId(), userId);
	}

	@PutMapping("/return/{id}")
	public BorrowBook returnBook(@PathVariable Long id,
			@RequestHeader(value = "X-USER-ID", required = false) Long userId) {

		if (userId == null) {
			throw new RuntimeException("Unauthorized");
		}

		return borrowBookService.returnBook(id, userId);
	}

	@GetMapping
	public List<BorrowBook> getAllBorrowedBooks(@RequestHeader(value = "X-USER-ID", required = false) Long userId) {

		if (userId == null) {
			throw new RuntimeException("Unauthorized");
		}

		return borrowBookService.getAllBorrowedBooks().stream().filter(b -> b.getUserId().equals(userId)).toList();
	}

}
