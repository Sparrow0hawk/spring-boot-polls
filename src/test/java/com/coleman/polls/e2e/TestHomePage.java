package com.coleman.polls.e2e;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


import static org.junit.jupiter.api.Assertions.assertEquals;

@UsePlaywright
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestHomePage {

  @LocalServerPort
  private int port;

  @Test
  public void testHomeShowsHelloWorld(Page page) {
    page.navigate("http://localhost:" + port + "/");

    Locator heading = page.getByRole(AriaRole.HEADING);

    assertEquals(heading.textContent(), "Hello world!");
  }

}

