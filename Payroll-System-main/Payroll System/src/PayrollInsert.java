
import java.sql.*; 
    

class PayrollInsert{  
	public static void payrollinsert(String Name,String UID,String DOB,String DOJ,String days,String Dep,String basic,String acno,String working,String Pay_month) {
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/ems","root","");  
//here ems is database name, root is username and password  

String q ="insert into payroll(Name,UID,DOB,DOJ,Pay_Month,Department,Working_days,basic,Account_No,Total_days) values(?,?,?,?,?,?,?,?,?,?)";


PreparedStatement psmt = con.prepareStatement(q);
//Set The Value
psmt.setString(1,Name);
psmt.setString(2,UID);
psmt.setString(3,DOB);
psmt.setString(4,DOJ);
psmt.setString(5,Pay_month);
psmt.setString(6,Dep);
psmt.setString(7,working);
psmt.setString(8,basic);
psmt.setString(9,acno);
psmt.setString(10,days);
//psmt.setString(11,DA);
psmt.executeUpdate();
System.out.println("Inerted Successfully....");
con.close();
}catch(Exception e){ System.out.println(e);}    
} 
	public static void main(String []args) {
//		payrollinsert("Dhurv","909090","d@gmail.com","21-0-12","21-04-2003","21","Male","IT","Bopal","Ahmedabad","99999","202817261523");
	}
}