package com.azad.practice.quizbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azad.practice.quizbackend.exception.QuestionServiceException;
import com.azad.practice.quizbackend.io.entity.QuestionEntity;
import com.azad.practice.quizbackend.io.repository.QuestionRepository;
import com.azad.practice.quizbackend.service.QuestionService;
import com.azad.practice.quizbackend.shared.dto.QuestionDto;
import com.azad.practice.quizbackend.shared.util.Utils;
import com.azad.practice.quizbackend.ui.model.response.ErrorMessages;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	Utils utils;
	
	@Autowired
	QuestionRepository questionRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public QuestionDto createQuestion(QuestionDto questionDto) {
		
		QuestionEntity questionEntity = modelMapper.map(questionDto, QuestionEntity.class);
		
		questionEntity.setQuestionId(utils.generateQuestionId(10));
		
		QuestionEntity createdQuestion = questionRepository.save(questionEntity);
		
		QuestionDto returnValue = modelMapper.map(createdQuestion, QuestionDto.class);
		return returnValue;
	}

	@Override
	public QuestionDto getQuestionByQuestionId(String questionId) {
		
		QuestionEntity fetchedQuestion = questionRepository.findByQuestionId(questionId);
		
		QuestionDto returnValue = modelMapper.map(fetchedQuestion, QuestionDto.class);
		return returnValue;
	}

	@Override
	public List<QuestionDto> getAllQuestion(int page, int limit) {
		
		if (page > 0) {
			page--;
		}
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<QuestionEntity> questionPage = questionRepository.findAll(pageableRequest);
		List<QuestionEntity> questionEntityList = questionPage.getContent();
		
		List<QuestionDto> returnValueList = new ArrayList<QuestionDto>();
		for (QuestionEntity questionEntity : questionEntityList) {
			returnValueList.add(modelMapper.map(questionEntity, QuestionDto.class));
		}
		return returnValueList;
	}

	@Override
	public QuestionDto updateQuestion(String questionId, QuestionDto questionDto) {
		
		QuestionEntity fetchedQuestion = questionRepository.findByQuestionId(questionId);
		
		fetchedQuestion.setText(questionDto.getText());
		fetchedQuestion.setMark(questionDto.getMark());
		
		QuestionEntity updatedQuestion = questionRepository.save(fetchedQuestion);
		
		QuestionDto returnValue = modelMapper.map(updatedQuestion, QuestionDto.class);
		return returnValue;
	}

	@Override
	public void deleteQuestion(String questionId) {
		
		QuestionEntity questionEntity = questionRepository.findByQuestionId(questionId);

		if (questionEntity == null) {
			throw new QuestionServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		questionRepository.delete(questionEntity);
	}

}
