# LoanDesk

LoanDesk is a server-rendered Spring Boot MVC application for loan origination and disbursal.

## Prerequisites

- Java 21
- Maven 3.9+
- PostgreSQL

## Database Setup

Create a PostgreSQL database and user for the application and update the datasource settings in `app/src/main/resources/application.yml`.

## Running the Application

```bash
cd app
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## Default Logins

- **maker / password** (role `MAKER`)
- **checker / password** (role `CHECKER`)

Uploaded files are stored under `./data/kyc` relative to the project root.
