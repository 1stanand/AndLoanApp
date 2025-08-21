# LoanDesk

LoanDesk is a demo loan processing web application built with Spring Boot and Thymeleaf. It exposes a small REST API and provides a minimal UI.

## Prerequisites
- Java 21
- Maven 3.9+
- Docker (for PostgreSQL)

## Running with H2
```bash
mvn -pl app spring-boot:run
```
Application will be available at [http://localhost:8080](http://localhost:8080).

Default users / passwords:
- teller@bank.local / password
- officer@bank.local / password
- admin@bank.local / password

Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Running with PostgreSQL
```bash
docker compose up -d
mvn -pl app spring-boot:run -Dspring-boot.run.profiles=prod
```

## Modules
- `app` - Spring Boot application
- `tests` - Selenium + TestNG suite

## Postman
See `Postman_Collection.json` for sample requests.
