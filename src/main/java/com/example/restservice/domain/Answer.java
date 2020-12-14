package com.example.restservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answers")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long answerid;

	private String qst;

	private String qsttype;
	
	private String answer;

	public Answer() {

	}

	public Answer(String qst, String qsttype, String answer) {
		super();
		this.qst = qst;
		this.qsttype = qsttype;
		this.answer = answer;
	
	}

	public long getId() {
		return answerid;
	}

	public void setId(long id) {
		this.answerid = id;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [id=" + answerid + ", qst=" + qst + ", qsttype=" + qsttype + ", answer=" + answer + "]";
	}

	

}