package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.entity.BorrowHistory;
import com.library.repository.BorrowHistoryRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BorrowHistoryController {

	@Autowired
	private BorrowHistoryRepository historyRepo;

	@GetMapping("/history")
	public List<BorrowHistory> history(@RequestHeader("X-USER-ID") Long userId) {

		return historyRepo.findByUserId(userId);
	}
}
