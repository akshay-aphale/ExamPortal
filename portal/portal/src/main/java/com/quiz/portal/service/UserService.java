package com.quiz.portal.service;

import java.util.Optional;

import com.quiz.portal.entity.User;

public interface UserService {

	User createUser(User user);
	
	Boolean hasUserWithEmail(String email);
	
	User login(User user);
	
	Optional<User> getUserById(Long id);
	Optional<User> getUserByEmail(String email);
	
	User updateUser(User user);

}
