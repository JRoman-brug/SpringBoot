
# Spring Boot Project

This project is developed with **Spring Boot**, following the "In Action" book series to deepen the knowledge of the framework and its tools.

## 📚 Based on the "In Action" Series
This repository follows best practices and concepts explained in the following books:
- **Spring in Action** by Craig Walls
- **Spring Security in Action** by Laurentiu Spilca
- **Spring Boot in Action** by Craig Walls
- **Spring Microservices in Action** by John Carnell

## 🚀 Dependencies
- **Spring Boot** (Main framework)
- **Spring Security** (Authentication and authorization)
- **Spring Data JPA** (Persistence with Hibernate and relational databases)
- **Spring Web** (REST API development)
- **Thymeleaf** (Server-side rendering, optional)
- **Lombok** (Reducing repetitive code)
- **H2 Database / MySQL / PostgreSQL** (In-memory or relational databases)
- **Spring Boot DevTools** (Hot reload for rapid development)
- **Spring Cloud** (Microservices architecture)
- **Spring Cloud Config** (Centralized configuration management for microservices)
- **Spring Cloud Netflix** (Service discovery, load balancing, etc.)
- **Spring Boot Actuator** (Application monitoring and management)

## 🔧 Prerequisites
To run the project, you need:
- **Java 17 or higher**
- **Maven or Gradle**
- **Spring Boot 3.x**

## 🛠 Installation and Execution
1. Clone this repository:
   ```sh
   git clone https://github.com/your-username/your-repository.git
   ```
2. Access the project directory:
   ```sh
   cd your-repository
   ```
3. Compile and run with Maven:
   ```sh
   ./mvnw spring-boot:run
   ```
   or with Gradle:
   ```sh
   ./gradlew bootRun
   ```
4. Access the application at `http://localhost:8080`

## 🔑 Security
The project implements **Spring Security** with role-based authentication. To access protected routes, use predefined credentials or create a user in the database.

## 📌 Additional Notes
- To change the database, edit the `application.properties` or `application.yml` file.
- More Spring modules like WebFlux, Actuator, etc., can be added based on the application's needs.

## 📜 License
This project is open source and you can modify it freely according to your application's requirements.

---
💡 **Inspired by the "In Action" series to effectively learn and apply Spring Boot.** 🚀
