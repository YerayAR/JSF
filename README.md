# JSF Spring Calculator

This project demonstrates a simple calculator application built with **Jakarta Server Faces (JSF)** for the UI, **Spring Framework** for dependency injection, and **Hibernate** for ORM persistence. A history of calculations is stored in a PostgreSQL database. The application follows the MVC pattern.

## Features

- Perform addition, subtraction, multiplication and division.
- Validation for invalid operations and divide-by-zero.
- Persist every calculation to a PostgreSQL table.
- View a table with the full history of calculations.

## Project Structure

```
src/main/java
  com.example.calculator.entity       -- JPA entity classes
  com.example.calculator.repository   -- Data access layer using Hibernate
  com.example.calculator.service      -- Spring managed services
  com.example.calculator.web          -- JSF managed beans (controllers)
src/main/webapp                       -- XHTML views and web resources
src/main/resources                    -- Spring and Hibernate configuration
```

## Build

The project uses Maven. Run:

```bash
mvn clean package
```

The result is `target/jsf-spring-calculator.war`, which can be deployed to any servlet container such as Tomcat.

## Database Setup

The database schema can be created with the SQL script in `db/schema.sql`.

Example commands (assuming PostgreSQL is installed):

```bash
createdb calculator
psql -d calculator -f db/schema.sql
```

Configure username, password and connection URL in `src/main/resources/applicationContext.xml` if different from the defaults (user `calculator`, password `calculator`).

## Usage

Deploy the generated WAR to your servlet container and access `http://localhost:8080/jsf-spring-calculator/calculator.xhtml`.

Use the form to perform calculations. Results and history will be displayed on the same page.

## Architecture Overview

- **View**: JSF XHTML pages in `src/main/webapp`.
- **Controller**: `CalculatorBean` managed by JSF and backed by Spring.
- **Service**: `CalculatorService` where business logic and validation live.
- **Model**: `Calculation` entity persisted via Hibernate.

Spring manages the service and repository beans as configured in `applicationContext.xml`. Hibernate handles persistence to PostgreSQL, and transactions are managed through Spring annotations.

## Notes

This project serves as a minimal example. In a real production environment you would add authentication, improved error handling, and automated tests.
