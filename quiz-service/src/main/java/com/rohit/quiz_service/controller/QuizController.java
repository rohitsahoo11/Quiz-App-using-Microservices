package com.rohit.quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.quiz_service.model.QuestionWrapper;
import com.rohit.quiz_service.model.QuizDTO;
import com.rohit.quiz_service.model.Response;
import com.rohit.quiz_service.serviceImp.QuizServiceImp;



@RestController
@RequestMapping("quiz")
@CrossOrigin
public class QuizController {
	
	@Autowired
	private QuizServiceImp service;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDTO dto){
		return service.createQuiz(dto.getCategoryName(), dto.getNumQuestions(), dto.getTitle());
	}
	
	@PostMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
		return service.getQuizQuestion(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
		return service.calculateResult(id, response);
	}
}
