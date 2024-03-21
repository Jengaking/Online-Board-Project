package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {
	@Autowired // 의존성 주입. spring이 객체를 대신 생성하여 주입하는 기법
	private QuestionRepository questionRepository; // 내가 만든 리포지토리 인터페이스 -> JpaRepository 인터페이스 상송
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Transactional
	@Test // 테스트가 수행되는 메소드 -> JUnit으로 실행 시 자동으로 호출된다.
	void testJpa() {
		Optional<Question> oa = this.questionRepository.findById(2);
		assertTrue(oa.isPresent());
		Question q = oa.get();
		
		List<Answer> answerList = q.getAnswerList();
		
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}

}
