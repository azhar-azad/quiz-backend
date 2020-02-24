package com.azad.practice.quizbackend.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class AnswerEntity implements Serializable {

	private static final long serialVersionUID = 4459312987674088102L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String answerId;

	@Column(nullable = false)
	private String text;

	@OneToOne
	private QuestionEntity question;

	protected AnswerEntity() {
		super();
	}

	public AnswerEntity(String answerId, String text) {
		super();
		this.answerId = answerId;
		this.text = text;
	}

	public Long getId() {
		return id;
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

	public QuestionEntity getQuestion() {
		return question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}

}
