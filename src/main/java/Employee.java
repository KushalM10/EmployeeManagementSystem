import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Employee
 */
public class Employee extends HttpServlet {

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/employeeManagemetSystem?user=root&password=kushalmohan@10";
	String sql = "select * from employee";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try (Connection con = DriverManager.getConnection(url); PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			out.println("<!DOCTYPE html>");
			out.println("<html lang='en'>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Employee Management System</title>");
			out.println("<link rel='stylesheet' href='style.css'>");
			out.println("</head>");
			out.println("<body>");

			out.println("<div class='navbar'>");
			out.println("<a href='#' class='logo'>EMS</a>");
			out.println("<ul>");
			out.println("<li><a href='http://localhost:8080/EmployeeManagementSystem/Employee'>Home</a></li>");
			out.println("<li><a href='about.html'>About Us</a></li>");
			out.println("<li><a href='http://localhost:8080/EmployeeManagementSystem/login.html'>Logout</a></li>");
			out.println("</ul>");
			out.println("</div>");

			out.println("<div class='table-container'>");
			out.println("<h2>Employee Management Details</h2>");
			out.println("<a href='addEmployee.html'><button>Add Employee</button></a>");
			out.println("<table>");
			out.println("<thead>");
			out.println(
					"<tr><th>ID</th><th>Name</th><th>Address</th><th>Position</th><th>Salary</th><th>Actions</th></tr>");
			out.println("</thead>");
			out.println("<tbody>");

			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString("id") + "</td>");
				out.println("<td>" + rs.getString("emp_name") + "</td>");
				out.println("<td>" + rs.getString("address") + "</td>");
				out.println("<td>" + rs.getString("position") + "</td>");
				out.println("<td>" + rs.getInt("salary") + "</td>");

				out.println(
						"<td><form action='http://localhost:8080/EmployeeManagementSystem/DeleteEmployee' method='POST'>");
				out.println("<input type='hidden' name='id' value='" + rs.getString("id") + "'>");
				out.println("<button type='submit' style = 'margin:1px'>Delete</button>");
				out.println("</form>");
				out.println(
						"<form action='http://localhost:8080/EmployeeManagementSystem/editEmployee.html' method='POST'>");
				/*
				 * out.println("<input type='hidden' name='id' value='" + rs.getString("id") +
				 * "'>"); out.println("<input type='hidden' name='empname' value='" +
				 * rs.getString("emp_name") + "'><br>");
				 * out.println("<input type='hidden' name='empaddress' value='" +
				 * rs.getString("address") + "'><br>");
				 * out.println("<input type='hidden' name='empposition' value='" +
				 * rs.getString("position") + "'><br>");
				 * out.println("<input type='hidden' name='empsalary' value='" +
				 * rs.getInt("salary") + "'><br>");
				 */
				out.println("<input type='hidden' name='id' value='" + rs.getString("id") + "'>");
				out.println("<button type='submit'style = 'margin:1px'>Update</button>");
				out.println("</form>");
				out.print("</td>");
				/*
				 * out.println("<td><a href='editEmployee.html?id=" + rs.getString("id") +
				 * "'><button>Edit</button></a> | <a href='DeleteEmployee?id=" +
				 * rs.getString("id") + "'><button>Delete</button></a></td>");
				 */
				out.println("</tr>");
			}

			out.println("</tbody>");
			out.println("</table>");
			out.println("</div>");

			out.println("<div class='footer'>");
			out.println("<div class='footer-content'>");
			out.println("<div class='footer-section'>");
			out.println("<h3>Contact</h3>");
			out.println("<p>Email: MHSKY@ems.com</p>");
			out.println("<p>Phone: +123 456 789</p>");
			out.println("</div>");
			out.println("<div class='footer-section'>");
			out.println("<h3>About Us</h3>");
			out.println(
					"<p>Welcome to the Employee Management System. Our system is designed to streamline employee operations efficiently.</p>");
			out.println("<a href='about.html'>Learn more</a>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");

			out.println("</body>");
			out.println("</html>");

			
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
