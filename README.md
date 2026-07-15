# 🛒 E-Commerce Backend API

> **A secure RESTful E-Commerce Backend built using Spring Boot, Spring Security, JWT Authentication, MySQL, JPA/Hibernate, and Swagger UI.**

This project demonstrates secure authentication, role-based authorization, product management, pagination, sorting, searching, filtering, and complete REST API documentation.

---

# 🌐 Live Demo

## 🚀 Swagger UI

### https://ecommerce-backend-kohi.onrender.com/swagger-ui/index.html

---

# 🔑 Demo Accounts

## 👤 User Account

Create a new account using:
```
POST /api/auth/register
```

Login using your registered credentials to receive a JWT token.

## 👑 Admin Account

**Email**
```
Admin@gmail.com

**Password**

Admin211
```

Use the Admin account to test all protected APIs.

---

## 🖼 Sample Image URL

Use the following image while creating a product.

```
https://images.unsplash.com/photo-1496181133206-80ce9b88a853
```

---

# ✨ Features

## 🔐 Authentication

- User Registration
- User Login
- JWT Authentication
- BCrypt Password Encryption
- Role-Based Authorization
- Secure API Access

---

## 📦 Product Management

- Create Product (Admin)
- Update Product (Admin)
- Delete Product (Admin)
- Get All Products
- Get Product By ID
- Search Products
- Filter Products by Price
- Pagination
- Sorting

---

## 🛡 Security

- Spring Security
- JWT Token Validation
- Role-Based Access Control
- Custom Access Denied Handler
- Global Exception Handling

---

## 📖 API Documentation

- Swagger UI
- Interactive API Testing

---

# 🚀 Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger (OpenAPI)
- Docker
- Git & GitHub
- Render
- Railway MySQL

---

# 📂 Project Structure

```text
src
│
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
└── util
```

---

# ⚙ Installation

## 1️⃣ Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
```

---

## 2️⃣ Open Project

Open the project using:

- IntelliJ IDEA
- VS Code

---

## 3️⃣ Create MySQL Database

Database Name

```text
ecommerce
```

---

## 4️⃣ Configure application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

---

## 5️⃣ Run Application

Using Maven

```bash
mvn spring-boot:run
```

or simply run

```
BackendApplication.java
```

---

# 📖 Swagger Documentation

Open

### https://ecommerce-backend-kohi.onrender.com/swagger-ui/index.html

---

# 🔐 Authentication Guide

## Register

```
POST /api/auth/register
```

Create a new account.

---

## Login

```
POST /api/auth/login
```

Login returns a JWT Token.

Copy the token.

Click **Authorize** in Swagger.

Enter

```
Bearer YOUR_JWT_TOKEN
```

Now all protected APIs can be accessed.

---

# 👥 Roles & Permissions

## USER

✔ View Products

---

## ADMIN

✔ Create Products

✔ Update Products

✔ Delete Products

--

---

## Filter Products

```
GET /api/products/filter?minPrice=1000&maxPrice=5000
```

---

## Pagination

```
GET /api/products?page=0&size=5&sortBy=id
```

---

# ☁ Deployment

## Backend

**Render**

## Database

**Railway MySQL**

---

# 🚧 Future Improvements

- Shopping Cart
- Order Management
- Payment Gateway Integration
- Cloud Image Upload
- Refresh Token 
Authentication
- Unit Testing (JUnit)
- Docker Compose
- CI/CD Pipeline

---

# 👨‍💻 Author

## Rajat Sharma

**Java Backend Developer**

GitHub
```
https://github.com/rajatsharma11210

```

---

# ⭐ Support

If you found this project helpful, consider giving it a **Star ⭐** on GitHub.

