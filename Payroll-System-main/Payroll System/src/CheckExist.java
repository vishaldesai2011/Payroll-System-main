import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckExist {
	
//	String Name = "Dhruv";
//	String DOB = "21-04-2003";
public static void dat()

{
try {
		      String url = "jdbc:mysql://localhost:3306/ems?autoReconnect=true&useSSL=false";
		      String user = "root";
		      String password = "";
		    
		      Connection con = DriverManager.getConnection(url, user, password);

		     String query= "SELECT EXISTS(SELECT * from payroll WHERE (UID=? AND Pay_Month = ?) ) AS Result";
		      PreparedStatement psmt = con.prepareStatement(query);
		      psmt.setString(1,"AA001");
		      psmt.setString(2,"April-2022");
		      
		      ResultSet rs = psmt.executeQuery();

		    		  while (rs.next()) {
		  		        String e1 = rs.getString("Result");
		  		      System.out.println(e1);

		  		        
		  		      }
		  con.close();
		  } catch(SQLException e) {
		      e.printStackTrace();
		    }
}
public static void main(String []args) {
	dat();
}
}
	
