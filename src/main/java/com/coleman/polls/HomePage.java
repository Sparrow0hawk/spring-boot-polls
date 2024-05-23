package com.coleman.polls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class HomePage {
  @Value("${spring.application.name}")
  String appName;

  private final QuestionRepository questionRepository;

  @Autowired
  public HomePage(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  @GetMapping(value = "/")
  public String homePage(Model model) {
    model.addAttribute("appName", appName);
    model.addAttribute("questions", questionRepository.getAll());
    return "home";
  }

  @PostMapping(value = "/")
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody List<Question> questions) {
    for(Question question : questions) {
      questionRepository.add(question);
    }
  }
}
