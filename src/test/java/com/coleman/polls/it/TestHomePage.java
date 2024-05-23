package com.coleman.polls.it;

import com.coleman.polls.Question;
import com.coleman.polls.QuestionRepository;
import com.coleman.polls.it.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestHomePage {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  QuestionRepository questionRepository;

  @Test
  public void testHomeShowsHeading() throws Exception {
    HomePage homePage = HomePage.open(mockMvc);

    assertEquals(homePage.heading, "Polls");
  }


  @Test
  public void testHomeAddsQuestion() throws Exception {
    mockMvc.perform(
                    post("/")
                            .content("[{\"id\": 1, \"text\": \"What colour is the sky?\"}]")
                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                            .characterEncoding("utf-8")
            )
            .andExpect(status().isCreated());

    List<Question> questions = questionRepository.getAll();

    assertEquals(questions.get(0).getText(),"What colour is the sky?");
  }
}
