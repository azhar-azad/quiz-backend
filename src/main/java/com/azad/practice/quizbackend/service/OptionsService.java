package com.azad.practice.quizbackend.service;

import java.util.List;

import com.azad.practice.quizbackend.io.entity.OptionsEntity;
import com.azad.practice.quizbackend.shared.dto.OptionsDto;

public interface OptionsService {

	OptionsDto createOptions(OptionsDto optionsDto);
	
	public OptionsEntity getOptionsByOptionsId(String optionsId);
	
	public OptionsEntity getOptionsEntity(OptionsDto optionsDto);
	
	public OptionsDto updateOptions(String optionsId, OptionsDto optionsDto);
	
	public void deleteOptions(String optionsId);

	OptionsDto getOptionsDtoByOptionsId(String optionsId);

	List<OptionsDto> getAllOptions(int page, int limit);

}
