
import java.sql.*; 
import java.lang.Math; 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

class CheckInsert{  
	public static void insert(String Name,String Phone,String Email,String DOB,String Gen,String Dep,String Add,String City,String Sal,String acno) {
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/ems","root","");  
//here ems is database name, root is username and password  

String q ="insert into record(UID,Name,Phone,Email,DOB,DOJ,Department,Gender,Address,City,Salary,Account_No) values(?,?,?,?,?,?,?,?,?,?,?,?)";
//get Prepared Statement
int min = 1000;
int max = 9999;
int UID = (int)(Math.random()*(max-min+1)+min);
String s=String.valueOf(UID);
String U = "MSD07"+s;
System.out.println("Random UID :- "+U);

DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
LocalDateTime now = LocalDateTime.now();  
String date = dtf.format(now);
System.out.println("Current Date:- "+dtf.format(now)); 

PreparedStatement psmt = con.prepareStatement(q);
//Set The Value
psmt.setString(1,U);
psmt.setString(2,Name);
psmt.setString(3,Phone);
psmt.setString(4,Email);
psmt.setString(5,DOB);
psmt.setString(6,date);
psmt.setString(7,Dep);
psmt.setString(8,Gen);
psmt.setString(9,Add);
psmt.setString(10,City);
psmt.setString(11,Sal);
psmt.setString(12,acno);
psmt.executeUpdate();
System.out.println("Inerted Successfully....");
con.close();
}catch(Exception e){ System.out.println(e);}    
} 
	public static void main(String []args) {
		insert("Dhurv","909090","d@gmail.com","21-04-2003","Male","IT","Bopal","Ahmedabad","99999","202817261523");
	}
}