package com.azad.practice.quizbackend.ui.model.response;

import java.util.List;

public class QuestionRest {

	private String questionId;
	private String text;
	private double mark;
	private List<String> optionsList;
	private String answerText;

	protected QuestionRest() {
		super();
	}

	public QuestionRest(String questionId, String text, double mark) {
		super();
		this.questionId = questionId;
		this.text = text;
		this.mark = mark;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
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
