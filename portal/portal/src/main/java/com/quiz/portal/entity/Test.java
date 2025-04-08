package com.quiz.portal.entity;

import java.util.List;

import com.quiz.portal.dto.TestDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String description;
	private Long time;
	
	
	@OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
	private List<Question> questions;
	
	
	public TestDTO getDto() {
		TestDTO testDTO = new TestDTO();
		
		testDTO.setId(id);
		testDTO.setTitle(title);
		testDTO.setDescription(description);
		testDTO.setTime(time);
		
		return testDTO;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
