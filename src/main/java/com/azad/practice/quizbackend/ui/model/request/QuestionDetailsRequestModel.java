package com.azad.practice.quizbackend.ui.model.request;

public class QuestionDetailsRequestModel {

	private String text;
	private String mark;

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

}
