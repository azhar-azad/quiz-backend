package com.azad.practice.quizbackend.service;

import java.util.List;

import com.azad.practice.quizbackend.io.entity.AnswerEntity;
import com.azad.practice.quizbackend.shared.dto.AnswerDto;
import com.azad.practice.quizbackend.shared.dto.QuestionDto;

public interface AnswerService {

	AnswerDto createAnswer(AnswerDto answerDto);

	AnswerEntity getAnswerByAnswerId(String answerId);

}
