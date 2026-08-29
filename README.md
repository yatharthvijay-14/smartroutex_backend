# 🛣️ SmartRouteX — AI-Powered Smart Navigation Backend

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Database](https://img.shields.io/badge/Database-MySQL%20%2F%20H2-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-purple.svg)](#-license)

SmartRouteX Backend is a high-performance RESTful microservice built with **Java 21** and **Spring Boot 4.1.0**. It powers real-time road risk assessments, hazard reporting with AI-verifications, user authentication, and automated email alerts to infrastructure authorities.

---

## 🚀 Key Features

- 🔐 **Authentication & Security**: JWT (JSON Web Tokens) with BCrypt password hashing and Google OAuth integration.
- ⚠️ **Hazard & Pothole Management**: Real-time CRUD APIs for road hazards, user-scoped reports, severity tags, and photo evidence removal.
- ⚡ **Auto-Fallback Dual Database System**:
  - **Production**: MySQL 8.0 database with connection pooling (`HikariCP`).
  - **Cloud/Deployment Fallback**: Automatic H2 in-memory DB fallback for 1-click cloud container hosting (Render/Railway).
- 📧 **Automated Alerting**: JavaMailSender integration sending automated email notifications to city authorities when high-severity potholes are reported.
- 🐳 **Docker & Cloud Ready**: Fully dockerized multi-stage build setup ready for 1-click deployment on Render, Railway, or Fly.io.

---

## 🛠️ Technology Stack

| Component | Technology / Library |
| :--- | :--- |
| **Language** | Java 21 (JDK 21) |
| **Framework** | Spring Boot 4.1.0 |
| **Web & Security** | Spring Web, Spring Security, JWT (`io.jsonwebtoken`) |
| **Data & Persistence** | Spring Data JPA, Hibernate 7, Jakarta Persistence |
| **Databases** | MySQL 8.0 / H2 In-Memory DB |
| **Connection Pool** | HikariCP |
| **Build Tool** | Apache Maven 3.9+ |
| **Containerization** | Docker, `eclipse-temurin:21` JRE |

---

## 📌 REST API Endpoints

### 🔑 Authentication (`/api/auth`)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/auth/register` | Register a new user account |
| `POST` | `/api/auth/login` | Login user & receive JWT token |
| `POST` | `/api/auth/google-login` | Authenticate using Google OAuth token |
| `POST` | `/api/auth/google-register` | Register new account using Google profile |

### 🕳️ Potholes & Hazards (`/potholes`)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/potholes` | Fetch all reported potholes (optional `?username=`) |
| `GET` | `/potholes/user/{username}` | Fetch potholes reported by specific user |
| `GET` | `/potholes/severity/high` | Fetch high-severity critical hazards |
| `POST` | `/potholes` | Submit a new hazard report with photo |
| `PATCH` | `/potholes/{id}/fix` | Mark pothole as FIXED |
| `PATCH` | `/potholes/{id}/remove-image` | Remove image proof from report |
| `DELETE` | `/potholes/{id}` | Delete a pothole report |

### 🛣️ Corridor & Road Status (`/roads`)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/roads` | Fetch all road corridors |
| `GET` | `/roads/high-risk` | Fetch high-risk corridors |
| `GET` | `/roads/best` | Fetch safest corridors |
| `POST` | `/roads/update-risk` | Update road rating & safety score |

---

## ⚙️ Environment Variables

```env
# Database Credentials
DB_URL=jdbc:mysql://localhost:3306/smartroad?createDatabaseIfNotExist=true&useSSL=false
DB_USERNAME=root
DB_PASSWORD=your_password

# Email Alert Credentials
MAIL_HOST=smtp.gmail.com
MAIL_PORT=587
MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_app_password
ALERT_RECIPIENT_EMAIL=admin@smartroutex.com

# Server Settings
PORT=8080
```

---

## 🏁 Getting Started

```bash
# Clone the repository
git clone https://github.com/<yatharthvijay-14/smartroutex-backend.git
cd smartroutex-backend

# Configure environment variables
cp .env.example .env

# Build and run
mvn clean install
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## 📄 License

This project is licensed under the **MIT License**.
