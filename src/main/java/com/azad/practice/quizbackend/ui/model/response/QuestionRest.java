package com.azad.practice.quizbackend.ui.model.response;

public class QuestionRest {

	private String questionId;
	private String text;
	private double mark;

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

}
