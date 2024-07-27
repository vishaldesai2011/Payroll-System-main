import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
//import java.awt.*;
//import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Table 
{
	Table(){
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
		      int count = rs.getInt("id");
		      System.out.println(count);
		    
		      count++;
		      ResultSet res = stm.executeQuery(query);
//		      int row = 1;
		      
		    
		      String columns[] = { "UID", "Name", "Phone","Email","DOB","DOJ","Department","Gender","Address","City","Salary"};
		      String data[][] = new String[500][11];
		    
		      int i = 0;
		      while (res.next()) {
//		        int id = res.getInt("UID");
		    	String Uid = res.getString("UID");
		        String sal = res.getString("Salary");
		        String Name = res.getString("Name");
		        String Phone = res.getString("Phone");
		        String Email = res.getString("Email");
		        String DOB = res.getString("DOB");
		        String DOJ = res.getString("DOJ");
		        String Dep = res.getString("Department");
		        String Gender = res.getString("Gender");
		        String Add = res.getString("Address");
		        String City = res.getString("City");
//		        String sal = res.("Salary");
		        
		        data[i][0] = Uid + "";
		        data[i][1] = Name;
		        data[i][2] = Phone;
		        data[i][3] = Email;
		        data[i][4] = DOB;
		        data[i][5] = DOJ;
		        data[i][6] = Dep;
		        data[i][7] = Gender;
		        data[i][8] = Add;
		        data[i][9] = City;
		        data[i][10] = sal + "";
		        i++;
//		        row++;
		      }
		    
//		    
		      JFrame f=new JFrame(); 
		      JTable jt=new JTable(data,columns);    
		      jt.setBounds(30,40,200,300);          
		      JScrollPane sp=new JScrollPane(jt);
//		      f.setVisible(true);
		      f.add(sp);          
		      f.setSize(1650,1080); 
		      JTableHeader header = jt.getTableHeader();
		      header.setBackground(Color.yellow);
		      jt.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
		      jt.setShowGrid(true);
		      jt.setShowVerticalLines(true);
		      jt.setColumnSelectionAllowed(false);
//		      Form Making Table Un Dragable
		      jt.getTableHeader().setReorderingAllowed(false);
//		      font Size
		      jt.setFont(new Font("Tahoma", Font.BOLD, 18));
			      
//		      set Row Height
		      jt.setRowHeight(jt.getRowHeight() + 15);
//		      Unchangable screen
//		      f.setResizable(false);
		      f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		      Remove Close,minimize and Maximixe Button
//		      f.setUndecorated(true);
//		      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		   
		     
		      jt.setEnabled(false);

		      f.setVisible(true); 
		      
		    
		    } catch(SQLException e) {
		      e.printStackTrace();
		    }
	}
	
  public static void main(String[] args) 
  {
//   new Table();
   new Table();
   
  }
}