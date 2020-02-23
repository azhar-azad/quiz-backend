package com.azad.practice.quizbackend.shared.dto;

import java.io.Serializable;

public class QuestionDto implements Serializable {

	private static final long serialVersionUID = -4505349361857383135L;

	private Long id;
	private String questionId;
	private String text;
	private double mark;

	protected QuestionDto() {
		super();
	}

	public QuestionDto(Long id, String questionId, String text, double mark) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.text = text;
		this.mark = mark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
