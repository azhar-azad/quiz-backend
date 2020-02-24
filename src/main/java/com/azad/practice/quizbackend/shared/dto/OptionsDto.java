package com.azad.practice.quizbackend.shared.dto;

import java.io.Serializable;
import java.util.List;

public class OptionsDto implements Serializable {

	private static final long serialVersionUID = -4505349361857383135L;

	private Long id;
	private String optionsId;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String questionId;
	private String questionText;
	private List<String> optionsList;

	public OptionsDto() {
		super();
	}

	public OptionsDto(String optionsId, String option1, String option2, String option3, String option4,
			String questionId, String questionText) {
		super();
		this.optionsId = optionsId;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.questionId = questionId;
		this.questionText = questionText;
	}

	public OptionsDto(String questionText, List<String> optionsList) {
		super();
		this.questionText = questionText;
		this.optionsList = optionsList;
		populateOptinsFromList();
	}
	
	public OptionsDto(List<String> optionsList) {
		super();
		this.optionsList = optionsList;
		populateOptinsFromList();
	}

	private void populateOptinsFromList() {
		this.option1 = this.optionsList.get(0);
		this.option2 = this.optionsList.get(1);
		this.option3 = this.optionsList.get(2);
		this.option4 = this.optionsList.get(3);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptionsId() {
		return optionsId;
	}

	public void setOptionsId(String optionsId) {
		this.optionsId = optionsId;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<String> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(List<String> optionsList) {
		this.optionsList = optionsList;
	}

}
