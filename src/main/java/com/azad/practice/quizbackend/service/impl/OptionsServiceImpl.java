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

import com.azad.practice.quizbackend.exception.OptionsServiceException;
import com.azad.practice.quizbackend.exception.QuestionServiceException;
import com.azad.practice.quizbackend.io.entity.OptionsEntity;
import com.azad.practice.quizbackend.io.entity.QuestionEntity;
import com.azad.practice.quizbackend.io.repository.OptionsRepository;
import com.azad.practice.quizbackend.io.repository.QuestionRepository;
import com.azad.practice.quizbackend.service.OptionsService;
import com.azad.practice.quizbackend.service.QuestionService;
import com.azad.practice.quizbackend.shared.dto.OptionsDto;
import com.azad.practice.quizbackend.shared.dto.QuestionDto;
import com.azad.practice.quizbackend.shared.util.Utils;
import com.azad.practice.quizbackend.ui.model.response.ErrorMessages;

@Service
public class OptionsServiceImpl implements OptionsService {
	
	@Autowired
	Utils utils;
	
	@Autowired
	OptionsRepository optionsRepository;
	
	@Autowired
	QuestionService questionService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public OptionsEntity getOptionsByOptionsId(String optionsId) {
		return optionsRepository.findByOptionsId(optionsId);
	}

	@Override
	public OptionsDto createOptions(OptionsDto optionsDto) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		OptionsEntity optionsEntity = modelMapper.map(optionsDto, OptionsEntity.class);
		
		optionsEntity.setOptionsId(utils.generateOptionsId(10));
		
		OptionsEntity createdOptions = optionsRepository.save(optionsEntity);
		
		OptionsDto returnValue = modelMapper.map(createdOptions, OptionsDto.class);
		return returnValue;
	}

//
//	@Override
//	public QuestionDto getQuestionByQuestionId(String questionId) {
//		
//		QuestionEntity fetchedQuestion = questionRepository.findByQuestionId(questionId);
//		
//		QuestionDto returnValue = modelMapper.map(fetchedQuestion, QuestionDto.class);
//		return returnValue;
//	}
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
//
	@Override
	public OptionsDto updateOptions(String optionsId, OptionsDto optionsDto) {
		
		OptionsEntity fetchedOptions = optionsRepository.findByOptionsId(optionsId);
		
		fetchedOptions.setOption1(optionsDto.getOption1());
		fetchedOptions.setOption2(optionsDto.getOption2());
		fetchedOptions.setOption3(optionsDto.getOption3());
		fetchedOptions.setOption4(optionsDto.getOption4());
		
		OptionsEntity updatedOptions = optionsRepository.save(fetchedOptions);
		
		OptionsDto returnValue = modelMapper.map(updatedOptions, OptionsDto.class);
		return returnValue;
	}

	@Override
	public void deleteOptions(String optionsId) {
		
		OptionsEntity optionsEntity = optionsRepository.findByOptionsId(optionsId);

		if (optionsEntity == null) {
			throw new OptionsServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		optionsRepository.delete(optionsEntity);
	}

}
