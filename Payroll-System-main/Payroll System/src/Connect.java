import java.sql.*;  
class Connect{  
public static void main(String args[]){  
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/ems","root","");  
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("SELECT * FROM record");  
	while(rs.next())
	{
		 int id = rs.getInt("id");
		String Name = rs.getString("Name");	
		String Phone = rs.getString("Phone");
		String Email = rs.getString("Email");
		
	System.out.println(" ID : "+id+"\n Name : "+Name+"\n Phone : "+Phone+"\n Email : "+Email);
	}
	//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	con.close();  
	}catch(Exception e){ System.out.println(e);}  
	}  
	}  