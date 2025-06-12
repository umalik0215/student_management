# 🧑‍🎓 Student Management API

A Spring Boot-based RESTful application for managing student records. This project supports CRUD operations (Create, Read, Update, Delete) on student data with validations and CORS configuration for frontend integration (e.g., Angular at `localhost:4200`).

---

## 📁 Project Structure
├── controller # REST API endpoints
├── service # Business logic layer
├── repository # Spring Data JPA interface
├── model # Student entity
├── validation # Input data validation logic
├── helper # Configurations like CORS


---

## 🚀 Features

- Add, update, delete, and list student records
- Data validation based on request type
- CORS support for frontend clients
- Uses Spring Boot, Spring Data JPA, and Hibernate

---

## 🔧 Technologies Used

- Java 11+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (or any JPA-compatible DB)
- Maven
- Git

---

## 📦 API Endpoints

Base URL: `/api/students`

| Method | Endpoint                       | Description                    |
|--------|--------------------------------|--------------------------------|
| POST   | `/`                            | Create a new student           |
| GET    | `/`                            | Retrieve all students          |
| GET    | `/get-by-name/{studentName}`   | Get a student by name          |
| PUT    | `/`                            | Update existing student        |
| DELETE | `/{studentName}`               | Delete student by name         |

### 📝 Request/Response Format

All endpoints return a custom `ResponsesEntity` object that contains either the result data or validation messages.

#### Example `Student` JSON:
```json
{
  "name": "John Doe",
  "age": "16",
  "studentClass": "10th Grade",
  "phone": 1234567890
}
For create: ensures student does not already exist

For update/delete: ensures student exists
```

🌐 CORS Configuration
CORS is enabled for http://localhost:4200

Supports GET, POST, PUT, DELETE, and OPTIONS methods

All headers allowed

This allows seamless frontend integration with Angular or React applications running locally.

Getting Started
Prerequisites
Java 11+

Maven

MySQL or other supported DB

Steps
Clone the repository
git clone https://github.com/<your-username>/student_management.git
cd student_management

Configure the database in application.properties
Run the application
  mvn spring-boot:run
  
Access the API at http://localhost:8080/api/students

