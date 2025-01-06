

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteEmployee
 */
public class DeleteEmployee extends HttpServlet {
	ConnectionDao cod = new ConnectionDao();
	
	String sql = "delete from employee where id = ?";
	
	public void init() {
		try {
			Class.forName(cod.path);
			cod.con = DriverManager.getConnection(cod.url);
			cod.ps = cod.con.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String empid = req.getParameter("id");
			
			cod.ps.setString(1, empid);
			
			int nora = cod.ps.executeUpdate();
			if(nora == 1) {
				res.sendRedirect("http://localhost:8080/EmployeeManagementSystem/Employee");
			}else {
				/*
				 * PrintWriter pw = res.getWriter(); pw.print("Invalid employee");
				 */
				res.sendRedirect("http://localhost:8080/EmployeeManagementSystem/Employee");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void distroy() {
		  try {
	          cod.ps.close();
	          cod.con.close();
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
		 }

}
