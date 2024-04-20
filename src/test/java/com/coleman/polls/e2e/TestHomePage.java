package com.coleman.polls.e2e;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestHomePage {

  @LocalServerPort
  private int port;

  @Test
  public void testHomeShowsHelloWorld() {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch();
      Page page = browser.newPage();
      page.navigate("http://localhost:" + port + "/");

      Locator heading = page.getByRole(AriaRole.HEADING);

      assertEquals(heading.textContent(), "Hello world!");
    }

  }


}
