package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.dto.ContactRequest;
import com.library.entity.ContactMessage;
import com.library.repository.ContactMessageRepository;
import com.library.service.EmailService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

	@Autowired
	private ContactMessageRepository repository;

	@Autowired
	private EmailService emailService;

	@PostMapping
	public ResponseEntity<String> submitContact(@RequestBody ContactRequest request) {

		// 1️⃣ Save to DB
		ContactMessage msg = new ContactMessage();
		msg.setName(request.getName());
		msg.setEmail(request.getEmail());
		msg.setMessage(request.getMessage());

		repository.save(msg);

		// 2️⃣ Send Email
		emailService.sendContactEmail(request.getName(), request.getEmail(), request.getMessage());

		return ResponseEntity.ok("Message sent successfully");
	}
}
