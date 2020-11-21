package com.example.restservice.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long answerid;
	private String content;
	
	@ManyToOne
	private List<Question> questions;
	
	
	
	public Answer() {
		
	}

	public Answer(String content) {
		super();
		this.content = content;
	}

	public long getAnswerid() {
		return answerid;
	}

	public void setAnswerid(long answerid) {
		this.answerid = answerid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Answer [answerid=" + answerid + ", content=" + content + "]";
	}
	
	
	
	
	
	

}
