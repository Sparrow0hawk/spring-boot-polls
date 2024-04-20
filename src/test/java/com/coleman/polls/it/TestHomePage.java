package com.coleman.polls.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestHomePage {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void canGetHome() throws Exception {
    mockMvc.perform(get("/")).andExpectAll(
            status().isOk(),
            content().contentType("text/html;charset=UTF-8"),
            content().xml("""
                        <!DOCTYPE html>
                        <html lang="en">
                            <body>
                                <h1>Hello world!</h1>
                            </body>
                        </html>
                        """)
    );
  }


}
