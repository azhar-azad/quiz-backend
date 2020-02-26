package com.azad.practice.quizbackend.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azad.practice.quizbackend.service.AnswerService;
import com.azad.practice.quizbackend.service.QuestionService;
import com.azad.practice.quizbackend.shared.dto.AnswerDto;
import com.azad.practice.quizbackend.shared.dto.QuestionDto;
import com.azad.practice.quizbackend.ui.model.request.AnswerDetailsRequestModel;
import com.azad.practice.quizbackend.ui.model.request.QuestionDetailsRequestModel;
import com.azad.practice.quizbackend.ui.model.response.AnswerRest;
import com.azad.practice.quizbackend.ui.model.response.OperationStatusModel;
import com.azad.practice.quizbackend.ui.model.response.QuestionRest;
import com.azad.practice.quizbackend.ui.model.response.RequestOperationName;
import com.azad.practice.quizbackend.ui.model.response.RequestOperationStatus;

@RestController
@RequestMapping(path = "answers")
public class AnswerController {
	
	@Autowired
	AnswerService answerService;
	
	ModelMapper modelMapper = new ModelMapper();

	@PostMapping
	public AnswerRest createAnswer(@RequestBody AnswerDetailsRequestModel answerDetails) {
		
		AnswerDto answerDto = modelMapper.map(answerDetails, AnswerDto.class);
		
		AnswerDto createdAnswer = answerService.createAnswer(answerDto);
		
		AnswerRest returnValue = modelMapper.map(createdAnswer, AnswerRest.class);
		return returnValue;
	}
	
//	@GetMapping(path = "/{questionId}")
//	public QuestionRest getQuestion(@PathVariable String questionId) {
//		
//		QuestionDto questionDto = questionService.getQuestionByQuestionId(questionId);
//		
//		QuestionRest returnValue = modelMapper.map(questionDto, QuestionRest.class);
//		return returnValue;
//	}
//	
//	@GetMapping
//	public List<QuestionRest> getAllQuestion(
//			@RequestParam(value = "page", defaultValue = "0") int page, 
//			@RequestParam(value = "limit", defaultValue = "25") int limit) {
//		
//		List<QuestionDto> questionDtoList = questionService.getAllQuestion(page, limit);
//		
//		List<QuestionRest> returnValueList = new ArrayList<QuestionRest>();
//		for (QuestionDto questionDto : questionDtoList) {
//			returnValueList.add(modelMapper.map(questionDto, QuestionRest.class));
//		}
//		return returnValueList;
//	}
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
