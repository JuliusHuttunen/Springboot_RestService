package com.example.restservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long answerid;
	private String content;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id")
	private Question question;

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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		if (this.question != null)
			return "Answer [id=" + answerid + ", content=" + content + ", question=" + this.getQuestion() + "]";
		else
			return "Answer [id=" + answerid + ", content=" + content + "]";
	}

}
