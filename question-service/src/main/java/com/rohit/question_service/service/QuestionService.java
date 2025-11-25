package com.rohit.question_service.service;

import java.util.List;

import com.rohit.question_service.dto.GetScoreResponseDTO;
import com.rohit.question_service.dto.QuestionResponseDTO;
import com.rohit.question_service.model.Question;

public interface QuestionService {
	List<Question> getAllQuestions();
	List<Question> getQuestionsByCategory(String category);
	Question addQuestion(Question question);
	List<Integer> getQuestionForQuiz(String category, int numQ);
	List<QuestionResponseDTO> getQuestionByQuestionId(List<Integer> questionId);
	Integer getScore(List<GetScoreResponseDTO> responses);
}
