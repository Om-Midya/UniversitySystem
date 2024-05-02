# University System

## Description
This is a Spring Boot application that manages the admission process of a university. It allows for the creation, retrieval, update, and deletion of admissions. It also provides endpoints to get admissions by program and applicant.

## Technologies Used
- Java
- Spring Boot
- Maven
- MySQL

## Getting Started

### Prerequisites
- Java 11
- MySQL
- Maven

### Installation
1. Clone the repository to your local machine using `git clone https://github.com/your-repository-url`.
2. Navigate to the project directory.

### Configuration
Update the `src/main/resources/application.properties` file with your MySQL configuration:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
```

### Running the Application
You can run the application using Maven with the following command:
```bash
mvn spring-boot:run
```

## Usage
The application provides a RESTful API for managing admissions. Here are some example endpoints:

- `GET /admissions`: Get all admissions.
- `POST /admissions`: Create a new admission.
- `GET /admissions/{id}`: Get an admission by id.
- `PUT /admissions/{id}`: Update an admission.
- `DELETE /admissions/{id}`: Delete an admission.
- `GET /admissions/program/{programId}`: Get all admissions for a specific program.
- `GET /admissions/applicant/{applicantId}`: Get all admissions for a specific applicant.

## Endpoints
- `/admissions`: GET, POST
- `/admissions/{id}`: GET, PUT, DELETE
- `/admissions/program/{programId}`: GET
- `/admissions/applicant/{applicantId}`: GET

## Models
The application uses the following models:

### Admission
- `id`: Long
- `applicant`: Applicant
- `program`: Program
- `decision`: String
- `decision_date`: Date

### Applicant
- `id`: Long
- `name`: String
- `email`: String

### Program
- `id`: Long
- `name`: String

## Database Schema
The application uses a MySQL database with tables for `Admission`, `Applicant`, and `Program`. The `Admission` table has a composite unique constraint on `applicant_id` and `program_id`.

## Deployment
To deploy the application to a production environment, you would typically build a deployable artifact such as a JAR file using Maven, and then deploy this artifact to your production environment.

## Contributing
If you would like to contribute to this project, please fork the repository and submit a pull request.

## Acknowledgments
Thanks to all contributors and users of this project.

## Contact
For any questions or concerns, please contact Om Midya at om.midya@example.com or via [GitHub](https://github.com/om-midya)

## Project Contributors
This project has been made possible by the contributions of various individuals. Here's a breakdown of who did what:

- **Archisman Midya**: Worked on the Applicant Module and Program Module.
- **Ajai Sharan**: Contributed to the Department Module.
- **Harsh Panchal**: Focused on designing aspects and DTOs (Data Transfer Objects).
- **Pradyut Fogla**: Contributed to both the Admission module and Program module.
- **Purvansh Sahu**: Specialized in exception handling.
- **Sheza Mishal**: Worked on creating the models.
```

This updated README.md file includes the information about all the possible endpoints and model implementation.
