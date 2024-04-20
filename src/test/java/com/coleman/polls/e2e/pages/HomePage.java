package com.coleman.polls.e2e.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
  protected Page page;
  Locator heading;

  public HomePage(Page page) {
    this.page = page;
    this.heading = page.getByRole(AriaRole.HEADING);
  }

  public static HomePage open(Page page, int port) {
    page.navigate("http://localhost:" + port + "/");
    return new HomePage(page);
  }

  public String heading() {
    return heading.textContent();
  }
}
