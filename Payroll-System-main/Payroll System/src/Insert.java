import java.sql.*;

public class Insert {

public static void main(String[] args) {
	System.out.println("MySQL Insert PreparedStatement Example.");
	Connection conn = null;
	PreparedStatement ptmt = null;
	// 3306 is the default port number of MySQL
	// 192.168.10.13 is host address of the MySQL database
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "ems";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root";
	String password = "";
	try {
		// Load the driver
		Class.forName(driver);
		// Get a connection
		conn = DriverManager
				.getConnection(url + dbName, userName, password);
		System.out.println("Connected to the database");
		// Create a query String
		String query = "INSERT INTO record (Name, Phone, Email, DOB,Gender,Department,Address,City,Salary) VALUES (?,?,?,?,?,?,?,?,?)";
		// Create a PreparedStatement
		ptmt = conn.prepareStatement(query);
		ptmt.setString(1,"DAP");
		ptmt.setString(2, "98989898");
		ptmt.setString(3, "A@gmial.com");
		ptmt.setString(4, "21-04-2003");
		ptmt.setString(5, "Male");
		ptmt.setString(6, "IT");
		ptmt.setString(7, "Bopal");
		ptmt.setString(8, "Ahmedabad");
		ptmt.setString(9,"9099");
		ptmt.executeUpdate();

		
		// Closing the connection
		ptmt.close();
		conn.close();
		
		
	} catch (ClassNotFoundException e) {
		System.out.println("Class Not found Exception cought");
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {

		System.out.println("Database Updated Successfully");
		System.out.println("Disconnected from database");
	}

}

}

