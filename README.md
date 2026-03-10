# Veterinary Clinic - Backend 🐾

A robust and scalable REST API designed for the comprehensive management of a veterinary clinic. This project demonstrates advanced skills in software architecture, security, data modeling, and the use of the latest features in Java and Spring Boot.

## 🚀 Technologies and Tools
* **Language:** Java 17 (Records, functional paradigm using Streams API and Optionals).
* **Framework:** Spring Boot 3.5.10 (Spring Data JPA, Spring Web).
* **Security:** Spring Security 6 & JSON Web Tokens (JJWT 0.13.0) with BCrypt encryption (HS384).
* **Database:** PostgreSQL with persistence managed by Hibernate.
* **Data Mapping:** MapStruct for efficient conversion between Entities and DTOs.
* **Documentation:** OpenAPI 3 (Swagger UI) integrated with Bearer Authentication.
* **Infrastructure:** Docker & Docker Compose for service containerization.
* **Dependency Management:** Maven.

## 🏗️ Key Technical Milestones
* **Stateless Security (Clean Architecture):** Complete implementation of authentication and authorization using JWT (JWS). Separated the security infrastructure (`/security`) from the business logic (`/auth`), securing endpoints via a custom `OncePerRequestFilter`.
* **Polymorphic Inheritance:** Implemented the `JOINED` table strategy for species management (Dog/Cat), enabling subtype-specific attributes and efficient querying.
* **Advanced Relationships:** Leveraged `@ManyToMany` mappings with dynamic fetching and filtered diagnoses by species using JPA Query Methods.
* **Global Exception Handling:** Use of `@RestControllerAdvice` to catch business logic errors (`ResourceNotFoundException`) and security exceptions (`BadCredentialsException`), returning structured JSON responses while hiding server stack traces.
* **DTO Architecture:** Ensured secure and lightweight data transfer using Java 17 Records and MapStruct to completely decouple the API from the persistence entities.
* **Data Integrity:** Managed atomic operations and rollback control via `@Transactional` in the service layer, guaranteeing database ACID properties across complex business flows.

## 🛠️ Environment Setup
1. Clone the repository.
2. Ensure Docker is installed on your machine.
3. Run `docker-compose up -d` to spin up the database.
4. Run the project from IntelliJ or by executing `./mvnw spring-boot:run`.
5. The API and Swagger documentation will be available at `http://localhost:8081/swagger-ui.html`.

---
Developed with ❤️ by [Lorena SGC](https://github.com/lorenasgc)
