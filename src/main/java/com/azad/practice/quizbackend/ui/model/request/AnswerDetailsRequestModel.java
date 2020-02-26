package com.azad.practice.quizbackend.ui.model.request;

import java.util.List;

public class AnswerDetailsRequestModel {

	private String text;

	protected AnswerDetailsRequestModel() {
		super();
	}

	public AnswerDetailsRequestModel(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
