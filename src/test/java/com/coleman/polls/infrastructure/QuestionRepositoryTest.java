package com.coleman.polls.infrastructure;


import com.coleman.polls.Question;
import com.coleman.polls.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class QuestionRepositoryTest {
  @Autowired
  QuestionRepository questionRepository;

  @Test
  public void testGetAll() {
    Question question1 = new Question();
    Question question2 = new Question();
    question1.setText("What colour is the sky?");
    question2.setText("What colour is the earth?");
    questionRepository.save(question1);
    questionRepository.save(question2);

    final List<Question> questions = questionRepository.getAll();

    assertThat(questions.get(0))
            .isInstanceOf(Question.class)
            .returns("What colour is the sky?", Question::getText);
    assertThat(questions.get(1))
            .isInstanceOf(Question.class)
            .returns("What colour is the earth?", Question::getText);
  }

  @Test
  public void testAdd() {
    Question question = new Question();
    question.setText("What colour is the sky?");
    questionRepository.add(question);

    final Question retrievedQuestion = questionRepository.findById(1L).orElseThrow();

    assertThat(retrievedQuestion)
            .isNotNull()
            .returns("What colour is the sky?", Question::getText);
  }
}
