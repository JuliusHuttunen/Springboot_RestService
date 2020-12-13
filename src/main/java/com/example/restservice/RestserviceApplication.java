package com.example.restservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.restservice.domain.Answerq;
import com.example.restservice.domain.AnswerRepository;
import com.example.restservice.domain.Question;
import com.example.restservice.domain.QuestionRepository;
import com.example.restservice.domain.UserRepo;

@SpringBootApplication
public class RestserviceApplication {
//	private static final Logger log = LoggerFactory.getLogger(RestserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner demo(QuestionRepository qrepository, AnswerRepository arepository, UserRepo userrepo) {
		return (args) -> {
			arepository.save(new Answerq("What the fuck", "text", ""));
		};

	}

}
