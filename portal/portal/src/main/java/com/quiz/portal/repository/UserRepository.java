package com.quiz.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.portal.entity.User;
import com.quiz.portal.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByRole(UserRole admin);
	
	User findFirstByEmail(String email);
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findById(Long id);
	
	


}
