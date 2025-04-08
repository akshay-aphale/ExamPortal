package com.quiz.portal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.portal.entity.User;
import com.quiz.portal.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signupUser(@RequestBody User user) {
		if (userService.hasUserWithEmail(user.getEmail())) {
			return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
		}
		
		User createdUser = userService.createUser(user);
		if (createdUser == null) {
			return new ResponseEntity<>("User not created, came again later", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<>(createdUser, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		User dbUser = userService.login(user);
		
		if (dbUser == null) {
			return new ResponseEntity<>("Wrong Conditionals", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(dbUser, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/email/{email}")
	public Optional<User> getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable long id, @RequestBody User user) {
		user.setId(id);
		return userService.updateUser(user);
	}
	
	

}
