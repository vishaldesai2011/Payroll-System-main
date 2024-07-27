import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DB {
   public static void main(String args[]) throws Exception {
      //Registering the Driver
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      //Getting the connection
      String mysqlUrl = "jdbc:mysql://localhost/python";
      Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
      System.out.println("Connection established......");
      //Creating a Statement object
      Statement stmt = con.createStatement();
      //Retrieving the data
      ResultSet rs = stmt.executeQuery("Show Databases");
      System.out.println("List of databases: ");
      while(rs.next()) {
         System.out.print(rs.getString(1));
         System.out.println();
      }
   }
}