package com.rohit.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.rohit.quiz_service.model.QuestionWrapper;
import com.rohit.quiz_service.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
	@GetMapping("questions/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numOfQuestions);
	
	@PostMapping("questions/getQuestion")
	public ResponseEntity<List<QuestionWrapper>> getQuestionByQuestionId(@RequestBody List<Integer> questionId);
	
	@PostMapping("questions/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
