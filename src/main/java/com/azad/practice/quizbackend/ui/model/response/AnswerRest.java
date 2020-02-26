package com.azad.practice.quizbackend.ui.model.response;

import java.util.List;

public class AnswerRest {

	private String answerId;
	private String text;

	protected AnswerRest() {
		super();
	}

	public AnswerRest(String answerId, String text) {
		super();
		this.answerId = answerId;
		this.text = text;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
