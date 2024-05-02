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


### Class Diagram
<img src="https://github.com/purvanshh/UniversitySystem/assets/147030767/60c010d3-5fd9-4870-a65f-08317589f2ff" alt="Class Diagram" width="500">

### Database Schema Diagram
<img src="https://github.com/purvanshh/UniversitySystem/assets/147030767/0de4f705-db6f-4798-887f-415dae53461b" alt="Database Schema Diagram" width="500">



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
### Department
- id : Long
- name : String

# Controllers

This document provides an overview of the controllers in the project.

## Admission Controller

The AdmissionController is a REST controller that provides endpoints for managing admissions in the university system. It uses the AdmissionService to perform operations related to admissions.

### Endpoints

- GET /admissions: Get all admissions.
- POST /admissions: Create a new admission.
- GET /admissions/{id}: Get an admission by id.
- PUT /admissions/{id}: Update an admission.
- DELETE /admissions/{id}: Delete an admission.
- GET /admissions/program/{programId}: Get all admissions for a specific program.
- GET /admissions/applicant/{applicantId}: Get all admissions for a specific applicant.

### Usage

#### Get all admissions

To get all admissions, send a GET request to /admissions.

#### Create a new admission

To create a new admission, send a POST request to /admissions with the admission data in the request body.

#### Get an admission by id

To get an admission by id, send a GET request to /admissions/{id} where {id} is the id of the admission.

#### Update an admission

To update an admission, send a PUT request to /admissions/{id} where {id} is the id of the admission. Include the updated admission data in the request body.

#### Delete an admission

To delete an admission, send a DELETE request to /admissions/{id} where {id} is the id of the admission.

#### Get all admissions for a specific program

To get all admissions for a specific program, send a GET request to /admissions/program/{programId} where {programId} is the id of the program.

#### Get all admissions for a specific applicant

To get all admissions for a specific applicant, send a GET request to /admissions/applicant/{applicantId} where {applicantId} is the id of the applicant.

## Applicant Controller

The ApplicantController is a REST controller that provides endpoints for managing applicants in the university system. It uses the ApplicantService to perform operations related to applicants.

### Endpoints

- GET /applicants: Get all applicants.
- POST /applicants: Create a new applicant.
- GET /applicants/{id}: Get an applicant by id.
- PUT /applicants/{id}: Update an applicant.
- DELETE /applicants/{id}: Delete an applicant.

### Usage

#### Get all applicants

To get all applicants, send a GET request to /applicants.

#### Create a new applicant

To create a new applicant, send a POST request to /applicants with the applicant data in the request body.

#### Get an applicant by id

To get an applicant by id, send a GET request to /applicants/{id} where {id} is the id of the applicant.

#### Update an applicant

To update an applicant, send a PUT request to /applicants/{id} where {id} is the id of the applicant. Include the updated applicant data in the request body.

#### Delete an applicant

To delete an applicant, send a DELETE request to /applicants/{id} where {id} is the id of the applicant.

## Department Controller

The DepartmentController is a REST controller that provides endpoints for managing departments in the university system. It uses the DepartmentService to perform operations related to departments.

### Endpoints

- GET /departments: Get all departments.
- POST /departments: Create a new department.
- GET /departments/{id}: Get a department by id.
- PUT /departments/{id}: Update a department.
- DELETE /departments/{id}: Delete a department.

### Usage

#### Get all departments

To get all departments, send a GET request to /departments.

#### Create a new department

To create a new department, send a POST request to /departments with the department data in the request body.

#### Get a department by id

To get a department by id, send a GET request to /departments/{id} where {id} is the id of the department.

#### Update a department

To update a department, send a PUT request to /departments/{id} where {id} is the id of the department. Include the updated department data in the request body.

#### Delete a department

To delete a department, send a DELETE request to /departments/{id} where {id} is the id of the department.

## Program Controller

The ProgramController is a REST controller that provides endpoints for managing programs in the university system. It uses the ProgramService to perform operations related to programs.

### Endpoints

- GET /programs: Get all programs.
- POST /programs: Create a new program.
- GET /programs/{id}: Get a program by id.
- PUT /programs/{id}: Update a program.
- DELETE /programs/{id}: Delete a program.

### Usage

#### Get all programs

To get all programs, send a GET request to /programs.

#### Create a new program

To create a new program, send a POST request to /programs with the program data in the request body.

#### Get a program by id

To get a program by id, send a GET request to /programs/{id} where {id} is the id of the program.

#### Update a program

To update a program, send a PUT request to /programs/{id} where {id} is the id of the program. Include the updated program data in the request body.

#### Delete a program

To delete a program, send a DELETE request to /programs/{id} where {id} is the id of the program.

## Exception Handlers

### Global Exception Handler

The GlobalExceptionHandler is a class that handles all exceptions thrown by the application. It uses the @ControllerAdvice annotation to provide global exception handling.

