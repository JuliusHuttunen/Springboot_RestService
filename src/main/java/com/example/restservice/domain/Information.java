package com.example.restservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Information {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long informationId;
	private String name;
	private int age;
	private String sex;

	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name = "questionId")
	private Question question;

	public Information() {

	}

	public Information(long informationId, String name, int age, String sex, Question question) {
		super();
		this.informationId = informationId;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.question = question;
	}

	public long getInformationId() {
		return informationId;
	}

	public void setInformationId(long informationId) {
		this.informationId = informationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// ;)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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
			return "Information [informationId=" + informationId + ", name=" + name + ", age=" + age + ", sex=" + sex
					+ ", question=" + this.getQuestion() + "]";
		else
			return "Information [informationId=" + informationId + ", name=" + name + ", age=" + age + ", sex=" + sex
					+ "]";
	}

}
