

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet {
	ConnectionDao cod = new ConnectionDao();
	PrintWriter pw = null;
	String sql = "insert into employee values(?,?,?,?,?)";
	
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
			String empid = req.getParameter("empid");
			String empname = req.getParameter("empname");
			String empaddress = req.getParameter("empaddrs");
			String empposition = req.getParameter("emppos");
			String salary = req.getParameter("empsalary");
			int empsalary = Integer.parseInt(salary);
			cod.ps.setString(1, empid);
			cod.ps.setString(2, empname);
			cod.ps.setString(3, empaddress);
			cod.ps.setString(4, empposition);
			cod.ps.setInt(5, empsalary);
			
			int nora = cod.ps.executeUpdate();
			if(nora == 1) {
				res.sendRedirect("http://localhost:8080/EmployeeManagementSystem/Employee");
			} else {
				res.sendRedirect("http://localhost:8080/EmployeeManagementSystem/addEmployee.html");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public void destroy() {
         try {
             cod.ps.close();
             cod.con.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
	 }
}
