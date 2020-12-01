package com.example.restservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.restservice.domain.Answer;
import com.example.restservice.domain.AnswerRepository;
import com.example.restservice.domain.Question;
import com.example.restservice.domain.QuestionRepository;
import com.example.restservice.domain.User;
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
			
			arepository.save(new Answer("I am 23 years old"));
			arepository.save(new Answer("5"));
			arepository.save(new Answer(""));

			

			User user1 = new User("user", "$2y$12$6LmFjyVVsZqwE6H.r3NFWeqlZ/wh/fN/jLnpUQrkzuhg1LF1raLPe", "USER");
			User user2 = new User("admin", "$2y$10$5ZVBx3XDH6i6FdSltNYIIeJCcw/nH33wKNi7BEvm.8sKIMP7lITWe", "ADMIN");
			userrepo.save(user1);
			userrepo.save(user2);

		};

	}

}
