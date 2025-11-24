package com.rohit.question_service.service;

import java.util.List;

import com.rohit.question_service.dto.GetScoreResponseDTO;
import com.rohit.question_service.dto.QuestionResponseDTO;
import com.rohit.question_service.model.Questions;

public interface QuestionService {
	List<Questions> getAllQuestions();
	List<Questions> getQuestionsByCategory(String category);
	Questions addQuestion(Questions question);
	List<Integer> getQuestionForQuiz(String category, int numQ);
	List<QuestionResponseDTO> getQuestionByQuestionId(List<Integer> questionId);
	Integer getScore(List<GetScoreResponseDTO> responses);
}
