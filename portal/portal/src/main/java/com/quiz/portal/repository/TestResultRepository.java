package com.quiz.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.portal.entity.TestResult;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {

	List<TestResult> findAllByUserId(Long userId);
}
