package com.coleman.polls;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
  default List<Question> getAll() {
    return new ArrayList<>(findAllByOrderByIdAsc());
  };

  List<Question> findAllByOrderByIdAsc();

  default void add(Question question) {
    save(question);
  }
}
