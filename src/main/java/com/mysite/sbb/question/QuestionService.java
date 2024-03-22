package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;

import com.mysite.sbb.DataNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository questionRepository;// 생성자(lombok)을 이용한 의존성 주입.
	
	public List<Question> getList() { // 질문 리스트를 반환하는 서비스 메소드
		return this.questionRepository.findAll();
	}
	
	public Question getQuestion(Integer id) { // 특정 아이디의 질문을 반환하는 서비스 메소드
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get(); // 나중에 DTO를 반환하도록 수정할 것.
		} else {
			throw new DataNotFoundException("question not found"); // 질문이 없을 경우 발생하는 사용자정의 예의
		}
	}
}
