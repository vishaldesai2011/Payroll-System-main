import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmployeeManagementSystem;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField Salary;
	JPanel panel;
	JPanel panel1;
	
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf8;
	private JComboBox y1;
	private JComboBox EID;
	JTextField Salary1;
	JTextField te;
	JTextField txtCity;
	
	
//	
	   static final String DB_URL = "jdbc:mysql://localhost/ems";
	   static final String USER = "root";
	   static final String PASS = "";	
	
	
//
	
	String val; 	
	String phone;  
	String email;  
	String day;
	String month;  
	String year; 
	String date;
	String dep;
	String gender;
	String add;
	String sal;
	String city;
	int num = 1988;
	String acno;


	String val1; 	
	String phone1;  
	String email1;  
	String day1;
	String month1;  
	String year1; 
	String date1;
	String dep1;
	String gender1;
	String add1;
	String sal1;
	String city1;
	private JTextField v1;
	String fetchItem;
	String day_1;
	String mon_1;
	JComboBox comboBox_11;
	JComboBox comboBox_12;
	String acno1;
	
	
	String n1;
	String p1;
	String e1;
	String da1;
	String g1;
	String d1;
	String a1;
	String c1;
	String s1;
	String acn1;
	
	JTextField name;
	JTextField textField_8;
	
	// FileWriter myWriter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setTitle("Employee Management System(Payroll)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1650, 1080);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEmployeeManagementSystem = new JTextField();
		txtEmployeeManagementSystem.setBackground(Color.BLACK);
		txtEmployeeManagementSystem.setForeground(Color.WHITE);
		txtEmployeeManagementSystem.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 30));
		txtEmployeeManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeManagementSystem.setText("Employee Management System(Payroll)");
		txtEmployeeManagementSystem.setBounds(0, 0, 1540, 54);
		txtEmployeeManagementSystem.setEditable(false);
		contentPane.add(txtEmployeeManagementSystem);
		txtEmployeeManagementSystem.setColumns(10);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
//		ImageIcon icon = new ImageIcon("add-user.PNG‪");
		String ch = "Add New";
		ImageIcon image = new ImageIcon("‪D:\\Projects\\Software Project\\JAVA\\Icons\\add.png");
		
		JSeparator separator = new JSeparator();
		separator.setBounds(186, 112, 1, 2);
		contentPane.add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("EditorPane.border"));
		panel_2.setBackground(SystemColor.windowBorder);
		panel_2.setBounds(0, 47, 1540, 63);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		JButton btnNewButton = new JButton(ch,new ImageIcon("D:\\Projects\\Software Project\\JAVA\\Icons\\add.png"));
		btnNewButton.setBounds(10, 10, 160, 49);
		btnNewButton.setFocusPainted(false);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnNewButton ) {
					panel = new JPanel();
					panel.setBackground(SystemColor.inactiveCaption);
					panel.setBounds(0, 112, 1568, 694);
					contentPane.add(panel);
					panel.setLayout(null);
//					
					textField = new JTextField();
					textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
					textField.setBounds(164, 90, 284, 38);
					panel.add(textField);
					textField.setColumns(10);
					
					JLabel lblFullName = new JLabel("Full Name : ");
					lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblFullName.setBounds(32, 90, 114, 35);
					panel.add(lblFullName);
					
					JLabel lblNewLabel = new JLabel("Date of Birth : ");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel.setBounds(32, 275, 134, 61);
					panel.add(lblNewLabel);
					
					JLabel lblPhone = new JLabel("Phone : ");
					lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblPhone.setBounds(32, 149, 100, 38);
					panel.add(lblPhone);
					
					JLabel lblEmial = new JLabel("Email : ");
					lblEmial.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblEmial.setBounds(32, 211, 100, 41);
					panel.add(lblEmial);
					
					JLabel lblNewLabel_2 = new JLabel("Add New Employee");
					lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 33));
					lblNewLabel_2.setBounds(639, 10, 266, 38);
					panel.add(lblNewLabel_2);
					
					textField_1 = new JTextField();
					textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
					textField_1.setColumns(10);
					textField_1.setBounds(164, 149, 284, 38);
					panel.add(textField_1);
					
					textField_2 = new JTextField();
					textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
					textField_2.setColumns(10);
					textField_2.setBounds(164, 214, 284, 38);
					panel.add(textField_2);
					
