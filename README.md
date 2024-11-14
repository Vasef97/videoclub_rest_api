# videoclub_rest_api
This project is a robust Spring Boot API designed to manage videoclubs and their movie collections. It leverages JPA for data persistence and utilizes an H2 in-memory database for local development and testing. It features custom exceptions for better error management and API documentation through OpenAPI.

To run this API please follow these steps:
1. Navigate to videoclub_rest_api dir
2. mvn clean install
3. ./mvn spring-boot:run
4. To access H2 database please visit http://localhost:8080/h2
5. To access API Swagger documentation please visit http://localhost:8080/swagger-ui/index.html
