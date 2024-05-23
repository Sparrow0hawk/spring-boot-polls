package com.coleman.polls;

import jakarta.persistence.*;

@Entity(name="question")
public class Question {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;

  @Column(nullable = false, unique = true, length = 200)
  private String text;

  public void setId(long id) {
    this.id = id;
  }

  public void setText(String text) {
    this.text = text;
  }

  public long getId() {
    return this.id;
  }

  public String getText() {
    return this.text;
  }
}
