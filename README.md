# Employee Attendance Management System - Backend

This is the backend implementation of an Employee Attendance Management System. It provides RESTful APIs for managing employees and attendance records.

## Features

- CRUD operations for managing employees
- CRUD operations for managing attendance records


## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySql

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine
- MySql database installed 


### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/SantoshAcharya1200/spring-boot.git
   ```

2. Configure the database settings in src/main/resources/application.properties.
     ```
      spring.datasource.url=jdbc:mysql://localhost:3306/ems?useSSL=false
      spring.datasource.username=ur_username
      spring.datasource.password=ur_password

      spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect

      spring.jpa.hibernate.ddl-auto = update

      logging.level.com.employeeattendance.springboot=DEBUG
     ```
3. Run the application.
4. The backend server should now be running on http://localhost:8080.
