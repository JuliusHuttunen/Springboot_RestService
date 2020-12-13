package com.example.restservice.domain;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long>{
		
	List<Question> findAll(Sort sort);
}
