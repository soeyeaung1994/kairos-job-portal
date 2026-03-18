# 🏗️ Kairos Job Portal — Full-Stack Backend Project

> A production-grade **Job Portal REST API** built with **Spring Boot 4**, **Spring Security**, **Spring Data JPA**, and **Docker** — developed as a hands-on personal project to solidify enterprise Java backend engineering skills.

---

## 📌 About This Project

This repository contains the complete source code of a **Job Portal backend system** I built from the ground up. The goal was to go beyond tutorial exercises and apply real-world patterns, such as clean architecture, secured APIs, transactional workflows, and cloud deployment, in a single cohesive project.

The project covers the full lifecycle of a backend service: from domain modelling and database design, through REST API development, security hardening, performance optimisation, and finally deployment to AWS.

---

## 🛠️ Tech Stack

| Layer | Technology                        |
|---|-----------------------------------|
| Language | Java 25                           |
| Framework | Spring Boot 4, Spring Framework 7 |
| Security | Spring Security, JWT              |
| Persistence | Spring Data JPA, Hibernate, MySQL |
| Infrastructure | Docker, Docker Compose            |
| Cloud | AWS (RDS + Elastic Beanstalk)     |
| Documentation | OpenAPI / Swagger                 |
| Build Tool | Maven                             |
| Utilities | Lombok, Logback, Micrometer       |

---

## ✨ Key Features Implemented

### 🔐 Security
- JWT-based stateless authentication with custom filters
- Role-based and authority-based access control
- Password hashing with BCrypt
- CSRF protection and CORS configuration
- Custom `AuthenticationProvider` with database-backed user/role design

### 🗄️ Data & Persistence
- Full JPA entity modelling with `@OneToMany`, `@ManyToOne`, `@ManyToMany`
- Derived queries, JPQL, and native queries
- N+1 problem resolution with batch fetching strategies
- JPA Auditing for `createdAt` / `updatedAt` lifecycle fields
- DTO pattern to decouple persistence layer from API layer

### 🌐 REST API Design
- RESTful endpoints following HTTP best practices
- API versioning strategies
- Global exception handling with structured error responses
- Backend input validation
- Sorting and pagination on collection endpoints
- OpenAPI/Swagger documentation

### 🚀 Performance & Reliability
- Spring Cache with Caffeine and TTL-based eviction (`@Cacheable`, `@CachePut`, `@CacheEvict`)
- `@Transactional` with propagation and isolation level tuning
- AOP-based performance logging and centralised exception handling
- Spring Boot Actuator with OpenTelemetry and Micrometer for observability

### ☁️ Deployment
- Containerised MySQL with Docker Compose and persistent volumes
- Environment-specific profiles (`DEV` / `QA` / `PROD`) using `@ConfigurationProperties`
- Deployed to **AWS Elastic Beanstalk** backed by **AWS RDS (MySQL)**

---

## 🚀 Running Locally

### Prerequisites
- Java 25+
- Maven 3.8+
- Docker & Docker Compose

### 1. Start the database
```bash
docker compose up -d
```

### 2. Run the application
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

### 3. Access API docs
```
http://localhost:8080/swagger-ui/index.html
```

---

## 🗃️ Database Setup (Docker)

```bash
docker run -p 3306:3306 \
  --name=jobportaldb \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=jobportal \
  -v ./jobportal-data:/var/lib/mysql \
  -d mysql
```

---

## 🔗 Useful Links

- [Spring Initializr](https://start.spring.io/)
- [Spring Documentation](https://spring.io/)
- [Docker Hub](https://hub.docker.com/)
- [AWS Elastic Beanstalk](https://aws.amazon.com/elasticbeanstalk/)

---

## 👤 Author

**Soe Ye Aung** — Senior Java Backend Engineer  
Passionate about building clean, scalable, and secure backend systems.

> *Feel free to explore the code, raise issues, or reach out if you'd like to discuss the architecture.*

---

## 🙏 Acknowledgement

This project was built while taking the Udemy course  
**[Master Spring 7, Spring Boot 4, REST, JPA, Spring Security](https://www.udemy.com/course/spring-springboot-jpa-hibernate-zero-to-master/?referralCode=9FA65DAC46E91F6A225D)** by **EazyBytes**.

[![Course Banner](https://github.com/eazybytes/spring/blob/main/Spring.png "Master Spring 7, Spring Boot 4, REST, JPA, Spring Security")](https://www.udemy.com/course/spring-springboot-jpa-hibernate-zero-to-master/?referralCode=9FA65DAC46E91F6A225D)

A huge thank you to the instructor for the incredibly well-structured curriculum and hands-on teaching approach. The course goes far beyond theory. It pushes you to think and build like a real backend engineer. Highly recommended for any Java developer looking to level up.