package com.azad.practice.quizbackend.service;

import java.util.List;

import com.azad.practice.quizbackend.io.entity.OptionsEntity;
import com.azad.practice.quizbackend.shared.dto.OptionsDto;
import com.azad.practice.quizbackend.shared.dto.QuestionDto;

public interface OptionsService {

	OptionsDto createOptions(OptionsDto optionsDto);
	
	public OptionsEntity getOptionsByOptionsId(String optionsId);

}
