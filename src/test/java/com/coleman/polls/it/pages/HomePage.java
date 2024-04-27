package com.coleman.polls.it.pages;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HomePage {
  final Document soup;
  public String heading;

  public HomePage(String content) {
    this.soup = Jsoup.parse(content);
    this.heading = get_heading();
  }

  public static HomePage open(MockMvc mockMvc) throws Exception {
    MvcResult result = mockMvc.perform(get("/")).andExpect(
                    status().isOk())
            .andReturn();

    String content = result.getResponse().getContentAsString();
    return new HomePage(content);
  }

  private String get_heading() {
    Element heading = this.soup.select("h1").first();
    assert heading != null;
    return heading.text();
  }

}
