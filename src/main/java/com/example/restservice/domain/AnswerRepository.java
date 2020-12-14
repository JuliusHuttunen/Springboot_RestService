package com.example.restservice.domain;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
		
	List<Answer> findAll(Sort sort);
}