//					textField_3 = new JTextField();
//					textField_3.setColumns(10);
//					textField_3.setBounds(164, 304, 49, 38);
//					panel.add(textField_3);
					
					JComboBox Day = new JComboBox();
					Day.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
					Day.setFont(new Font("Serif", Font.BOLD, 19));
					Day.setBounds(164, 304,49, 38);
					panel.add(Day);
//					
					textField_4 = new JTextField();
					textField_4.setColumns(10);
					textField_4.setBounds(337, 304, 64, 38);
					panel.add(textField_4);
					
//					 JComboBox y1 = new JComboBox(new String[] {});
//					y1.setFont(new Font("Serif", Font.BOLD, 19));
//					y1.setBounds(337, 304,64, 38);
//					panel.add(y1);
//					int num = 1980;
//					while(num != 2023) {
//					y1.addItem(num);
//					num++;
//					}
					
//					textField_5 = new JTextField();
//					textField_5.setColumns(10);
//					textField_5.setBounds(245, 304, 64, 38);
//					panel.add(textField_5);
					
					JComboBox m1 = new JComboBox();
					m1.setModel(new DefaultComboBoxModel(new String[] {"JAN","FAB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"}));
					m1.setFont(new Font("Serif", Font.BOLD, 19));
					m1.setBounds(245, 304,64,38);
					panel.add(m1);
					
					
					
					JLabel lblNewLabel_3 = new JLabel("Day");
					lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 20));
					lblNewLabel_3.setBounds(165, 275, 49, 19);
					panel.add(lblNewLabel_3);
					
					JLabel lblNewLabel_3_1 = new JLabel("Month\r\n");
					lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 20));
					lblNewLabel_3_1.setBounds(245, 275, 70, 19);
					panel.add(lblNewLabel_3_1);
					
					JLabel lblNewLabel_3_1_1 = new JLabel("Year");
					lblNewLabel_3_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
					lblNewLabel_3_1_1.setBounds(337, 275, 64, 19);
					panel.add(lblNewLabel_3_1_1);
					
					JLabel lblGender = new JLabel("Gender");
					lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblGender.setBounds(32, 366, 100, 38);
					panel.add(lblGender);
					
					JComboBox comboBox = new JComboBox();
					comboBox.setFont(new Font("Serif", Font.PLAIN, 19));
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
					comboBox.setBounds(164, 366, 284, 38);
					panel.add(comboBox);
					
					JLabel lblDepartment = new JLabel("Department");
					lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblDepartment.setBounds(32, 424, 134, 38);
					panel.add(lblDepartment);
					
					JComboBox comboBox_1 = new JComboBox();
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"IT", "HR", "Sales Department", "Finance", "Purchase", "Marketing", "Customer Service"}));
					comboBox_1.setFont(new Font("Serif", Font.BOLD, 19));
					comboBox_1.setBounds(164, 424, 284, 38);
					panel.add(comboBox_1);

					JLabel lblAddress = new JLabel("Address : ");
					lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblAddress.setBounds(32, 482, 114, 58);
					panel.add(lblAddress);
		
					textField_6 = new JTextField();
					textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
					textField_6.setColumns(10);
					textField_6.setBounds(164, 485, 284, 58);
					panel.add(textField_6);
		
					JLabel lblCity = new JLabel("City : ");
					lblCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblCity.setBounds(32, 565, 114, 34);
					panel.add(lblCity);
		
					JTextField txtCity1 = new JTextField();
					txtCity1.setToolTipText("");
					txtCity1.setFont(new Font("Tahoma", Font.PLAIN, 20));
					txtCity1.setColumns(10);
					txtCity1.setBounds(164, 566, 284, 38);
					panel.add(txtCity1);
		
					JLabel lblAnnualSalary = new JLabel("Basic Salary  ");
					lblAnnualSalary.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblAnnualSalary.setBounds(32, 614, 172, 38);
					panel.add(lblAnnualSalary);
					
							
					Salary = new JTextField();
					Salary.setFont(new Font("Tahoma", Font.PLAIN, 20));
					Salary.setColumns(10);
					Salary.setBounds(164, 617, 284, 38);
					panel.add(Salary);
					
					JLabel AcNo = new JLabel("Account No");
					AcNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
					AcNo.setBounds(501,585, 172, 38);
					panel.add(AcNo);
					
					textField_8 = new JTextField();
					textField_8.setBounds(500,617, 300, 38);
					panel.add(textField_8);
					textField_8.setColumns(10);
					
					
					
					JButton Save = new JButton("Save", new ImageIcon("D:\\Projects\\Software Project\\JAVA\\Icons\\save.png"));
					Save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == Save){
							// System.out.println("hello");
							val1 = textField.getText();
							email1 = textField_2.getText(); 
							phone1 = textField_1.getText(); 
							acno = textField_8.getText();
							day1 = (String)Day.getSelectedItem();
							year1 = textField_4.getText();
							month1 = (String)m1.getSelectedItem();
							int m = m1.getSelectedIndex();
							m++;
							String s=Integer.toString(m);
							add1 = textField_6.getText();
							sal1 = Salary.getText();
							city1 = txtCity1.getText();
							date1 = day1+'-'+s+'-'+year1;
							gender1 = (String)comboBox.getSelectedItem();
							dep1 =  (String)comboBox_1.getSelectedItem(); 
							print1();
//							Year_f();
//							CheckInsert Ins =new CheckInsert();
							int num_count = phone1.length();
							System.out.println("Phone Length is : "+num_count);
							if(num_count != 10) {
								System.out.println("Phone Number is Not Valide");
//								v1.setText("Phone Number is Not Valid");
								JOptionPane.showMessageDialog(contentPane,"Phone Number is Invalid");  
							}
							else if(val1.length() == 0) {
								JOptionPane.showMessageDialog(contentPane,"Please Enter Name"); 
							}
							else if(email1.length() == 0) {
								JOptionPane.showMessageDialog(contentPane,"Please Enter Email"); 
							}
							else if(add1.length() == 0) {
								JOptionPane.showMessageDialog(contentPane,"Please Enter Address"); 
							}
							else if(city1.length() == 0 & acno.length() == 0) {
								JOptionPane.showMessageDialog(contentPane,"Please Enter City and Account No"); 
							}
							else if(num_count == 10) {
							CheckInsert.insert(val1,phone1,email1,date1,gender1,dep1,add1,city1,sal1,acno);
							JOptionPane.showMessageDialog(contentPane,val1+" is SuccessFully Inserted");
							System.out.println(val+"---"+phone+"---"+email+"---"+date+"---"+gender);	
							 print();
							}
							else {
								JOptionPane.showMessageDialog(contentPane,"SomeThing Wrong");  
							}
						}
					}
					});
					// ImageIcon res = new ImageIcon("D:\\Projects\\Software Project\\JAVA\\Icons\\res.png");
					JButton clear = new JButton("Clear",new ImageIcon("D:\\Projects\\Software Project\\JAVA\\Icons\\ref.png"));
					clear.setFocusPainted(false);
					clear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ef) {
						if(ef.getSource() == clear){
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_4.setText("");
							textField_8.setText("");
							textField_6.setText("");
							txtCity1.setText("");
							Salary.setText("");
							
							
						
							
						}

					}
					});
					clear.setFont(new Font("Tahoma", Font.PLAIN, 18));
