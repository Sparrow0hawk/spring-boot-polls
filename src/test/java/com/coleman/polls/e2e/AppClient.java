package com.coleman.polls.e2e;

import com.coleman.polls.Question;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class AppClient {

  private final String url;
  private final HttpClient client;

  public AppClient(String url) {
    this.url = url;
    this.client = HttpClient.newHttpClient();
  }

  public void addQuestions(Question... questions) throws IOException, InterruptedException {
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(questions);

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(this.url))
            .timeout(Duration.ofSeconds(10))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    assert(response.statusCode() == 201);
  }

}
