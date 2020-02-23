package com.azad.practice.quizbackend.service;

import java.util.List;

import com.azad.practice.quizbackend.shared.dto.QuestionDto;

public interface QuestionService {

	QuestionDto createQuestion(QuestionDto questionDto);

	QuestionDto getQuestionByQuestionId(String questionId);

	List<QuestionDto> getAllQuestion(int page, int limit);

	QuestionDto updateQuestion(String questionId, QuestionDto questionDto);

	void deleteQuestion(String questionId);

}
