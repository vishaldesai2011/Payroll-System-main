
import java.sql.*; 
import java.lang.Math; 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

class Insert2{  
public static void main(String args[]){  	
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/ems","root","");  
//here ems is database name, root is username and password  

String q ="insert into record(UID,Name,Phone,Email,DOB,DOJ,Department,Gender,Address,City,Salary) values(?,?,?,?,?,?,?,?,?,?,?)";
//get Prepared Statement
int min = 1000;
int max = 9999;
int UID = (int)(Math.random()*(max-min+1)+min);
String s=String.valueOf(UID);
String U = "MSD07"+s;
System.out.println("Random UID : "+U);

DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy");
LocalDateTime now = LocalDateTime.now();  
String date = dtf.format(now);
System.out.println("Current Date"+dtf.format(now)); 

PreparedStatement psmt = con.prepareStatement(q);
//Set The Value
psmt.setString(1,U);
psmt.setString(2,"John");
psmt.setString(3,"989898989");
psmt.setString(4,"john@gmail.com");
psmt.setString(5,"21-04-2003");
psmt.setString(6,date);
psmt.setString(7,"IT");
psmt.setString(8,"Male");
psmt.setString(9,"Bopal");
psmt.setString(10,"Ahmdabad");
psmt.setString(11,"90000");
psmt.executeUpdate();
System.out.println("Inerted Successfully....");
con.close();
}catch(Exception e){ System.out.println(e);}  
}  
} 