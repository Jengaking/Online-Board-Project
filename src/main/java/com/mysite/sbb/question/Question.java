package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter // 일반적인 경우 엔티티 클래스에 Setter는 안전하지 않다. -> 보통 생성자를 이용한다.
@Entity // 엔티티로 만든다.
public class Question {
	@Id // 이 속성을 기본키로 한다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가하며 저장됨. 독립적으로 이 속성만 1씩 증가
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
}
