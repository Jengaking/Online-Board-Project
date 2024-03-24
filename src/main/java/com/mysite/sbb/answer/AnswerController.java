package com.mysite.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@PostMapping("/create/{id}") // value = 는 생략 가능하다.
	public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult) {
		Question question = this.questionService.getQuestion(id);
		if(bindingResult.hasErrors()) {
			model.addAttribute("question", question);
			return String.format("redirect:/question/detail/%s", id);
		}
		answerService.create(question, answerForm.getContent());
		return String.format("redirect:/question/detail/%s", id);
	}
}    
