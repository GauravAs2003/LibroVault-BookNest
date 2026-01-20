package com.library.service;

import com.library.entity.User;
import com.library.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// 1. Sign Up - Returns User object directly
	public User signUp(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("Email already exists");
		}
		if (userRepository.existsByUsername(user.getUsername())) {
			throw new RuntimeException("Username already taken");
		}
		return userRepository.save(user);
	}

	// 2. Login - Returns User if valid, throws exception if not
	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new RuntimeException("Invalid email or password"));
	}

	// 3. Get all users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// 4. Check email exists
	public boolean isEmailExists(String email) {
		return userRepository.existsByEmail(email);
	}

	// 5. Check username exists
	public boolean isUsernameExists(String username) {
		return userRepository.existsByUsername(username);
	}
}