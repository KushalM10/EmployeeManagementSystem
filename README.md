# Employee Management System

The Employee Management System is a web-based application designed to manage employee records efficiently. It provides functionality to view, add, update, and delete employee details, making the process seamless for administrators. This project is built using Java Servlets, JSP, and MySQL.

## Features

1. **Employee List**:
   - Displays all employee details including ID, name, address, position, and salary.

2. **Add Employee**:
   - Allows administrators to add new employee records.

3. **Edit Employee**:
   - Enables updating specific employee details selectively.

4. **Delete Employee**:
   - Allows the removal of employee records from the system.

5. **Authentication**:
   - Secure login/logout functionality for administrators.

6. **Responsive Design**:
   - Styled with HTML and CSS for a clean and user-friendly interface.

## Technologies Used

- **Frontend**:
  - HTML
  - CSS

- **Backend**:
  - Java Servlets

- **Database**:
  - MySQL

## Requirements

1. JDK 11 or higher
2. Apache Tomcat 9 or higher
3. MySQL 8.0 or higher
4. A web browser

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/EmployeeManagementSystem.git
   ```

2. Import the project into your favorite IDE (e.g., IntelliJ IDEA, Eclipse).

3. Configure the database:
   - Create a MySQL database named `employeeManagementSystem`.
   - Import the provided SQL script (`schema.sql`) to create the necessary tables.

4. Update the database credentials in the code:
   ```java
   String url = "jdbc:mysql://localhost:3306/employeeManagementSystem?user=root&password=your-password";
   ```

5. Deploy the application on Tomcat:
   - Place the compiled WAR file in the `webapps` directory of your Tomcat server.

6. Start the server and access the application at:
   ```
   http://localhost:8080/EmployeeManagementSystem
   ```

## Usage

1. Login with the administrator credentials.
2. Navigate to the home page to view the employee list.
3. Use the "Add Employee" button to add new records.
4. Use the "Update" and "Delete" buttons in the actions column for respective operations.
5. Logout securely after use.

## File Structure

```
EmployeeManagementSystem/
|-- src/
|   |-- main/
|       |-- java/
|           |-- servlets/
|               |-- Login.java
|               |-- Employee.java
|               |-- AddEmployee.java
|               |-- EditEmployee.java
|               |-- DeleteEmployee.java
|-- web/
    |-- WEB-INF/
        |-- web.xml
    |-- style.css
    |-- addEmployee.html
    |-- editEmployee.html
    |-- login.html
    |-- about.html
```

## Screenshots

1. **Login Page**:
   - Secure administrator login.

2. **Employee List**:
   - View all employee details with options to edit or delete.

3. **Add Employee**:
   - Simple form for adding new records.

## Contributors
- Kushal(https://github.com/your-username)

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

