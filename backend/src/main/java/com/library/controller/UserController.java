package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.LoginRequest;
import com.library.entity.User;
import com.library.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public User signup(@RequestBody User user) {
		return userService.signUp(user);
	}

//    @PostMapping("/login")
//    public User login(@RequestBody LoginRequest request) {
//        return userService.login(request.getEmail(), request.getPassword());
//    }

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return userService.login(user.getEmail(), user.getPassword());
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
}
