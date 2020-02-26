package com.azad.practice.quizbackend.shared.dto;

import java.io.Serializable;
import java.util.List;

public class AnswerDto implements Serializable {

	private static final long serialVersionUID = -4505349361857383135L;

	private Long id;
	private String answerId;
	private String text;

	public AnswerDto() {
		super();
	}

	public AnswerDto(Long id, String answerId, String text) {
		super();
		this.id = id;
		this.answerId = answerId;
		this.text = text;
	}
	
	public AnswerDto(String text) {
		super();
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
