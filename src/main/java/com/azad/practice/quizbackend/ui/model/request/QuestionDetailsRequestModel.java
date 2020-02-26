package com.azad.practice.quizbackend.ui.model.request;

import java.util.List;

public class QuestionDetailsRequestModel {

	private String text;
	private String mark;
	private List<String> optionsList;
	private String answerText;

	protected QuestionDetailsRequestModel() {
		super();
	}

	public QuestionDetailsRequestModel(String text, String mark) {
		super();
		this.text = text;
		this.mark = mark;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public List<String> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(List<String> optionsList) {
		this.optionsList = optionsList;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

}
