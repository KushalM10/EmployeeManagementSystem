

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	ConnectionDao cod = new ConnectionDao();
	PrintWriter pw = null;
	String sql = "select * from user where username = ? and userpassword = ?";
	
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
			
			cod.ps.setString(1,uname);
			cod.ps.setString(2, pwd);
			cod.rs=cod.ps.executeQuery();
			/*
			 * HttpSession session = null; session.setAttribute(uname, "uname");
			 */
			if(cod.rs.next() == true) {
          	  res.sendRedirect("http://localhost:8080/EmployeeManagementSystem/Employee");
            } else {
          	  res.sendRedirect("http://localhost:8080/EmployeeManagementSystem/failedlogin.html");
            }
			/*
			 * res.setHeader("cache-Control", "no-cache, no-store, must-revalidate"); if
			 * (session.getAttribute("uname") == null) { res.sendRedirect("login.jsp"); }
			 */
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
