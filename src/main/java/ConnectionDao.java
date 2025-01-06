import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/employeeManagemetSystem?user=root&password=kushalmohan@10";

}
