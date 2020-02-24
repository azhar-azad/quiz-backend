package com.azad.practice.quizbackend.io.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "options")
public class OptionsEntity implements Serializable {

	private static final long serialVersionUID = -5106949130344952421L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String optionsId;

	@Column(nullable = false)
	private String option1;

	@Column(nullable = false)
	private String option2;

	@Column(nullable = false)
	private String option3;

	@Column(nullable = false)
	private String option4;

	@Transient
	private List<String> optionsList = new ArrayList<String>();

	@OneToOne(mappedBy = "options")
	private QuestionEntity question;

	protected OptionsEntity() {
		super();
	}

	public OptionsEntity(String optionsId, String option1, String option2, String option3, String option4) {
		super();
		this.optionsId = optionsId;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}

	public Long getId() {
		return id;
	}

	public String getOptionsId() {
		return optionsId;
	}

	public void setOptionsId(String optionsId) {
		this.optionsId = optionsId;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public List<String> getOptionsList() {
		List<String> optionsList = new ArrayList<String>();

		optionsList.add(option1);
		optionsList.add(option2);
		optionsList.add(option3);
		optionsList.add(option4);

		return optionsList;
	}

	public QuestionEntity getQuestion() {
		return question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}

}
