package com.example.restservice.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String qst;

	private String qsttype;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "answerid")
	private Answer answer;

	public Question() {

	}

	public Question(String qst, String qsttype, Answer answer) {
		super();
		this.qst = qst;
		this.qsttype = qsttype;
		this.answer = answer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQst() {
		return qst;
	}

	public void setQst(String qst) {
		this.qst = qst;
	}

	public String getQsttype() {
		return qsttype;
	}

	public void setQsttype(String qsttype) {
		this.qsttype = qsttype;
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
			return "Question [id=" + id + ", qst=" + qst + ", radio=" + qsttype + ", answer=" + this.getAnswer()
					+ "]";
		else
			return "Question [id=" + id + ", qst=" + qst + ", radio=" + qsttype + "]";
	}

}
