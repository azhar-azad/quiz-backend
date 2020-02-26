package com.azad.practice.quizbackend.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionEntity implements Serializable {

	private static final long serialVersionUID = 7516673412082443691L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String questionId;

	@Column(nullable = false)
	private String text;

	@Column(nullable = false)
	private double mark;

	@OneToOne
	private AnswerEntity answer;

	@OneToOne
	private OptionsEntity options;

	protected QuestionEntity() {
		super();
	}

	public QuestionEntity(String questionId, String text, double mark) {
		super();
		this.questionId = questionId;
		this.text = text;
		this.mark = mark;
	}

	public Long getId() {
		return id;
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

	public AnswerEntity getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerEntity answer) {
		this.answer = answer;
	}

	public OptionsEntity getOptions() {
		return options;
	}

	public void setOptions(OptionsEntity options) {
		this.options = options;
	}

}