//					clear.setBackground(new Color(46, 139, 87));
					clear.setBounds(176, 10, 147, 48);
					panel.add(clear);
					Save.setBounds(6, 9, 160, 48);
					panel.add(Save);
					Save.setFont(new Font("Tahoma", Font.ITALIC, 20));

					setExtendedState(JFrame.MAXIMIZED_BOTH); 

//					panel1.removeAll();
					panel.repaint();
					panel.revalidate();
					
				
					
					
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		ImageIcon image2 = new ImageIcon("‪D:\\Projects\\Java Projects\\Try\\bin.png");	
		JButton btnNewButton_2 = new JButton("Delete",new ImageIcon("D:\\Projects\\Software Project\\JAVA\\Icons\\bin.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DropDown objdow = new DropDown();
				objdow.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(180, 10, 160, 48);
		panel_2.add(btnNewButton_2);
		
		
		
		// ImageIcon image3 = new ImageIcon("‪D:\\Projects\\Java Projects\\Try\\refresh.png");
		JButton btnNewButton_3 = new JButton("Update",new ImageIcon("D:\\Projects\\Software Project\\JAVA\\Icons\\refresh.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent update) {
				if(update.getSource() == btnNewButton_3){
					JPanel panel1 = new JPanel();
					panel1.setBackground(UIManager.getColor("Button.disabledShadow"));
					panel1.setBounds(0, 112, 1568, 694);
					contentPane.add(panel1);
					panel1.setLayout(null);

					name = new JTextField();
					name.setFont(new Font("Tahoma", Font.PLAIN, 20));
					name.setBounds(164, 90, 284, 38);
					panel1.add(name);
					name.setColumns(10);
					
					JLabel lblFullName = new JLabel("Full Name : ");
					lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblFullName.setBounds(32, 90, 114, 35);
					panel1.add(lblFullName);
					
					JLabel lblNewLabel = new JLabel("Date of Birth : ");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblNewLabel.setBounds(32, 275, 134, 61);
					panel1.add(lblNewLabel);
					
					JLabel lblPhone = new JLabel("Phone : ");
					lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblPhone.setBounds(32, 149, 100, 38);
					panel1.add(lblPhone);
					
					JLabel lblEmial = new JLabel("Email : ");
					lblEmial.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblEmial.setBounds(32, 211, 100, 41);
					panel1.add(lblEmial);
					
					JLabel lblNewLabel_2 = new JLabel("Update Employee Details");
					lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 33));
					lblNewLabel_2.setBounds(639, 10, 359, 38);
					panel1.add(lblNewLabel_2);
					
					tf1 = new JTextField();
					tf1.setFont(new Font("Tahoma", Font.PLAIN, 20));
					tf1.setColumns(10);
					tf1.setBounds(164, 149, 284, 38);
					panel1.add(tf1);
					
					tf2 = new JTextField();
					tf2.setFont(new Font("Tahoma", Font.PLAIN, 20));
					tf2.setColumns(10);
					tf2.setBounds(164, 214, 284, 38);
					panel1.add(tf2);
//					
					tf3 = new JTextField();
					tf3.setColumns(10);
					tf3.setFont(new Font("Tahoma", Font.PLAIN, 20));
					tf3.setBounds(164, 304, 49, 38);
					panel1.add(tf3);
//					
//					JComboBox mon1 = new JComboBox();
//					mon1.setModel(new DefaultComboBoxModel(new String[] {"JAN","FAB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"}));
//					mon1.setFont(new Font("Serif", Font.BOLD, 19));
//					mon1.setBounds(245, 304,64,38);
//					panel1.add(mon1);
//					
//					JComboBox Day1 = new JComboBox();
//					Day1.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
//					Day1.setFont(new Font("Serif", Font.BOLD, 19));
//					Day1.setBounds(164, 304,49, 38);
//					panel1.add(Day1);
					
					tf4 = new JTextField();
					tf4.setColumns(10);
					tf4.setFont(new Font("Tahoma", Font.PLAIN, 20));
					tf4.setBounds(250, 304, 64, 38);
					panel1.add(tf4);
					
					tf5 = new JTextField();
					tf5.setColumns(10);
					tf5.setFont(new Font("Tahoma", Font.PLAIN, 20));
					tf5.setBounds(337, 304, 64, 38);
					panel1.add(tf5);
					
					JLabel lblNewLabel_3 = new JLabel("Day");
					lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 20));
					lblNewLabel_3.setBounds(165, 275, 49, 19);
					panel1.add(lblNewLabel_3);
					
					JLabel lblNewLabel_3_1 = new JLabel("Month\r\n");
					lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 20));
					lblNewLabel_3_1.setBounds(245, 275, 70, 19);
					panel1.add(lblNewLabel_3_1);
					
					JLabel lblNewLabel_3_1_1 = new JLabel("Year");
					lblNewLabel_3_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
					lblNewLabel_3_1_1.setBounds(337, 275, 64, 19);
					panel1.add(lblNewLabel_3_1_1);
					
					JLabel lblGender = new JLabel("Gender");
					lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblGender.setBounds(32, 366, 100, 38);
					panel1.add(lblGender);
					
					comboBox_12 = new JComboBox();
					comboBox_12.setFont(new Font("Serif", Font.PLAIN, 19));
					comboBox_12.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
					comboBox_12.setBounds(164, 366, 284, 38);
					panel1.add(comboBox_12);
					
					JLabel lblDepartment = new JLabel("Department");
					lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblDepartment.setBounds(32, 424, 134, 38);
					panel1.add(lblDepartment);
					
					comboBox_11 = new JComboBox();
					comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"IT", "HR", "Sales Department", "Finance", "Purchase", "Marketing", "Customer Service",}));
					comboBox_11.setFont(new Font("Serif", Font.BOLD, 19));
					comboBox_11.setBounds(164, 424, 284, 38);
					panel1.add(comboBox_11);

					JLabel lblAddress = new JLabel("Address : ");
					lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblAddress.setBounds(32, 482, 114, 58);
					panel1.add(lblAddress);
		
					tf6 = new JTextField();
					tf6.setFont(new Font("Tahoma", Font.PLAIN, 20));
					tf6.setColumns(10);
					tf6.setBounds(164, 485, 284, 58);
					panel1.add(tf6);
		
					JLabel lblCity = new JLabel("City : ");
					lblCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblCity.setBounds(32, 565, 114, 34);
					panel1.add(lblCity);
		
					txtCity = new JTextField();
					txtCity.setToolTipText("");
					txtCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
					txtCity.setColumns(10);
					txtCity.setBounds(164, 566, 284, 38);
					panel1.add(txtCity);
		
					JLabel lblAnnualSalary = new JLabel("Basic Salary  ");
					lblAnnualSalary.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblAnnualSalary.setBounds(32, 614, 172, 38);
					panel1.add(lblAnnualSalary);
		
					Salary1 = new JTextField();
					Salary1.setFont(new Font("Tahoma", Font.PLAIN, 20));
					Salary1.setColumns(10);
					Salary1.setBounds(164, 617, 284, 38);
					panel1.add(Salary1);
					
					JLabel AcNo1 = new JLabel("Account No");
					AcNo1.setFont(new Font("Tahoma", Font.PLAIN, 20));
					AcNo1.setBounds(501,585, 172, 38);
					panel1.add(AcNo1);
					
					tf8 = new JTextField();
					tf8.setBounds(500,617, 300, 38);
					panel1.add(tf8);
					tf8.setColumns(10);
					
					JLabel lblNewLabel_1 = new JLabel("UID");
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
					lblNewLabel_1.setBounds(600,85, 75, 28);
					panel1.add(lblNewLabel_1);
					
					EID = new JComboBox();
					EID.setModel(new DefaultComboBoxModel(new String[] {}));
					EID.setBounds(670,80, 188, 40);
					panel1.add(EID);
					fetchid();
					
					JButton fetch_data = new JButton("FetchData",new ImageIcon("D:\\Projects\\Java Projects\\Try\\data.png"));
					fetch_data.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent data) {
							if(data.getSource() == fetch_data) {
								fetchItem();
								fetchdata();
							}
							
						}
					});
					fetch_data.setFont(new Font("Tahoma", Font.PLAIN, 13));
					fetch_data.setFocusPainted(false);
					fetch_data.setBounds(670,130, 130, 40);
					panel1.add(fetch_data);
					
					
					
					// JButton Save = new JButton("Update", new ImageIcon("‪D:\\Projects\\Java Projects\\Try\\save.png"));
					// JButton Save = new JButton("Update", new ImageIcon("‪D:\\Projects\\Java Projects\\Try\\save.png"));
					JButton Save = new JButton("Update", new ImageIcon("D:\\Projects\\Java Projects\\Try\\save.png"));
					Save.setFocusPainted(false);
					Save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == Save){
							val = name.getText();
							phone = tf2.getText(); 
							email = tf1.getText(); 
							day = tf3.getText(); 
							acno1 = tf8.getText();
							month = tf4.getText(); 
							year = tf5.getText();
							add = tf6.getText();
							sal = Salary1.getText();
							date = day+'-'+month+'-'+year;
							city = txtCity.getText();
							
//							Combobox Fetch
							gender = (String)comboBox_12.getSelectedItem();
							dep =  (String)comboBox_11.getSelectedItem(); 
						
							print();
						
//							insert();
						
							// print1();
							
							int num_count = phone.length();
							System.out.println("Phone Length is : "+num_count);
							if(num_count > 10 ) {
								System.out.println("Phone Number is Not Valide");
//								v1.setText("Phone Number is Not Valid");
								JOptionPane.showMessageDialog(contentPane,"Phone Number is Invalid");  
							}
							else if(val.length() == 0) {
								JOptionPane.showMessageDialog(contentPane,"Please Enter Name"); 
							}
							else if(email.length() == 0) {
								JOptionPane.showMessageDialog(contentPane,"Please Enter Email"); 
							}
							else if(add.length() == 0) {
								JOptionPane.showMessageDialog(contentPane,"Please Enter Address"); 
							}
							else if(city.length() == 0) {
								JOptionPane.showMessageDialog(contentPane,"Please Enter City"); 
							}
							
							else if(num_count == 10) {
//							Update.Rupdate(val,phone,email,date,gender,dep,add,city,sal);
								Update.Rupdate(val,phone,email,date,gender,dep,add,city,sal,acno1,fetchItem);
							JOptionPane.showMessageDialog(contentPane,val+"'s Record SuccessFully Updated");
							System.out.println(val+"---"+phone+"---"+email+"---"+date+"---"+gender);	
							 print();
							}
							else {
								JOptionPane.showMessageDialog(contentPane,"Something Wrong");  
							}

							
							
						}
						
					}
					});
					Save.setBounds(350, 10, 160, 48);
					panel1.add(Save);
					Save.setFont(new Font("Tahoma", Font.ITALIC, 20));
					setExtendedState(JFrame.MAXIMIZED_BOTH); 
