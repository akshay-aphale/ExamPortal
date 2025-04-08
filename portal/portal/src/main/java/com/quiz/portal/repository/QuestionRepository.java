package com.quiz.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.portal.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
