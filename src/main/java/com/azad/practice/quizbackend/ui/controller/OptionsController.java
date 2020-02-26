package com.azad.practice.quizbackend.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azad.practice.quizbackend.service.OptionsService;
import com.azad.practice.quizbackend.shared.dto.OptionsDto;
import com.azad.practice.quizbackend.ui.model.request.OptionsDetailsRequestModel;
import com.azad.practice.quizbackend.ui.model.response.OptionsRest;

@RestController
@RequestMapping(path = "options")
public class OptionsController {
	
	@Autowired
	OptionsService optionsService;
	
	ModelMapper modelMapper = new ModelMapper();

	@PostMapping
	public OptionsRest createOptions(@RequestBody OptionsDetailsRequestModel optionsDetails) {
		
		OptionsDto optionsDto = modelMapper.map(optionsDetails, OptionsDto.class);
		
		OptionsDto createdOptions = optionsService.createOptions(optionsDto);
		
		OptionsRest returnValue = modelMapper.map(createdOptions, OptionsRest.class);
		return returnValue;
	}
	
	@GetMapping(path = "/{optionsId}")
	public OptionsRest getOptions(@PathVariable String optionsId) {
		
		OptionsDto optionsDto = optionsService.getOptionsDtoByOptionsId(optionsId);
		
		OptionsRest returnValue = modelMapper.map(optionsDto, OptionsRest.class);
		return returnValue;
	}
	
	@GetMapping
	public List<OptionsRest> getAllOptions(
			@RequestParam(value = "page", defaultValue = "0") int page, 
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		
		List<OptionsDto> optionsDtoList = optionsService.getAllOptions(page, limit);
		
		List<OptionsRest> returnValueList = new ArrayList<OptionsRest>();
		for (OptionsDto optionsDto : optionsDtoList) {
			returnValueList.add(modelMapper.map(optionsDto, OptionsRest.class));
		}
		return returnValueList;
	}
//	
//	@PutMapping(path = "/{questionId}")
//	public QuestionRest updateQuestion(@PathVariable String questionId, @RequestBody QuestionDetailsRequestModel questionDetails) {
//		
//		QuestionDto questionDto = modelMapper.map(questionDetails, QuestionDto.class);
//		
//		QuestionDto updatedQuestion = questionService.updateQuestion(questionId, questionDto);
//		
//		QuestionRest returnValue = modelMapper.map(updatedQuestion, QuestionRest.class);
//		return returnValue;
//	}
//	
//	@DeleteMapping(path = "/{questionId}")
//    public OperationStatusModel deleteQuestion(@PathVariable String questionId) {
//    	
//    	OperationStatusModel returnValue = new OperationStatusModel();
//    	
//    	returnValue.setOperationName(RequestOperationName.DELETE.name());
//    	questionService.deleteQuestion(questionId);
//    	returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
//    	
//        return returnValue;
//    }
}
