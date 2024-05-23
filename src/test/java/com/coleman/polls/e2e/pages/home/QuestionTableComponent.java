package com.coleman.polls.e2e.pages.home;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;
import java.util.stream.Collectors;


public class QuestionTableComponent {
  Locator questionTable;

  public QuestionTableComponent(Locator questionList) {
    this.questionTable = questionList;
  }
  private class QuestionTableCellComponent {
    Locator questionTableCellComponent;

    public QuestionTableCellComponent(Locator row) {
      this.questionTableCellComponent = row.getByRole(AriaRole.CELL);
    }

    public String get_text() {
      return this.questionTableCellComponent.textContent().strip();
    }
  }

  public List<String> questions() {
    return this.questionTable.getByRole(AriaRole.ROW)
            .all()
            .stream()
            .skip(1)
            .map(row -> new QuestionTableCellComponent(row).get_text()
            ).collect(Collectors.toList());
  }
}
