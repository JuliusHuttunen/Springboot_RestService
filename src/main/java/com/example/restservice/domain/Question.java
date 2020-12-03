package com.example.restservice.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String qst;

	private String qsttype;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List <Answer> answers;

	public Question() {

	}

	public Question(String qst, String qsttype, Answer answer) {
		super();
		this.qst = qst;
		this.qsttype = qsttype;
	
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", qst=" + qst + ", qsttype=" + qsttype + "]";
	}

	

}
