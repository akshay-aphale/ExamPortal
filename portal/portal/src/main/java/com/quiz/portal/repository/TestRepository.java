package com.quiz.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.portal.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
