package com.quiz.portal.entity;

import com.quiz.portal.dto.TestResultDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TestResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int totalQuestions;
	private int correctAnswers;
	private double percentage;
	
	public TestResultDTO getDto() {
		TestResultDTO dto = new TestResultDTO();
		
		dto.setId(id);
		dto.setTotalQuestions(totalQuestions);
		dto.setCorrectAnswers(correctAnswers);
		dto.setPercentage(percentage);
		dto.setTestName(test.getTitle());
		dto.setUserName(user.getName());
		
		return dto;
	}
	
	@ManyToOne
	@JoinColumn(name = "test_id")
	private Test test;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
