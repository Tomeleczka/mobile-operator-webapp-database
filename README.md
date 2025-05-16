# mobile-operator-webapp

A Spring Boot & Thymeleaf web application for managing customers, contracts, and administrative operations of a cellular network operator, backed by an Oracle database.


---

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Database Setup and Creation Process](#database-setup-and-creation-process)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [Testing](#testing)

---

## Features

- User registration and authentication (Spring Security)
- Role-based access control (Customer vs. Admin)
- Customer management (CRUD operations)
- Contract creation, viewing, and management
- Administrative dashboard for monitoring and reporting
- Responsive UI built with Thymeleaf and Bootstrap
- Oracle database integration via JDBC

## Technologies

- **Backend:** Java, Spring Boot, Spring MVC, Spring Data JPA, Spring Security
- **Frontend:** Thymeleaf, Bootstrap 5, HTML5, CSS3, JavaScript
- **Database:** Oracle Database 19c
- **Build Tool:** Maven
- **Version Control:** Git, GitHub

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven 3.6+
- Oracle Database (local or remote) with credentials
- Git 2.20+

## Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/mobile-operator-webapp.git
   cd mobile-operator-webapp
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

## Configuration

1. **Database connection**
   - Open `src/main/resources/application.properties`
   - Set the following properties to match your Oracle instance:
     ```properties
     spring.datasource.url=jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
     spring.datasource.username=<DB_USERNAME>
     spring.datasource.password=<DB_PASSWORD>
     spring.jpa.hibernate.ddl-auto=update
     ```

2. **Security settings** (optional)
   - Customize password encoding or roles in `SecurityConfig.java`

---

## Database Setup and Creation Process

To prepare and initialize the Oracle database schema required by the application, follow these steps:

1. **Create a dedicated database user/schema**:
   ```sql
   CREATE USER mobile_operator IDENTIFIED BY your_password;
   GRANT CONNECT, RESOURCE TO mobile_operator;
   ```

2. **Execute DDL scripts**:
   In the `db/scripts` directory, you will find SQL files for creating tables, indexes, sequences, and constraints in the correct order:
   - `01_create_tables.sql`: defines all tables (e.g., `customers`, `contracts`, `users`, `roles`).
   - `02_sequences.sql`: creates sequences for primary keys.
   - `03_constraints.sql`: adds primary key, foreign key, and unique constraints.
   - `04_views_and_synonyms.sql`: sets up any views or synonyms for easier querying.

   Run them in sequence using SQL*Plus or Oracle SQL Developer:
   ```bash
   sqlplus mobile_operator/your_password@//<HOST>:<PORT>/<SERVICE>
   SQL> @db/scripts/01_create_tables.sql
   SQL> @db/scripts/02_sequences.sql
   SQL> @db/scripts/03_constraints.sql
   SQL> @db/scripts/04_views_and_synonyms.sql
   SQL> EXIT
   ```

3. **Load initial data** (optional):
   The script `05_seed_data.sql` contains sample customers, contracts, and user/role entries to help you get started during development.
   ```bash
   SQL> @db/scripts/05_seed_data.sql
   ```

4. **Verify the schema**:
   - Connect to the `mobile_operator` schema and run basic queries to confirm tables and relationships exist:
     ```sql
     SELECT table_name FROM user_tables;
     SELECT column_name, data_type FROM user_tab_columns WHERE table_name = 'CUSTOMERS';
     ```

5. **Automated migrations** (optional):
   If you prefer Flyway or Liquibase, configure it in `pom.xml` and place migration scripts under `src/main/resources/db/migration`. Spring Boot will detect and run them on application startup.

---

## Running the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` by default.

## Usage

1. **Register a new user** (Customer role) or log in as Admin.
2. **Customers** can view and manage their contracts.
3. **Admins** can:
   - Manage all customers
   - Create, update, and delete contracts
   - View system reports and usage statistics

## Testing

Run unit and integration tests with Maven:

```bash
mvn test
```

