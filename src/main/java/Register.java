

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	ConnectionDao cod = new ConnectionDao();
	PrintWriter pw = null;
	String sql = "insert into user(username, gmail, userpassword) values(?,?,?)";
	
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
			String uname = req.getParameter("username");
			String pwd = req.getParameter("password");
			String gmail = req.getParameter("email");
			
			cod.ps.setString(1, uname);
			cod.ps.setString(2, gmail);
			cod.ps.setString(3, pwd);
			
			int nora = cod.ps.executeUpdate();
			if(nora == 1) {
				
				res.sendRedirect("http://localhost:8080/EmployeeManagementSystem/login.html");
			} else {
				res.sendRedirect("http://localhost:8080/EmployeeManagementSystem/failregister.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
        try {
            cod.rs.close();
            cod.ps.close();
            cod.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	 }

}
