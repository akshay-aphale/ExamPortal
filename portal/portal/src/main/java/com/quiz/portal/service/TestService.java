package com.quiz.portal.service;

import java.util.List;

import com.quiz.portal.dto.QuestionDTO;
import com.quiz.portal.dto.SubmitTestDTO;
import com.quiz.portal.dto.TestDTO;
import com.quiz.portal.dto.TestDetailsDTO;
import com.quiz.portal.dto.TestResultDTO;
import com.quiz.portal.entity.Test;

public interface TestService {

	TestDTO createTest(TestDTO dto);
	
	QuestionDTO addQuestionInTest(QuestionDTO dto);
	
	List<TestDTO> getAllTests();
	
	TestDetailsDTO getAllQuestionsByTest(Long id);
	
	TestResultDTO submitTest(SubmitTestDTO request);
	
	List<TestResultDTO> getAllTestResults();
	
	List<TestResultDTO> getAllTestResultsOfUser(Long userId);
	
	Test updateTest(Test test);
	void deleteTest(Long id);
}
