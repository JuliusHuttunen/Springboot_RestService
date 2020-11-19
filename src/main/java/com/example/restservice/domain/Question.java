package com.example.restservice.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionId;

	private String qst;

	private String type;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "answerid")
	private Answer answer;

	public Question() {

	}

	public Question(String qst, String type) {
		super();
		this.qst = qst;
		this.type = type;
	}

	public long getquestionId() {
		return questionId;
	}

	public void setId(long questionId) {
		this.questionId = questionId;
	}

	public String getQst() {
		return qst;
	}

	public void setQst(String qst) {
		this.qst = qst;
	}

	public String isType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		if (this.answer != null)
			return "Question [id=" + questionId + ", qst=" + qst + ", radio=" + type + ", answer=" + this.getAnswer()
					+ "]";
		else
			return "Question [id=" + questionId + ", qst=" + qst + ", radio=" + type + "]";
	}

}
