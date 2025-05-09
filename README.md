# CRUD-OPERATION
CRUD operations—Create, Read, Update, and Delete—are fundamental for managing data in applications. Here’s how they work in a full-stack setup using Java, Spring Boot, React, MySQL, and Postman:

### **Backend (Java & Spring Boot)**
- **Create:** The backend exposes an API endpoint (e.g., `http://localhost:8080/api/employee`) to accept POST requests. Spring Boot handles incoming JSON data, maps it to an entity, and saves it in MySQL using JPA.
- **Read:** A GET request to an endpoint (e.g., `/api/employee/{id}`) retrieves data from MySQL using JPA or native queries and returns the response.
- **Update:** PUT or PATCH requests modify existing records. Spring Boot updates database entries by mapping new data to an entity.
- **Delete:** DELETE requests remove records based on an ID, ensuring data cleanup.

### **Frontend (React)**
- React interacts with the backend through API calls, sending requests via `fetch` or `axios`. It dynamically updates UI based on API responses.

### **Database (MySQL)**
- MySQL stores structured data, while Spring Boot interacts with it using JPA and Hibernate for efficient query management.

### **API Testing (Postman)**
- Postman helps send requests (POST, GET, PUT, DELETE) to verify API functionality before integrating with React.

![image_alt](https://github.com/Inzamx/CRUD-OPERATION/blob/0728c5a68d8c6226bb4d8306c54867fe43164d84/Screenshot%202025-05-09%20201347.png)
