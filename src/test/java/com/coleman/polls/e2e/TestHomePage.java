package com.coleman.polls.e2e;

import com.coleman.polls.Question;
import com.coleman.polls.e2e.pages.home.HomePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UsePlaywright
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestHomePage {

  @LocalServerPort
  private int port;

  private AppClient appClient;

  @BeforeEach
  public void setup() {
    this.appClient = new AppClient("http://localhost:" + port + "/");
  }

  @Test
  public void testHomeShowsQuestionList(Page page) throws IOException, InterruptedException {
    Question question1 = new Question();
    Question question2 = new Question();
    question1.setId(1L);
    question1.setText("What colour is the sky?");
    question2.setId(2L);
    question2.setText("What colour is the earth?");
    appClient.addQuestions(question1, question2);
    HomePage homePage = HomePage.open(page, port);

    assertEquals(homePage.heading(), "Polls");
    assertEquals(homePage.questions.questions(), Arrays.asList("What colour is the sky?", "What colour is the earth?"));
  }

}

