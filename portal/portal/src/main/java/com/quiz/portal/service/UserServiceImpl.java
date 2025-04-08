package com.quiz.portal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.portal.entity.User;
import com.quiz.portal.enums.UserRole;
import com.quiz.portal.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	private void createAdminUser() {
		User optionalUser = userRepository.findByRole(UserRole.ADMIN);
		if (optionalUser == null) {
			User user = new User();
			
			user.setName("Admin");
			user.setEmail("admin@gmail.com");
			user.setRole(UserRole.ADMIN);
			user.setPassword("admin");
			
			userRepository.save(user);
		}
	}
	
	public Boolean hasUserWithEmail(String email) {
		return userRepository.findFirstByEmail(email) != null;
	}
	
	public User createUser(User user) {
		user.setRole(UserRole.USER);
		
		return userRepository.save(user);
	}
	
	public User login(User user) {
		Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
		if (optionalUser.isPresent() && user.getPassword().equals(optionalUser.get().getPassword())) {
			return optionalUser.get();
		}
		return null;
	}

	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}



	@Override
	public Optional<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	

	
	

	

	

	

}
