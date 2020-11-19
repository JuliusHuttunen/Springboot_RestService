package com.example.restservice.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.restservice.domain.Answer;
import com.example.restservice.domain.AnswerRepository;
import com.example.restservice.domain.Question;
import com.example.restservice.domain.QuestionRepository;

@Controller
public class RestController {

	@Autowired
	private AnswerRepository arepository;

	@Autowired
	private QuestionRepository qrepository;

	@RequestMapping(value = { "/", "/question" })
	public String main(Model model) {
		model.addAttribute("questions", qrepository.findAll());
		return "question";
	}

//	@RequestMapping(value = "/answer", method = RequestMethod.POST)
//	public String newanswer(Model model) {
//		model.addAttribute("answer", new Answer());
//		arepository.save();
//		return "redirect:question";
//	}

//	@RequestMapping(value = "/answer", method = RequestMethod.POST)
//	public @ResponseBody Answer saveAnswerREST(@RequestBody Answer answer) {
//	arepository.save(answer);
//	return answer;     
//	}

	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> questionListRest() {
		return (List<Question>) qrepository.findAll();
	}

	@RequestMapping(value = "/questions/{questionId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long id) {
		return qrepository.findById(id);
	}

	@RequestMapping(value = "/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer> answerListRest() {
		return (List<Answer>) arepository.findAll();
	}

	@RequestMapping(value = "/answers/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Answer> findAnswerRest(@PathVariable("answerid") Long id) {
		return arepository.findById(id);
	}

	@RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
	public String formAnswer(@PathVariable("id") Long id, Model model) {
		model.addAttribute("question", qrepository.findById(id));
		model.addAttribute("answers", arepository.findAll());
		return "form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAnswer(Question question) {
		qrepository.save(question);
		return "redirect:question";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "add";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteQuestion(@PathVariable("id") Long id, Model model) {
		qrepository.deleteById(id);
		return "redirect:../question";
	}
}
