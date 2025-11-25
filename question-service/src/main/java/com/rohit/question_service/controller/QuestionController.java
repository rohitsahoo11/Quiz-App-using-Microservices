package com.rohit.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.question_service.dto.GetScoreResponseDTO;
import com.rohit.question_service.dto.QuestionResponseDTO;
import com.rohit.question_service.model.Question;
import com.rohit.question_service.serviceImp.QuestionServiceImp;

@RestController
@RequestMapping("questions")
@CrossOrigin
public class QuestionController {
	
	@Autowired
	private QuestionServiceImp service;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return new ResponseEntity<>(service.getAllQuestions(),HttpStatus.OK);
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
		return new ResponseEntity<>(service.getQuestionsByCategory(category),HttpStatus.OK);
	}
	
	
	@PostMapping("addQuestion")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return new ResponseEntity<>(service.addQuestion(question), HttpStatus.CREATED);
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numOfQuestions){
		List<Integer> question = service.getQuestionForQuiz(category, numOfQuestions);
		return new ResponseEntity<>(question,HttpStatus.OK);
	}
	
	@PostMapping("getQuestion")
	public ResponseEntity<List<QuestionResponseDTO>> getQuestionByQuestionId(@RequestBody List<Integer> questionId){
		
		return new ResponseEntity<>(service.getQuestionByQuestionId(questionId),HttpStatus.OK);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<GetScoreResponseDTO> responses){
		return new ResponseEntity<>(service.getScore(responses), HttpStatus.OK);
	}	
	
	
	
}
