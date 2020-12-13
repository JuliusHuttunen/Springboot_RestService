package com.example.restservice.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Answerq {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String qst;

	private String qsttype;
	
	private String answer;

	public Answerq() {

	}

	public Answerq(String qst, String qsttype, String answer) {
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", qst=" + qst + ", qsttype=" + qsttype + ", answer=" + answer + "]";
	}

	

}
