//import java.awt.BorderLayout;
import javax.swing.JOptionPane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class DropDown extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private String Selceted;
	private JLabel show;
	
//	private String url;
//	 		String user;
//	 		String password;
//	 		 Connection con; 
//		      Statement stm;
//	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DropDown obj = new DropDown();
					obj.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DropDown() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1650,1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1550, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Management System(Payroll)");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(0, 5, 1540, 55);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Employee Record\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 56, 1540, 60);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setForeground(UIManager.getColor("Button.highlight"));
		comboBox.setBackground(UIManager.getColor("Button.foreground"));
		comboBox.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
//		comboBox.setModel(new DefaultComboBoxModel(arr));
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBox.setBounds(627, 211, 301, 45);
		contentPane.add(comboBox);
		
		
		
		
		
//		show.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		show.setBounds(522, 11, 160, 48);
//		contentPane.add(show);
		
//		  contentPane.addWindowListener(this); 
		JLabel Sel = new JLabel("");
		Sel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		Sel.setBounds(627, 417, 618, 45);
		contentPane.add(Sel);
		
		JButton btndelete = new JButton("Delete\r\n");
		btndelete.setBackground(UIManager.getColor("Button.light"));
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btndelete) {
					
					 fetch();
					 delete();
					 
				            int result = JOptionPane.showConfirmDialog(contentPane,"Sure? You want to Delete "+Selceted+" ?", "Swing Tester",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(result == JOptionPane.YES_OPTION){
				            	delete();
				            
				            	//				            	Table obj =new Table();
				            	Sel.setText(Selceted+"IS SuccessFully Deleted");
				            	
				            	
				            }else if (result == JOptionPane.NO_OPTION){
				            	
				            }else {
				            	
				            }
					
				}
			}
		});
		btndelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		btndelete.setBounds(627, 299, 152, 45);
		contentPane.add(btndelete);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome obj = new Welcome();
				obj.setVisible(true);
				
			
	
			}
		});
		btnNewButton.setForeground(new Color(0, 51, 204));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		btnNewButton.setBounds(10, 119, 157, 45);
		contentPane.add(btnNewButton);
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		contentPane.setUndecorated(true);
		contentPane.setVisible(true);
		
		update();
		contentPane.revalidate();
		
	}
	public void update() {
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
//		      System.out.println(count);
		    
		      ResultSet res = stm.executeQuery(query);
		      List<String> list = new LinkedList<String>();
		      String columns[] = { "ID", "Name", "Phone","Email","DOB","Gender","Address","City","Salary"};
//		      String data[];
		      String data[];
		      int i = 0;
		      while (res.next()) {
		        String Name = res.getString("Name");
		        String UID = res.getString("UID");
//		        System.out.println(Name);
		        list.add(Name);
//		        comboBox.addItem(Name);
		        comboBox.addItem(UID);
		        i++;
		      }
		      for (int j = 0; j < list.size(); j++) {
//		            System.out.println(j +" = "+list.get(j));
		        }		      
//		      Convert List TO Array
		      String[] arr = new String[list.size()];
		      for (int j = 0; j < list.size(); j++)
		            arr[j] = list.get(j);
		    
		    } catch(SQLException e) {
		      e.printStackTrace();
		    }
	}
	public void fetch() {
		Selceted = (String)comboBox.getSelectedItem();
		System.out.println(Selceted);
	}
	public void delete() {
		 final String SQL_DELETE = "DELETE FROM record WHERE UID=?";

		        try (Connection conn = DriverManager.getConnection(
		                "jdbc:mysql://127.0.0.1:3306/ems", "root", "");
		             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE)) {

		            preparedStatement.setString(1,Selceted);

		            int row = preparedStatement.executeUpdate();

		            // rows affected
		            System.out.println(row);

		        } catch (SQLException e) {
		            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		    }
}
