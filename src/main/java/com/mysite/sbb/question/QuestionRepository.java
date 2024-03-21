package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
	List<Question> findByIdLessThan(Integer id);
	List<Question> findByIdGreaterThan(Integer id);
	List<Question> findByCreateDateBetween(LocalDateTime fromDate, LocalDateTime toDate);
	List<Question> findByContentOrderByCreateDateAsc(String content);
	List<Question> findBySubjectIn(String[] subjects);
}
