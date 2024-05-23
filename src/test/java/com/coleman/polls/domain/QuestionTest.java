package com.coleman.polls.domain;

import com.coleman.polls.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
  @Test
  public void testSetId() {
    Question question = new Question();

    question.setId(1L);

    assertEquals(question.getId(), 1L);
  }

  @Test
  public void testSetText() {
    Question question = new Question();

    question.setText("What colour is the sky?");

    assertEquals(question.getText(), "What colour is the sky?");
  }
}
