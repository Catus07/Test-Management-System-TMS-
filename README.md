# Test-Management-System-TMS
The Test Management System (TMS) is a backend solution built using Spring Boot that enables teams to manage software testing processes efficiently. It supports multiple user roles and provides role-based functionalities for managing test cases, submitting bug reports, and managing users.
# Test Management System (TMS)
Features

###  Admin
- Add new **Testers** and **Developers**
- Manage users

### Developer
- Upload **test cases**
- View uploaded test reports

###  Tester
- View assigned test cases
- Submit **test reports** based on findings

---

## Tech Stack

- **Java 17** / **Spring Boot**
- **Spring Security + JWT**
- **Spring Data JPA**
- **MySQL** (can be changed)
- **Lombok**
- **Swagger** for API documentation
- **Postman** for testing

---

## Authentication

This application uses **JWT (JSON Web Token)** for secure authentication. Each user role (Admin, Developer, Tester) receives a token upon login which must be included in the header for all protected endpoints.

---

## API Documentation

API endpoints are documented using **Swagger UI**.

>  Access Swagger UI at:  
> `http://localhost:8080/swagger-ui/index.html`

---

## How to Run

1. **Clone the project**
   ```bash
   git clone https://github.com/Catus07/test management system (tms).git
   cd tms-backend
   
API Usage via Postman

  You can test the API using Postman

    Sample collections:

        Login & JWT Authorization

        Admin: Register Developer / Tester

        Developer: Upload Test Case

        Tester: Submit Test Report

Developer Notes

Packages are structured by features:

    controller – REST controllers
    dto – Data transfer objects
    service – Business logic
    model – JPA Entities
    repo – Spring Data Repositories
    config – JWT and security configurations
    Passwords are encrypted using PasswordEncoder
    Uses CORS config to allow frontend integration

Future Enhancements
    Add a frontend with Vue.js or React
    Role dashboards for Admin/Developer/Tester
    Email notifications for assigned tests

Author
Revocatus Joseph
    GitHub: @RevocatusJoseph
License
This project is open-source and free to use under the MIT License.

