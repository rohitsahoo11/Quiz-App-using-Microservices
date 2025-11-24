package com.rohit.question_service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.question_service.dto.GetScoreResponseDTO;
import com.rohit.question_service.dto.QuestionResponseDTO;
import com.rohit.question_service.model.Questions;
import com.rohit.question_service.repository.QuestionRepository;
import com.rohit.question_service.service.QuestionService;

@Service
public class QuestionServiceImp implements QuestionService{
	
	
	@Autowired
	private QuestionRepository repo;

	@Override
	public List<Questions> getAllQuestions() {
		
		return repo.findAll();
	}

	@Override
	public List<Questions> getQuestionsByCategory(String category) {
		
		return repo.findByCategory(category);
	}

	@Override
	public Questions addQuestion(Questions question) {
		
		return repo.save(question);
	}

	@Override
	public List<Integer> getQuestionForQuiz(String category, int numQ) {
		
		List<Integer> questions = repo.findRandomQuestionsByCategory(category, numQ);		
		return questions;
	}

	@Override
	public List<QuestionResponseDTO> getQuestionByQuestionId(List<Integer> questionId) {
		
		List<QuestionResponseDTO> responses = new ArrayList<>();
		List<Questions> questions = new ArrayList<>();
		
		for(Integer id:questionId) {
			questions.add(repo.findById(id).get());
		}
		
		for(Questions question:questions) {
			QuestionResponseDTO response = new QuestionResponseDTO();
			response.setId(question.getId());
			response.setQuestionTitle(question.getQuestionTitle());
			response.setOption1(question.getOption1());
			response.setOption1(question.getOption2());
			response.setOption1(question.getOption3());
			response.setOption1(question.getOption4());
			
			responses.add(response);
		}
		
		return responses;
	}

	@Override
	public Integer getScore(List<GetScoreResponseDTO> responses) {
		
		int score = 0;
		
		for(GetScoreResponseDTO response:responses) {
			Questions question = repo.findById(response.getId()).get();
			
			if(response.getResponse().equals(question.getRightAnswer())) {
				score++;
			}
			
		}
			
		
		return score;
	}

}
