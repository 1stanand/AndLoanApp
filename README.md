# LoanDesk

A minimal dark-themed loan origination & disbursal practice app built with Spring Boot and PostgreSQL.

## Prerequisites
* Java 21
* Maven 3.9+
* PostgreSQL database running and accessible

## Database
Create a database named `loandesk` and update credentials in `app/src/main/resources/application.yml` if needed.

The schema is managed via Flyway. On first run, migrations will create tables and seed users, products and a sample application. Passwords are stored as **plain text** for local practice only.

## Running
```
cd app
mvn spring-boot:run
```

## Default logins
| username | password | role |
|----------|----------|------|
| maker    | password | MAKER|
| checker  | password | CHECKER|

## File storage
Uploaded KYC files are stored under `./data/kyc` relative to the project root.