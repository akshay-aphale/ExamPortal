package com.quiz.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.portal.dto.QuestionDTO;
import com.quiz.portal.dto.SubmitTestDTO;
import com.quiz.portal.dto.TestDTO;
import com.quiz.portal.entity.Test;
import com.quiz.portal.service.TestService;

@RestController
@RequestMapping("/api/test")
@CrossOrigin("*")
public class TestController {

	@Autowired
	private TestService testService;
	
	@PostMapping()
	public ResponseEntity<?> createTest(@RequestBody TestDTO dto) {
		try {
			return new ResponseEntity<> (testService.createTest(dto), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/question")
	public ResponseEntity<?> addQuestionTest(@RequestBody QuestionDTO dto) {
		try {
			return new ResponseEntity<>(testService.addQuestionInTest(dto), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllTest() {
		try {
			return new ResponseEntity<>(testService.getAllTests(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllQuestions(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(testService.getAllQuestionsByTest(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/submit-test")
	public ResponseEntity<?> submitTest(@RequestBody SubmitTestDTO dto) {
		try {
			return new ResponseEntity<> (testService.submitTest(dto), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/test-result")
	public ResponseEntity<?> getAllTestResults(){
		try {
			return new ResponseEntity<>(testService.getAllTestResults(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/test-result/{id}")
	public ResponseEntity<?> getAllTestResultsOfUser(@PathVariable Long id){
		try {
			return new ResponseEntity<>(testService.getAllTestResultsOfUser(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("update/{id}")
	public Test updateTest(@PathVariable Long id, @RequestBody Test test) {
		test.setId(id);
		return testService.updateTest(test);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteTest(@PathVariable Long id) {
		testService.deleteTest(id);
	}
}
