
import java.sql.*; 

class Update{  
	public static void Rupdate(String Name,String Phone,String Email,String DOB,String Gen,String Dep,String Add,String City,String Sal,String acno1,String fetchItem) {
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/ems","root","");  
//here ems is database name, root is username and password  

//String q ="update record(Name,Phone,Email,DOB,Department,Gender,Address,City,Salary) values(?,?,?,?,?,?,?,?,?) where UID = ?";
String q = "UPDATE record SET Name = ?,Phone = ?,Email = ?,DOB = ?,Department = ?,Gender = ?,Address = ?,City = ?,Salary = ?,Account_No = ? WHERE UID = ?";
//get Prepared Statement
 

PreparedStatement psmt = con.prepareStatement(q);
//Set The Value
psmt.setString(1,Name);
psmt.setString(2,Phone);
psmt.setString(3,Email);
psmt.setString(4,DOB);
psmt.setString(5,Dep);
psmt.setString(6,Gen);
psmt.setString(7,Add);
psmt.setString(8,City);
psmt.setString(9,Sal);
psmt.setString(10,acno1);
psmt.setString(11,fetchItem);
psmt.executeUpdate();
System.out.println("Upadte Successfully...."+fetchItem);
con.close();
}catch(Exception e){ System.out.println(e);}    
} 
	public static void main(String []args) {
		Rupdate("Update","909090","d@gmail.com","21-04-2003","Male","IT","Bopal","Ahmedabad","99999","2020202020","MSD073115");
	}
}