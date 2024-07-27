import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
//import java.awt.*;
//import javax.swing.Delete.DefaultDeleteModel;
//import javax.swing.Delete.JDeleteHeader;

public class Delete 
{
	Delete(){
		 try 
		  {
		      String url = "jdbc:mysql://localhost:3306/ems?autoReconnect=true&useSSL=false";
		      String user = "root";
		      String password = "";
		    
		      Connection con = DriverManager.getConnection(url, user, password);
		      Statement stm = con.createStatement();
		    
		      String query = "SELECT * FROM record";
		      
		      ResultSet rs = stm.executeQuery(query);
		      //Retrieving the result
		      rs.next();
		      int count = rs.getInt(1);
		      System.out.println(count);
		    
		    
		      ResultSet res = stm.executeQuery(query);
		      
		      
		      List<String> list = new LinkedList<String>();
		      String columns[] = { "ID", "Name", "Phone","Email","DOB","Gender","Address","City","Salary"};
//		      String data[];
		      String data[];
		    
		      int i = 0;
		      while (res.next()) {
		        int id = res.getInt("id");
		        int sal = res.getInt("Salary");
		        String Name = res.getString("Name");
		        String Phone = res.getString("Phone");
		        String Email = res.getString("Email");
		        String DOB = res.getString("DOB");
		        String Gender = res.getString("Gender");
		        String Add = res.getString("Address");
		        String City = res.getString("City");
//		        String sal = res.("Salary");
		        
		        System.out.println(Name);
		        list.add(Name);
		        i++;
		      }
		      for (int j = 0; j < list.size(); j++) {
		            System.out.println(j +" = "+list.get(j));
		        }
		      
//		      Convert List TO Array
		      String[] arr = new String[list.size()];
		      for (int j = 0; j < list.size(); j++)
		            arr[j] = list.get(j);
		    
		      
//		     obj=new a();
//		    
 
		      
		    
		    } catch(SQLException e) {
		      e.printStackTrace();
		    }
	}
	
	
	
  public static void main(String[] args) 
  {
   new Delete();
  }
}