// Clear Button
				ImageIcon res = new ImageIcon("D:\\Projects\\Software Project\\JAVA\\Icons\\res.png");
				JButton clear1 = new JButton("Clear",new ImageIcon("D:\\Projects\\Software Project\\JAVA\\Icons\\ref.png"));
				clear1.setFocusPainted(false);
				clear1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == clear1){
						// name.remove();
						System.out.println("Hay i am Clear");
						name.setText("");
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						tf4.setText("");
						tf5.setText("");
						tf6.setText("");
						txtCity.setText("");
						Salary1.setText("");
						
						
						
						
						
					}
				}
				});
				
				clear1.setFont(new Font("Tahoma", Font.PLAIN, 18));
				clear1.setBounds(176, 10, 147, 48);
				panel1.add(clear1);

//					Object panel;
//					panel.removeAll();
					panel1.repaint();
					panel1.revalidate();
					
										
				}
	
	}
// End Update File
		});



		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBounds(350, 10, 160, 48);
		panel_2.add(btnNewButton_3);
		
		JButton Show = new JButton("Show Record\r\n", new ImageIcon("D:\\Projects\\Software Project\\JAVA\\Icons\\icons8-record-32.png"));
		Show.setFocusPainted(false);
		Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es) {
//				@SuppressWarnings("unused");
				if(es.getSource() == Show) {
				Table objTable = new Table();
//				objTable.setVisible(true);
//				objTable.visble(true);
//				System.out.println("Record Not Found");
				}
			}
		});
		Show.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Show.setBounds(522, 11, 160, 48);
		panel_2.add(Show);
		
		JButton btnPayroll = new JButton("Payroll", new ImageIcon("D:\\Projects\\Java Projects\\Try\\payroll.png"));
		btnPayroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent pay) {
				if(pay.getSource() == btnPayroll) {
//					Payroll obj1 = new Payroll();
//					Calling Main Method	
					Payroll.main(null);

					
		
				}
				
			}
		});
		btnPayroll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPayroll.setFocusPainted(false);
		btnPayroll.setBounds(695, 11, 160, 48);
		panel_2.add(btnPayroll);
		
	
		
		
		
		
		
		
		
		
	
		
		
		
	

	}

		public void print(){
			System.out.println("----------------------------");
			System.out.println("Name : "+ val);
			System.out.println("Email : "+ email);
			System.out.println("Phone : "+ phone);
			System.out.println("Date : "+ date);
			System.out.println("Department : "+ dep);
			System.out.println("Gender : "+ gender);
			System.out.println("Address : "+ add);
			System.out.println("City : "+ city);
			System.out.println("Salary : "+ sal);
			System.out.println("----------------------------");


			
		}
		public void print1(){
			System.out.println("----------------------------");
			System.out.println("Name : "+ val1);
			System.out.println("Email : "+ email1);
			System.out.println("Phone : "+ phone1);
			System.out.println("Date : "+ date1);
			System.out.println("Department : "+ dep1);
			System.out.println("Gender : "+ gender1);
			System.out.println("Address : "+ add1);
			System.out.println("City : "+ city1);
			System.out.println("Salary : "+ sal1);
			System.out.println("----------------------------");


			
		}
		public void fetchid() {
			try 
			  {
			      String url = "jdbc:mysql://localhost:3306/ems?autoReconnect=true&useSSL=false";
			      String user = "root";
			      String password = "";
			    
			      Connection con = DriverManager.getConnection(url, user, password);
			      Statement stm = con.createStatement();
			    
			      String query = "SELECT * FROM record";
			      ResultSet rs = stm.executeQuery(query);
			      int i = 0;
			    		  while (rs.next()) {
			  		        String UID = rs.getString("UID");
//			  		    
			  		        EID.addItem(UID);
			  		        i++;
			  		      }
			  con.close();
			  } catch(SQLException e) {
			      e.printStackTrace();
			    }
			
		}
		public void fetchItem() {
			fetchItem = (String)EID.getSelectedItem();
		}
		public void fetchdata() {
			try 
			  {
			      String url = "jdbc:mysql://localhost:3306/ems?autoReconnect=true&useSSL=false";
			      String user = "root";
			      String password = "";
			    
			      Connection con = DriverManager.getConnection(url, user, password);
			      Statement stm = con.createStatement();
			    
			      String query = "SELECT * FROM record WHERE UID = ?";
			      PreparedStatement psmt = con.prepareStatement(query);
			      psmt.setString(1,fetchItem);
			      ResultSet rs = psmt.executeQuery();
//			      ResultSet rs = stm.executeQuery(query);
			    		  while (rs.next()) {
			  		        String UID = rs.getString("UID");
			  		        String n1 = rs.getString("Name");
			  		        String e1 = rs.getString("Email");
			  		        String p1 = rs.getString("Phone");
			  		        String d1 = rs.getString("DOB");
			  		        String da1 =rs.getString("Department");
			  		        String g1 =rs.getString("Gender");
			  		        String a1 =rs.getString("Address");
			  		        String c1 =rs.getString("City");
			  		        String s1 = rs.getString("Salary");
			  		        String acn1 = rs.getString("Account_No");
			  		        
			  		      comboBox_11.setSelectedItem(da1);
			  		      comboBox_12.setSelectedItem(g1);
			  		      String[] dat1 = d1.split("-"); 
//			  		      Set Values From in TextField
			  		      
//			  		      Values For Date
			  		      tf3.setText(dat1[0]);
			  		      tf4.setText(dat1[1]);
			  		      tf5.setText(dat1[2]);
			  		      
//			  		      Other Data
			  		      name.setText(n1);
			  		      tf1.setText(e1);
			  		      tf2.setText(p1);
			  		      tf6.setText(a1);
			  		      Salary1.setText(s1);
			  		      txtCity.setText(c1);
			  		      tf8.setText(acn1);
			  		      
			  		   			  		        
			  		        
			  		        
			  		      }
			  con.close();
			  } catch(SQLException e) {
			      e.printStackTrace();
			    }
			
		}
}




