package com.azad.practice.quizbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azad.practice.quizbackend.exception.QuestionServiceException;
import com.azad.practice.quizbackend.io.entity.AnswerEntity;
import com.azad.practice.quizbackend.io.entity.QuestionEntity;
import com.azad.practice.quizbackend.io.repository.AnswerRepository;
import com.azad.practice.quizbackend.io.repository.QuestionRepository;
import com.azad.practice.quizbackend.service.AnswerService;
import com.azad.practice.quizbackend.service.OptionsService;
import com.azad.practice.quizbackend.service.QuestionService;
import com.azad.practice.quizbackend.shared.dto.AnswerDto;
import com.azad.practice.quizbackend.shared.dto.OptionsDto;
import com.azad.practice.quizbackend.shared.dto.QuestionDto;
import com.azad.practice.quizbackend.shared.util.Utils;
import com.azad.practice.quizbackend.ui.model.response.ErrorMessages;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	Utils utils;
	
	@Autowired
	AnswerRepository answerRepository;
	
//	@Autowired
//	OptionsService optionsService;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public AnswerDto createAnswer(AnswerDto answerDto) {
		
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		AnswerEntity answerEntity = modelMapper.map(answerDto, AnswerEntity.class);
		
		answerEntity.setAnswerId(utils.generateAnswerId(10));
		
		AnswerEntity createdAnswer = answerRepository.save(answerEntity);
		
		AnswerDto returnValue = modelMapper.map(createdAnswer, AnswerDto.class);
		return returnValue;
	}

	@Override
	public AnswerEntity getAnswerByAnswerId(String answerId) {
		
		return answerRepository.findByAnswerId(answerId);
	}
//
//	@Override
//	public List<QuestionDto> getAllQuestion(int page, int limit) {
//		
//		if (page > 0) {
//			page--;
//		}
//		
//		Pageable pageableRequest = PageRequest.of(page, limit);
//		
//		Page<QuestionEntity> questionPage = questionRepository.findAll(pageableRequest);
//		List<QuestionEntity> questionEntityList = questionPage.getContent();
//		
//		List<QuestionDto> returnValueList = new ArrayList<QuestionDto>();
//		for (QuestionEntity questionEntity : questionEntityList) {
//			returnValueList.add(modelMapper.map(questionEntity, QuestionDto.class));
//		}
//		return returnValueList;
//	}

	@Override
	public AnswerDto updateAnswer(String answerId, AnswerDto answerDto) {
		
		AnswerEntity fetchedAnswer = answerRepository.findByAnswerId(answerId);
		
		fetchedAnswer.setText(answerDto.getText());
		
		AnswerEntity updatedAnswer = answerRepository.save(fetchedAnswer);
		
		AnswerDto returnValue = modelMapper.map(updatedAnswer, AnswerDto.class);
		return returnValue;
	}
//
//	@Override
//	public void deleteQuestion(String questionId) {
//		
//		QuestionEntity questionEntity = questionRepository.findByQuestionId(questionId);
//		
//		if (questionEntity == null) {
//			throw new QuestionServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
//		}
//		
//		String fetchedOptionsId = questionEntity.getOptions().getOptionsId();
//		
//		questionRepository.delete(questionEntity);
//		optionsService.deleteOptions(fetchedOptionsId);
//	}

}