- handleApplicantNotFoundException(ApplicantNotFoundException ex): Handles ApplicantNotFoundException and returns a NOT_FOUND status.
- handleDepartmentNotFoundException(DepartmentNotFoundException ex): Handles DepartmentNotFoundException and returns a NOT_FOUND status.
- handleProgramNotFoundException(ProgramNotFoundException ex): Handles ProgramNotFoundException and returns a NOT_FOUND status.
- handleAdmissionNotFoundException(AdmissionNotFoundException ex): Handles AdmissionNotFoundException and returns a NOT_FOUND status.
- handleInsufficientDataException(InsufficientDataException ex): Handles InsufficientDataException and returns a BAD_REQUEST status.
- handleIllegalArgumentException(IllegalArgumentException ex): Handles IllegalArgumentException and returns a BAD_REQUEST status.
- handleDataIntegrityViolationException(DataIntegrityViolationException ex): Handles DataIntegrityViolationException and returns a CONFLICT status.
- handleGeneralException(Exception ex): Handles all other exceptions and returns an INTERNAL_SERVER_ERROR status.

### Usage

The GlobalExceptionHandler is automatically used by Spring to handle exceptions thrown by the application. When an exception is thrown, the corresponding handler method in the GlobalExceptionHandler is invoked, and it returns a ResponseEntity with an appropriate HTTP status and error message.

For example, if an ApplicantNotFoundException is thrown, the handleApplicantNotFoundException method is invoked, and it returns a ResponseEntity with a NOT_FOUND status and the message from the exception.

## Exceptions

This section provides an overview of the custom exceptions in the project.

### ApplicantNotFoundException

This exception is thrown when an applicant with a specified id cannot be found in the database.

### DepartmentNotFoundException

This exception is thrown when a department with a specified id cannot be found in the database.

### ProgramNotFoundException

This exception is thrown when a program with a specified id cannot be found in the database.

### AdmissionNotFoundException

This exception is thrown when an admission with a specified id cannot be found in the database.

### InsufficientDataException

This exception is thrown when the provided data for a certain operation is insufficient or incomplete.

### Usage

These exceptions are typically thrown by the service classes when a certain condition is not met. For example, if an attempt is made to retrieve an applicant with an id that does not exist in the database, the ApplicantService would throw an ApplicantNotFoundException.

The GlobalExceptionHandler class is responsible for handling these exceptions. When an exception is thrown, the corresponding handler method in the GlobalExceptionHandler is invoked, and it returns a ResponseEntity with an appropriate HTTP status and error message.

For example, if an ApplicantNotFoundException is thrown, the handleApplicantNotFoundException method in the GlobalExceptionHandler is invoked, and it returns a ResponseEntity with a NOT_FOUND status and the message from the exception.

## Services

This section provides an overview of the services in the project.

### Admission Service

The AdmissionService is a service class that handles the business logic related to admissions. It is used by the AdmissionController to perform operations related to admissions.

#### Methods

- getAllAdmissions(): Returns a list of all admissions.
- getAdmissionById(Long id): Returns the admission with the specified id.
- createAdmission(Admission admission): Creates a new admission and returns it.
- updateAdmission(Long id, Admission admission): Updates the admission with the specified id and returns the updated admission.
- deleteAdmission(Long id): Deletes the admission with the specified id.
- getAdmissionsByProgram(Long programId): Returns a list of all admissions for the specified program.
- getAdmissionsByApplicant(Long applicantId): Returns a list of all admissions for the specified applicant.

### Applicant Service

The ApplicantService is a service class that handles the business logic related to applicants. It is used by the ApplicantController to perform operations related to applicants.

#### Methods

- getAllApplicants(): Returns a list of all applicants.
- getApplicantById(Long id): Returns the applicant with the specified id.
- createApplicant(Applicant applicant): Creates a new applicant and returns it.
- updateApplicant(Long id, Applicant applicant): Updates the applicant with the specified id and returns the updated applicant.
- deleteApplicant(Long id): Deletes the applicant with the specified id.

### Department Service

The DepartmentService is a service class that handles the business logic related to departments. It is used by the DepartmentController to perform operations related to departments.

#### Methods

- getAllDepartments(): Returns a list of all departments.
- getDepartmentById(Long id): Returns the department with the specified id.
- createDepartment(Department department): Creates a new department and returns it.
- updateDepartment(Long id, Department department): Updates the department with the specified id and returns the updated department.
- deleteDepartment(Long id): Deletes the department with the specified id.

### Program Service

The ProgramService is a service class that handles the business logic related to programs. It is used by the ProgramController to perform operations related to programs.

#### Methods

- getAllPrograms(): Returns a list of all programs.
- getProgramById(Long id): Returns the program with the specified id.
- createProgram(Program program): Creates a new program and returns it.
- updateProgram(Long id, Program program): Updates the program with the specified id and returns the updated program.
- deleteProgram(Long id): Deletes the program with the specified id.
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
```

This updated README.md file includes the information about all the possible endpoints and model implementation.
