# 🛒 E-Commerce Backend API

A secure RESTful E-Commerce Backend built using Spring Boot, Spring Security, JWT Authentication, MySQL, and JPA/Hibernate.

This project demonstrates authentication, authorization, product management, pagination, sorting, searching, filtering, and API documentation using Swagger.

TSET -
https://ecommerce-backend-kohi.onrender.com/swagger-ui/index.html
---
ACCOUNTS -
FOR USER - You Can Use Any Random Gmail ,name ,password then login with it and reade for instruction below.
FOR ADMIN - email - Admin@gmail.com
password - Admin211


# 🚀 Features

## Authentication
- User Registration
- User Login
- JWT Authentication
- BCrypt Password Encryption
- Role-Based Authorization (ADMIN & USER)

## Product Management
- Create Product (ADMIN)
- Update Product (ADMIN)
- Delete Product (ADMIN)
- Get Product By ID
- Get All Products
- Pagination
- Sorting
- Search Products
- Filter Products by Price

## Security
- Spring Security
- JWT Token Validation
- Custom Access Denied Handler
- Global Exception Handling

## Documentation
- Swagger UI

---

# 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger (OpenAPI)

---

# 📁 Project Structure

controller/

service/

repository/

entity/

dto/

security/

exception/

config/

---

# ⚙️ Installation

## 1. Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
```

## 2. Open Project

Open the project in:

- IntelliJ IDEA
- VS Code

---

## 3. Create Database

Database Name

```
ecommerce
```

---

## 4. Configure application.properties

Update your MySQL username and password.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```
---

## 5. Run Project

```bash
mvn spring-boot:run
```

or simply run

```
BackendApplication.java
```

---

# 📖 Swagger Documentation

Open:

https://ecommerce-backend-kohi.onrender.com/swagger-ui/index.html

# 🔐 Authentication

## Register

POST

```
/api/auth/register
```

---

## Login

POST

```
/api/auth/login
```

Login returns a JWT Token.

Copy the token.

Click **Authorize** in Swagger.

Enter

```
Bearer YOUR_TOKEN
```

Now protected APIs can be accessed.

---

# 👤 User Permissions

USER can

- View Products

ADMIN can

- Create Product
- Update Product
- Delete Product

---

# 📦 Product APIs

GET

```
/api/products
```

Get Product By ID

```
/api/products/{id}
```

Search Product

```
/api/products/search?keyword=laptop
```

Filter Product

```
/api/products/filter?minPrice=1000&maxPrice=5000
```

Pagination

```
/api/products?page=0&size=5&sortBy=id
```

# 📌 Future Improvements

- Docker
- Image Upload
- Cloud Storage
- Deployment
- Unit Testing
- Refresh Token Authentication
---

# 👨‍💻 Author

Rajat Sharma

Java Backend Developer
