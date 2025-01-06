

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditEmployee
 */
public class EditEmployee extends HttpServlet {
	ConnectionDao cod = new ConnectionDao();
	PrintWriter pw = null;
	String sql = "update employee set  emp_name = ?, address = ?, position = ?, salary =? where id = ?";
	
	public void init() {
		try {
			Class.forName(cod.path);
			cod.con = DriverManager.getConnection(cod.url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String empid = req.getParameter("id");
			String empname = req.getParameter("empname");
			String empaddress = req.getParameter("empaddrs");
			String empposition = req.getParameter("emppos");
			String empsalary = req.getParameter("empsalary");
//			int empsalary = Integer.parseInt(salary);
			
			 StringBuilder queryBuilder = new StringBuilder("UPDATE employee SET ");
		        boolean hasUpdates = false;

		        if (empname != null && !empname.trim().isEmpty()) {
		            queryBuilder.append("emp_name = ?, ");
		            hasUpdates = true;
		        }
		        if (empaddress != null && !empaddress.trim().isEmpty()) {
		            queryBuilder.append("address = ?, ");
		            hasUpdates = true;
		        }
		        if (empposition != null && !empposition.trim().isEmpty()) {
		            queryBuilder.append("position = ?, ");
		            hasUpdates = true;
		        }
		        if (empsalary != null && !empsalary.trim().isEmpty()) {
		            queryBuilder.append("salary = ?, ");
		            hasUpdates = true;
		        }

		        if (!hasUpdates) {
		            res.getWriter().println("<h3>No fields to update!</h3>");
		            return;
		        }

		        // Remove the trailing comma and space
		        queryBuilder.setLength(queryBuilder.length() - 2);
		        queryBuilder.append(" WHERE id = ?");
		        
		        cod.ps = cod.con.prepareStatement(queryBuilder.toString());
		        int paramIndex = 1;
	            if (empname != null && !empname.trim().isEmpty()) {
	                cod.ps.setString(paramIndex++, empname);
	            }
	            if (empaddress != null && !empaddress.trim().isEmpty()) {
	                cod.ps.setString(paramIndex++, empaddress);
	            }
	            if (empposition != null && !empposition.trim().isEmpty()) {
	                cod.ps.setString(paramIndex++, empposition);
	            }
	            if (empsalary != null && !empsalary.trim().isEmpty()) {
	                cod.ps.setString(paramIndex++,empsalary);
	            }

	            // Set empid as the last parameter
	            cod.ps.setString(paramIndex, empid);
			
			int nora = cod.ps.executeUpdate();
			
			if(nora == 1) {
				res.sendRedirect("http://localhost:8080/EmployeeManagementSystem/Employee");
			}else {
				res.sendRedirect("http://localhost:8080/EmployeeManagementSystem/editEmployee.html");
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
