package com.example.restservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.restservice.domain.QuestionRepository;
import com.example.restservice.domain.UserRepo;

@SpringBootApplication
public class RestserviceApplication {
//	private static final Logger log = LoggerFactory.getLogger(RestserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner demo(QuestionRepository qrepository, UserRepo userrepo) {
		return (args) -> {
		};

	}

}
