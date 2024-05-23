[![CI](https://github.com/Sparrow0hawk/spring-boot-polls/actions/workflows/ci.yml/badge.svg)](https://github.com/Sparrow0hawk/spring-boot-polls/actions/workflows/ci.yml)
# Polls Spring Boot App

## Setup

To use this project you will need:
- Java 21
- Maven 3.9

1. Build application
   ```bash
   mvn clean install
   ```
2. Start application
   ```bash
   mvn spring-boot:run
   ```
3. Load some questions with cURL
   ```bash
   curl --json \
        '[
          {
            "id": 1,
            "text": "What is your favourite colour?"
          },
          {
            "id": 2,
            "text": "Who framed Roger Rabbit?"
          }
          ]' \
          http://127.0.0.1:8081/
   ```
4. Run tests
   ```bash
   mvn test
   ```
5. Run Checkstyle
   ```bash
   mvn site
   ```
   View the report by loading `./target/site/checkstyle.html` in your browser.
