package com.rohit.quiz_service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rohit.quiz_service.feign.QuizInterface;
import com.rohit.quiz_service.model.QuestionWrapper;
import com.rohit.quiz_service.model.Quiz;
import com.rohit.quiz_service.model.Response;
import com.rohit.quiz_service.repository.QuizRepository;




@Service
public class QuizServiceImp{
	
	
	@Autowired
	private QuizRepository repo;
	
	@Autowired
	QuizInterface quizInterface;

	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		
		
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
		Quiz quiz = repo.findById(id).get();
		
		List<Integer> questionIds = quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionByQuestionId(questionIds);
		return questions;
	}


	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
		ResponseEntity<Integer> score = quizInterface.getScore(response);
		return score;
	}

}
