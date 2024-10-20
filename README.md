
# RESTful Web Services - Spring Boot

This project is a REST API built using Spring Boot. It provides endpoints for managing user-related data with standard HTTP methods like GET, POST, and DELETE. New features are being actively added.

## Features
- Retrieve all users
- Retrieve a specific user by ID
- Create a new user
- Delete a user
- Custom error handling for invalid user actions

## Project Structure Overview

- **Controllers**: Handle HTTP requests and direct them to the service layer.
- **Models**: Define the structure of data (e.g., `User` entity).
- **Services**: Contain the business logic for managing users.
- **Exception Handling**: Provide custom handling for application errors and user-not-found cases.

## Requirements
- Java 17+
- Maven 3.8+
- Spring Boot 3.3.3
- Postman or any HTTP client (for testing)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Harman1990/SpringBoot-RESTAPI.git
   ```

2. Navigate to the project directory:
   ```bash
   cd restful-web-services
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

- **GET /users**: Retrieve all users.
- **GET /users/{id}**: Retrieve a specific user by ID.
- **POST /users**: Create a new user.
- **DELETE /users/{id}**: Delete a user.


