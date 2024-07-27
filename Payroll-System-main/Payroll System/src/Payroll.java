import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.TimeZone;
import java.util.Calendar;




import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Payroll {

	private JFrame frame;
	private JTextField txtEmployeeManagementSystempayroll;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField c_year;
	LocalDate currentdate;
	private JTextField txt_month;
	int currentMonth;
	String m1;
	int days;
//	private JTextField Name;
	private JTextField AcNo;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField Annual;
	private JTextField bsalary;
	private JTextField leave_1;
	private JTextField paid_leave;
	String fetchItem;
	JComboBox uid;
	
	  String UID; 
	  String na1;
	  String e1;
	  String p1;  
	  String da1;  
	  String a1;
	  String c1;
	  String s1;
	  String acn1;
	  String g1;
	  String d1;
	  String doj1;
	  int Basic;
	  int days1;
	  String pay_month;
	  String b1;
	  String ok;
	  String pm_record;
	  String DA_per;
	 
	  
	  
//	  Salary Records
	  
	  String UID_r; 
	  String name_r;
	  String acno_r; 
	  String wd_r;
	  String dob_r; 
	  String doj_r;
	  String da_r; 
	  String basic_r;
	  String fetch_r_uid;
	  String fetch_r_year;
	  String fetch_r_month;
	  String pm;
	  String max_days;
	  
	  String UID_record; 
	  String name_record;
	  String acno_record; 
	  String wd_record;
	  String dob_record; 
	  String doj_record;
	  String hra_record; 
	  String basic_record;
	  String esi_record;
	  String dep_record;
	  String wday_record;
	  String da_record;
	  String epf_record;
//	  String Basic_record;
	  String itax_record;
	  String earning_record;
	  String dedeu_record;
	  String netpay_record;
	  String mon_r;
	  String DA_F_record;
	  String HRA_record;
	  String EPF_record;
	  String  Workingday_record;
	  
	  JComboBox uid_r;
	  JComboBox year_r;
	  JComboBox month_r;
      
//	  int present_days;
	  String p_day;
	  private JTextField name;
	  private JTextField name_rec;
	  private JTextField acno_rec;
	  private JTextField e_id;
	  private JTextField pay_month_rec;
	  private JTextField basic1_record;
	  private JTextField da1_record;
	  private JTextField hra1_record;
	  private JTextField tpt1_record;
	  private JTextField proftax_record;
	  private JTextField esi_1_record;
	  private JTextField epf1_record;
	  private JTextField itax1_record;
	  private JTextField earning1_record;
	  private JTextField Deducation1_record;
	  private JTextField netpay1_record;
	  private JTextField da_txtfield;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (true) {
					Payroll window = new Payroll();
					window.frame.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Payroll() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
//	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1920,1080);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1920, 70);
		panel.setBackground(new Color(169, 169, 169));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtEmployeeManagementSystempayroll = new JTextField();
		txtEmployeeManagementSystempayroll.setEditable(false);
		txtEmployeeManagementSystempayroll.setBackground(Color.BLACK);
		txtEmployeeManagementSystempayroll.setForeground(Color.WHITE);
		txtEmployeeManagementSystempayroll.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeManagementSystempayroll.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtEmployeeManagementSystempayroll.setText("Employee Management System(Payroll)");
		txtEmployeeManagementSystempayroll.setBounds(0, 0, 1537, 65);
		panel.add(txtEmployeeManagementSystempayroll);
		txtEmployeeManagementSystempayroll.setColumns(10);
		
		Panel panel_4 = new Panel();
		panel_4.setBackground(new Color(211, 211, 211));
		panel_4.setBounds(0, 76,791, 759);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel heading1 = new JLabel("Payroll");
		heading1.setHorizontalAlignment(SwingConstants.CENTER);
		heading1.setFont(new Font("Tahoma", Font.BOLD, 22));
		heading1.setIcon(new ImageIcon("D:\\Projects\\Java Projects\\Try\\money_bag.png"));
		heading1.setBounds(0, 0, 771, 50);
		panel_4.add(heading1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBackground(new Color(0, 0, 0));
		textField_1.setBounds(0, 52, 801, 19);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel eid = new JLabel("UID\r\n");
		eid.setBackground(new Color(128, 128, 128));
		eid.setHorizontalAlignment(SwingConstants.CENTER);
		eid.setFont(new Font("Tahoma", Font.BOLD, 17));
		eid.setForeground(new Color(0, 0, 0));
		eid.setBounds(10, 98, 126, 43);
		panel_4.add(eid);
		
		uid = new JComboBox();
		uid.setModel(new DefaultComboBoxModel(new String[] {}));
		uid.setForeground(new Color(128, 128, 128));
		uid.setBackground(new Color(255, 255, 255));
//		comboBox_id.setSelectedIndex(0);
		uid.setBounds(143, 98, 204, 43);
		panel_4.add(uid);
		
		JLabel lblCurrentYear = new JLabel("Current Year :");
		lblCurrentYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentYear.setForeground(Color.BLACK);
		lblCurrentYear.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCurrentYear.setBackground(Color.GRAY);
		lblCurrentYear.setBounds(379, 98, 126, 43);
		panel_4.add(lblCurrentYear);
		
		c_year = new JTextField();
		c_year.setForeground(new Color(0, 0, 0));
		c_year.setBackground(new Color(255, 255, 255));
		c_year.setHorizontalAlignment(SwingConstants.CENTER);
		c_year.setFont(new Font("Tahoma", Font.BOLD, 20));
		c_year.setEditable(false);
		c_year.setBounds(509, 98, 204, 43);
		panel_4.add(c_year);
		c_year.setColumns(10);
		
		JPanel esi1_record = new JPanel();
		esi1_record.setBackground(new Color(211, 211, 211));
		esi1_record.setBounds(797, 76,912, 728);
		frame.getContentPane().add(esi1_record);
		esi1_record.setLayout(null);
		
		JLabel heading2 = new JLabel("Records");
		heading2.setIcon(new ImageIcon("D:\\Projects\\Java Projects\\Try\\6843050_business_community_corporate_employee_people_icon (1).png"));
		heading2.setHorizontalAlignment(SwingConstants.CENTER);
		heading2.setFont(new Font("Tahoma", Font.BOLD, 22));
		heading2.setBounds(0, 0, 771, 50);
		esi1_record.add(heading2);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setBackground(new Color(0, 0, 0));
		textField_2.setColumns(10);
		textField_2.setBounds(0, 52, 791, 19);
		esi1_record.add(textField_2);
		
		JLabel uid_lable_2 = new JLabel("UID\r\n");
		uid_lable_2.setHorizontalAlignment(SwingConstants.CENTER);
		uid_lable_2.setForeground(Color.BLACK);
		uid_lable_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		uid_lable_2.setBackground(Color.GRAY);
		uid_lable_2.setBounds(20, 98, 126, 43);
		esi1_record.add(uid_lable_2);
		
		uid_r = new JComboBox();
		uid_r.setFont(new Font("Tahoma", Font.PLAIN, 12));
		uid_r.setModel(new DefaultComboBoxModel(new String[] {}));
		uid_r.setForeground(Color.DARK_GRAY);
		uid_r.setBackground(Color.WHITE);
		uid_r.setBounds(153, 101, 204, 43);
		esi1_record.add(uid_r);
		
		JLabel lbl_year = new JLabel("Year");
		lbl_year.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_year.setForeground(Color.BLACK);
		lbl_year.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_year.setBackground(Color.GRAY);
		lbl_year.setBounds(388, 98, 126, 43);
		esi1_record.add(lbl_year);
		
		year_r = new JComboBox();
		year_r.setFont(new Font("Tahoma", Font.PLAIN, 12));
		year_r.setModel(new DefaultComboBoxModel(new String[] {"2022","2023","2024","2025"}));
		year_r.setForeground(Color.DARK_GRAY);
		year_r.setBackground(Color.WHITE);
		year_r.setBounds(524, 101, 204, 43);
		esi1_record.add(year_r);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setForeground(Color.BLACK);
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMonth.setBackground(Color.GRAY);
		lblMonth.setBounds(10, 175, 133, 43);
		esi1_record.add(lblMonth);
		
		month_r = new JComboBox();
		month_r.setFont(new Font("Tahoma", Font.PLAIN, 12));
		month_r.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		month_r.setForeground(Color.DARK_GRAY);
		month_r.setBackground(Color.WHITE);
		month_r.setBounds(153, 175, 204, 43);
		esi1_record.add(month_r);
		
		
		

		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 128, 128));
		panel_1_1.setBounds(0, 227, 791, 66);
		esi1_record.add(panel_1_1);
		
		JLabel n1_1 = new JLabel("Name  ");
		n1_1.setForeground(Color.WHITE);
		n1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		n1_1.setBounds(27, 14, 70, 18);
		panel_1_1.add(n1_1);
		
		name_rec = new JTextField();
		name_rec.setText("");
		name_rec.setForeground(Color.WHITE);
		name_rec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name_rec.setEditable(false);
		name_rec.setColumns(10);
		name_rec.setBackground(new Color(0, 128, 128));
		name_rec.setBounds(76, 12, 120, 22);
		panel_1_1.add(name_rec);
		
		JLabel acno_1 = new JLabel("Ac No  ");
		acno_1.setForeground(Color.WHITE);
		acno_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		acno_1.setBounds(27, 40, 70, 22);
		panel_1_1.add(acno_1);
		
		acno_rec = new JTextField();
		acno_rec.setText("");
		acno_rec.setForeground(Color.WHITE);
		acno_rec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		acno_rec.setEditable(false);
		acno_rec.setColumns(10);
		acno_rec.setBackground(new Color(0, 128, 128));
		acno_rec.setBounds(76, 40, 120, 22);
		panel_1_1.add(acno_rec);
		
		e_id = new JTextField();
		e_id.setText("");
		e_id.setForeground(Color.WHITE);
		e_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		e_id.setEditable(false);
		e_id.setColumns(10);
		e_id.setBackground(new Color(0, 128, 128));
		e_id.setBounds(572, 12, 120, 22);
		panel_1_1.add(e_id);
		
		JLabel n1_1_1 = new JLabel("UID");
		n1_1_1.setForeground(Color.WHITE);
		n1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		n1_1_1.setBounds(533, 14, 47, 18);
		panel_1_1.add(n1_1_1);
		
		JLabel n1_1_1_1 = new JLabel("Pay Month");
		n1_1_1_1.setForeground(Color.WHITE);
		n1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		n1_1_1_1.setBounds(495, 40, 70, 18);
		panel_1_1.add(n1_1_1_1);
		
		pay_month_rec = new JTextField();
		pay_month_rec.setText("");
		pay_month_rec.setForeground(Color.WHITE);
		pay_month_rec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pay_month_rec.setEditable(false);
		pay_month_rec.setColumns(10);
		pay_month_rec.setBackground(new Color(0, 128, 128));
		pay_month_rec.setBounds(572, 40, 120, 22);
		panel_1_1.add(pay_month_rec);
		
				
		JLabel Basic_record = new JLabel("Earning");
		Basic_record.setForeground(new Color(0, 128, 128));
		Basic_record.setHorizontalAlignment(SwingConstants.CENTER);
		Basic_record.setFont(new Font("Tahoma", Font.BOLD, 18));
		Basic_record.setBounds(0, 372, 113, 43);
		esi1_record.add(Basic_record);
		
		JLabel lblNewLabel_1 = new JLabel("Basic");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(33, 410, 110, 33);
		esi1_record.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DA");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(33, 453, 110, 33);
		esi1_record.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("HRA");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(33, 497, 113, 33);
		esi1_record.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("TPT Allow");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(33, 538, 113, 33);
		esi1_record.add(lblNewLabel_1_1_1_1);
		
		JLabel Basic_record_2 = new JLabel("Amount(Rs.)");
		Basic_record_2.setHorizontalAlignment(SwingConstants.CENTER);
		Basic_record_2.setForeground(new Color(0, 128, 128));
		Basic_record_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		Basic_record_2.setBounds(119, 372, 133, 43);
		esi1_record.add(Basic_record_2);
		
		basic1_record = new JTextField();
		basic1_record.setEditable(false);
		basic1_record.setForeground(new Color(128, 0, 0));
		basic1_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		basic1_record.setColumns(10);
		basic1_record.setBackground(Color.LIGHT_GRAY);
		basic1_record.setBounds(119, 411, 147, 32);
		esi1_record.add(basic1_record);
		
		da1_record = new JTextField();
		da1_record.setEditable(false);
		da1_record.setForeground(new Color(128, 0, 0));
		da1_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		da1_record.setColumns(10);
		da1_record.setBackground(Color.LIGHT_GRAY);
		da1_record.setBounds(119, 453, 147, 32);
		esi1_record.add(da1_record);
		
		hra1_record = new JTextField();
		hra1_record.setEditable(false);
		hra1_record.setForeground(new Color(128, 0, 0));
		hra1_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		hra1_record.setColumns(10);
		hra1_record.setBackground(Color.LIGHT_GRAY);
		hra1_record.setBounds(119, 498, 147, 32);
		esi1_record.add(hra1_record);
		
		tpt1_record = new JTextField();
		tpt1_record.setEditable(false);
		tpt1_record.setForeground(new Color(128, 0, 0));
		tpt1_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		tpt1_record.setColumns(10);
		tpt1_record.setBackground(Color.LIGHT_GRAY);
		tpt1_record.setBounds(119, 540, 147, 32);
		esi1_record.add(tpt1_record);
		
		JLabel Basic_record_1 = new JLabel("Earning");
		Basic_record_1.setHorizontalAlignment(SwingConstants.CENTER);
		Basic_record_1.setForeground(new Color(0, 128, 128));
		Basic_record_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		Basic_record_1.setBounds(388, 372, 113, 43);
		esi1_record.add(Basic_record_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prof Tax");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(411, 410, 110, 33);
		esi1_record.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("E.S.I");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(411, 453, 80, 33);
		esi1_record.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("E.P.F");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_2.setBounds(411, 497, 113, 33);
		esi1_record.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Income Tax");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_2_1.setBounds(411, 538, 113, 33);
		esi1_record.add(lblNewLabel_1_1_1_2_1);
		
		JLabel Basic_record_2_1 = new JLabel("Amount(Rs.)");
		Basic_record_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		Basic_record_2_1.setForeground(new Color(0, 128, 128));
		Basic_record_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		Basic_record_2_1.setBounds(524, 372, 133, 43);
		esi1_record.add(Basic_record_2_1);
		
		proftax_record = new JTextField();
		proftax_record.setEditable(false);
		proftax_record.setForeground(new Color(128, 0, 0));
		proftax_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		proftax_record.setColumns(10);
		proftax_record.setBackground(Color.LIGHT_GRAY);
		proftax_record.setBounds(524, 410, 147, 32);
		esi1_record.add(proftax_record);
		
		esi_1_record = new JTextField();
		esi_1_record.setEditable(false);
		esi_1_record.setForeground(new Color(128, 0, 0));
		esi_1_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		esi_1_record.setColumns(10);
		esi_1_record.setBackground(Color.LIGHT_GRAY);
		esi_1_record.setBounds(524, 453, 147, 32);
		esi1_record.add(esi_1_record);
		
		epf1_record = new JTextField();
		epf1_record.setEditable(false);
		epf1_record.setForeground(new Color(128, 0, 0));
		epf1_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		epf1_record.setColumns(10);
		epf1_record.setBackground(Color.LIGHT_GRAY);
		epf1_record.setBounds(524, 497, 147, 32);
		esi1_record.add(epf1_record);
		
		itax1_record = new JTextField();
		itax1_record.setEditable(false);
		itax1_record.setForeground(new Color(128, 0, 0));
		itax1_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		itax1_record.setColumns(10);
		itax1_record.setBackground(Color.LIGHT_GRAY);
		itax1_record.setBounds(524, 540, 147, 32);
		esi1_record.add(itax1_record);
		
		Deducation1_record = new JTextField();
		Deducation1_record.setForeground(new Color(128, 0, 0));
		Deducation1_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		Deducation1_record.setEditable(false);
		Deducation1_record.setColumns(10);
		Deducation1_record.setBackground(Color.LIGHT_GRAY);
		Deducation1_record.setBounds(524, 582, 147, 32);
		esi1_record.add(Deducation1_record);
		
		earning1_record = new JTextField();
		earning1_record.setForeground(new Color(0, 139, 139));
		earning1_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		earning1_record.setEditable(false);
		earning1_record.setColumns(10);
		earning1_record.setBackground(Color.LIGHT_GRAY);
		earning1_record.setBounds(119, 581, 147, 32);
		esi1_record.add(earning1_record);
		
		netpay1_record = new JTextField();
		netpay1_record.setForeground(new Color(0, 0, 0));
		netpay1_record.setFont(new Font("Tahoma", Font.BOLD, 12));
		netpay1_record.setEditable(false);
		netpay1_record.setColumns(10);
		netpay1_record.setBackground(Color.LIGHT_GRAY);
		netpay1_record.setBounds(119, 623, 147, 32);
		esi1_record.add(netpay1_record);

		
//		Month And Year
		 Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		 currentMonth = localCalendar.get(Calendar.MONTH) + 1;
		 int currentYear = localCalendar.get(Calendar.YEAR);
		 
		 String y1=Integer.toString(currentYear);
		 System.out.println(currentMonth);
		 System.out.println(currentYear);
		 getmonth();
		 pay_month = m1+"-"+currentYear;
		 
		 
		 c_year.setText(y1);
//		 For Fetch Record Button
		 JButton select_1 = new JButton("Fetch Record");
			select_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent rec) {
					if(rec.getSource() == select_1) {
					fetch_id_month_year_record();
					mon_r =  fetch_r_month+"-"+fetch_r_year;
					fetch_For_Record(fetch_r_uid,mon_r);
					name_rec.setText("");
					name_rec.setText(name_record);
					acno_rec.setText(acno_record);
					e_id.setText(UID_record);
					pay_month_rec.setText(pm_record);
					basic1_record.setText(basic_record);
					da1_record.setText(DA_F_record);
					hra1_record.setText(HRA_record);
					tpt1_record.setText("1600");
					proftax_record.setText("200");
					esi_1_record.setText(esi_record);
					epf1_record.setText(EPF_record);
					itax1_record.setText(itax_record);
					earning1_record.setText(earning_record);
					Deducation1_record.setText(dedeu_record);
					netpay1_record.setText(netpay_record);
					
					
					
//					ptax
					System.out.println(mon_r+fetch_r_uid);
					}
				}
			});
			select_1.setForeground(Color.WHITE);
			select_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			select_1.setBackground(new Color(46, 139, 87));
			select_1.setBounds(524, 176, 204, 43);
			esi1_record.add(select_1);
			select_1.setFocusPainted(false);
			
			JLabel earning_lbl = new JLabel("Earning");
			earning_lbl.setForeground(new Color(0, 128, 128));
			earning_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
			earning_lbl.setBounds(33, 581, 113, 33);
			esi1_record.add(earning_lbl);
			
			
			
			JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Deducation");
			lblNewLabel_1_1_1_1_1_1.setForeground(new Color(220, 20, 60));
			lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1_1_1_1_1_1.setBounds(411, 581, 113, 33);
			esi1_record.add(lblNewLabel_1_1_1_1_1_1);
			
			JLabel earning_lbl_1 = new JLabel("Net Pay");
			earning_lbl_1.setForeground(new Color(0, 0, 0));
			earning_lbl_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			earning_lbl_1.setBounds(33, 623, 113, 33);
			esi1_record.add(earning_lbl_1);
			
			JButton genrate_pdf = new JButton("Generate PDF");
			genrate_pdf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent gpdf) {
					if(gpdf.getSource() == genrate_pdf) {
						Record_PDF record_PDF = new Record_PDF();
						if(basic_record != null) {
						record_PDF.generatePDF_from_Record(UID_record, name_record, acno_record, basic_record, Workingday_record, pm_record,
								dep_record, dob_record, doj_record, DA_F_record, HRA_record, "1600", earning_record, esi_record, EPF_record, itax_record,
								dedeu_record, netpay_record);
								JOptionPane.showMessageDialog(frame,UID_record+"Salary Slip Successfully Genrated For Month "+pm_record); 
						}
						else {
							JOptionPane.showMessageDialog(frame,"Record Not Found");
						}	
						
					}
				}
			});
			genrate_pdf.setForeground(Color.WHITE);
			genrate_pdf.setFont(new Font("Tahoma", Font.BOLD, 15));
			genrate_pdf.setFocusPainted(false);
			genrate_pdf.setBackground(new Color(46, 139, 87));
			genrate_pdf.setBounds(411, 629, 204, 43);
			esi1_record.add(genrate_pdf);
			
			
			
			
		
		 
		 
		 txt_month = new JTextField();
		 txt_month.setForeground(new Color(0, 0, 0));
		 txt_month.setBackground(new Color(255, 255, 255));
		 txt_month.setText("2022");
		 txt_month.setHorizontalAlignment(SwingConstants.CENTER);
		 txt_month.setFont(new Font("Tahoma", Font.BOLD, 20));
		 txt_month.setEditable(false);
		 txt_month.setColumns(10);
		 txt_month.setBounds(143, 163, 204, 43);
		 panel_4.add(txt_month);
		 
		 JLabel month = new JLabel("Current Month :");
		 month.setHorizontalAlignment(SwingConstants.CENTER);
		 month.setForeground(Color.BLACK);
		 month.setFont(new Font("Tahoma", Font.BOLD, 17));
		 month.setBackground(Color.GRAY);
		 month.setBounds(0, 164, 147, 43);
		 panel_4.add(month);
		 txt_month.setText(m1);
		 
		 JButton select = new JButton("Select");
		 select.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e1) {
		 		if(e1.getSource() == select) {
		 			 
		 			 fetchItem();
		 			 fetchdata();
		 			 System.out.println(acn1);
//		 			 Function For Salary Slip Genrated Or Not
		 			CheckExist_OR_NOT(UID,pay_month);
		 			
		 			
		 			 AcNo.setText(acn1);
		 			 name.setText(na1);
//		 			 Annual.setText("");
//		 			 Annual.setText(s1);
		 			 Basic = Integer.parseInt(s1);
		 			 
//		 			 Basic = Basic;
		 			 b1 = Integer.toString(Basic);
		 			 System.out.println("Basic is : "+b1);
		 			 bsalary.setText("");
		 			 bsalary.setText(b1);
		 			 
		 			 
		 			 
		 			 

		 			 
		 		}
				 
		 	}
		 });
		 select.setForeground(new Color(255, 255, 255));
		 select.setBackground(new Color(46, 139, 87));
		 select.setFont(new Font("Tahoma", Font.BOLD, 15));
		 select.setBounds(509, 165, 204, 43);
		 select.setFocusPainted(false);

		 panel_4.add(select);		 

			 Panel panel_1 = new Panel();
			 panel_1.setBackground(new Color(0, 128, 128));
			 panel_1.setBounds(0, 227, 791, 66);
			 panel_4.add(panel_1);
			 panel_1.setLayout(null);
			 
		 
			 JLabel n1 = new JLabel("Name  ");
			 n1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			 n1.setForeground(new Color(255, 255, 255));
			 n1.setBounds(27, 14, 70, 18);
			 panel_1.add(n1);
			 
			 name = new JTextField();
 			 name.setEditable(false);
 			 name.setText("");
 			 name.setForeground(Color.WHITE);
 			 name.setFont(new Font("Tahoma", Font.PLAIN, 15));
 			 name.setColumns(10);
 			 name.setBackground(new Color(0, 128, 128));
 			 name.setBounds(76, 12, 120, 22);
 			 panel_1.add(name);
			 
			 JLabel acno = new JLabel("Ac No  ");
 			 acno.setForeground(Color.WHITE);
 			 acno.setFont(new Font("Tahoma", Font.PLAIN, 15));
 			 acno.setBounds(27, 40, 70, 22);
 			 panel_1.add(acno);
 			 
 			 AcNo = new JTextField();
 			 AcNo.setEditable(false);
 			 AcNo.setForeground(new Color(255, 255, 255));
 			 AcNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
// 			 AcNo.setEditable(false);
 			 AcNo.setColumns(10);
 			 AcNo.setBackground(new Color(0, 128, 128));
 			 AcNo.setBounds(76, 40, 120, 22);
 			 panel_1.add(AcNo);
 			 
 			 name.setText("");
 			 AcNo.setText("");
 			 
			 
//			 ENd
			 
//			 JLabel lblNewLabel = new JLabel("Annual Salary :\r\n");
//			 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
//			 lblNewLabel.setBounds(63, 352, 120, 32);
//			 panel_4.add(lblNewLabel);
//			 
//			 Annual = new JTextField();
//			 Annual.setFont(new Font("Tahoma", Font.BOLD, 13));
//			 Annual.setForeground(new Color(128, 0, 0));
//			 Annual.setBackground(new Color(192, 192, 192));
//			 Annual.setEditable(false);
//			 Annual.setBounds(183, 352, 147, 32);
//			 panel_4.add(Annual);
//			 Annual.setColumns(10);
			 
			 JLabel basic = new JLabel("Basic Salary  :\r\n");
			 basic.setFont(new Font("Tahoma", Font.BOLD, 15));
			 basic.setBounds(63, 352, 120, 32);
			 panel_4.add(basic);
			 
			 bsalary = new JTextField();
			 bsalary.setFont(new Font("Tahoma", Font.BOLD, 13));
			 bsalary.setForeground(new Color(128, 0, 0));
			 bsalary.setEditable(false);
			 bsalary.setColumns(10);
			 bsalary.setBackground(Color.LIGHT_GRAY);
			 bsalary.setBounds(183, 353, 147, 32);
			 panel_4.add(bsalary);
			 
			 JLabel leave = new JLabel("Total Leave : ");
			 leave.setHorizontalAlignment(SwingConstants.CENTER);
			 leave.setFont(new Font("Tahoma", Font.BOLD, 15));
			 leave.setBounds(405, 352, 120, 32);
			 panel_4.add(leave);
			 
			 leave_1 = new JTextField();
			 leave_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			 leave_1.setForeground(new Color(128, 0, 0));
			 leave_1.setColumns(10);
			 leave_1.setBackground(Color.LIGHT_GRAY);
			 leave_1.setBounds(535, 352, 147, 32);
			 panel_4.add(leave_1);
			 
			 JLabel lblPaidLeave = new JLabel("Paid Leave : ");
			 lblPaidLeave.setHorizontalAlignment(SwingConstants.CENTER);
			 lblPaidLeave.setFont(new Font("Tahoma", Font.BOLD, 15));
			 lblPaidLeave.setBounds(405, 409, 120, 32);
			 panel_4.add(lblPaidLeave);
			 
			 paid_leave = new JTextField();
			 paid_leave.setFont(new Font("Tahoma", Font.BOLD, 13));
			 paid_leave.setForeground(new Color(128, 0, 0));
			 paid_leave.setColumns(10);
			 paid_leave.setBackground(Color.LIGHT_GRAY);
			 paid_leave.setBounds(535, 409, 147, 32);
			 panel_4.add(paid_leave);
			 paid_leave.setText("0");
			 leave_1.setText("0");
			 
			 da_txtfield = new JTextField();
			 da_txtfield.setForeground(new Color(128, 0, 0));
			 da_txtfield.setFont(new Font("Tahoma", Font.BOLD, 13));
			 da_txtfield.setColumns(10);
			 da_txtfield.setBackground(Color.LIGHT_GRAY);
			 da_txtfield.setBounds(183, 410, 147, 32);
			 panel_4.add(da_txtfield);
			 da_txtfield.setText("0");
			 
			 JButton btnGenerateSalary = new JButton("Generate Salary");
			 btnGenerateSalary.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent gen) {
			 		if(gen.getSource() == btnGenerateSalary) {
			 			
			 			 String l1 = leave_1.getText();
			 			 int leave_int = Integer.parseInt(l1);
			 			 String paid_leave1  = paid_leave.getText();
			 			 int paid_int = Integer.parseInt(paid_leave1);
			 			 int leaves = leave_int - paid_int;
			 			 DA_per = da_txtfield.getText();
			 			 
			 			 int DA_int  = Integer.parseInt(DA_per);
			 			 System.out.println(leaves);
			 			 
			 			
			 			int present_days = days - leaves;
			 			 p_day = Integer.toString(present_days);
			 			System.out.println("Working Days : "+present_days);
			 			
//			 			PayrollInsert.payrollinsert(na1,UID, d1,doj1,days,da1,b1,acn1,p_day,pay_month);
			 			String total_day = Integer.toString(days);
			 				if(ok.equals("0")) {
			 					PayrollInsert.payrollinsert(na1,UID, d1,doj1,total_day,da1,b1,acn1,p_day,pay_month);
					 			JOptionPane.showMessageDialog(frame,UID+" Salary Slip SuccessFully Generated"); 
					 			PDF obj1 =new PDF();
					 			obj1.generatePDF(UID,na1,acn1,b1,present_days,pay_month,da1,d1,doj1,DA_per);
			 				}
			 				else if(ok.equals("1")) {
			 					JOptionPane.showMessageDialog(frame,UID+"Salary Slip Already Genrated For Month "+pay_month); 
			 				}
			 			
			 			 
			 			 
			 		}
			 	}
			 });
			 btnGenerateSalary.setForeground(Color.WHITE);
			 btnGenerateSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
			 btnGenerateSalary.setBackground(new Color(46, 139, 87));
			 btnGenerateSalary.setBounds(261, 635, 244, 43);
			 btnGenerateSalary.setFocusPainted(false);
			 panel_4.add(btnGenerateSalary);
			 
		
			 
			 JLabel lblDa = new JLabel("DA :");
			 lblDa.setFont(new Font("Tahoma", Font.BOLD, 15));
			 lblDa.setBounds(143, 409, 40, 32);
			 panel_4.add(lblDa);
			 
			 JLabel lblDa_1 = new JLabel("%");
			 lblDa_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			 lblDa_1.setBounds(331, 409, 40, 32);
			 panel_4.add(lblDa_1);
			 
			 fetchid();

	}

	public void  getmonth() {
		
		if(currentMonth == 1) {
			m1 = "January";
			days = 31;
		}
		else if(currentMonth == 2) {
			m1 = "February";
			days = 28;
		}
		else if(currentMonth == 3) {
			m1 = "March";
			days = 31;
		}
		else if(currentMonth == 4) {
			m1 = "April";
			days = 30;
		}
		else if(currentMonth == 5) {
			m1 = "May";
			days = 31;
		}
		else if(currentMonth == 6) {
			m1 = "June";
			days = 30;
		}
		else if(currentMonth == 7) {
			m1 = "July";
			days = 31;
		}
		else if(currentMonth == 8) {
			m1 = "August";
			days = 31;
		}
		else if(currentMonth == 9) {
			m1 = "September";
			days = 30;
		}
		else if(currentMonth == 10) {
			m1 = "October";
			days = 31;
		}
		else if(currentMonth == 11) {
			m1 = "November";
			days = 30;
		}
		else if(currentMonth == 12) {
			m1 = "December";
			days = 31;
		}
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
//		      ResultSet rs = stm.executeQuery(query);
		    		  while (rs.next()) {
		  		        UID = rs.getString("UID");
		  		        na1 = rs.getString("Name");
		  		        e1 = rs.getString("Email");
		  		        p1 = rs.getString("Phone");
		  		        d1 = rs.getString("DOB");
		  		        doj1 = rs.getString("DOJ");
		  		        da1 =rs.getString("Department");
		  		        g1 =rs.getString("Gender");
		  		        a1 =rs.getString("Address");
		  		        c1 =rs.getString("City");
		  		        s1 = rs.getString("Salary");
		  		        acn1 = rs.getString("Account_No");
		  		        
//		  		      comboBox_11.setSelectedItem(da1);
//		  		      comboBox_12.setSelectedItem(g1);
		  		      String[] dat1 = d1.split("-"); 
//		  		      Set Values From in TextField
		  		      
//		  		      Values For Date
//		  		      tf3.setText(dat1[0]);
//		  		      tf4.setText(dat1[1]);
//		  		      tf5.setText(dat1[2]); 
		  		      System.out.println("Date of Joining "+doj1);
		  		      }
		  con.close();
		  } catch(SQLException e) {
		      e.printStackTrace();
		    }
		
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
	  		        uid.addItem(UID);
	  		        uid_r.addItem(UID);
	  		        i++;
	  		      }
	  con.close();
	  } catch(SQLException e) {
	      e.printStackTrace();
	    }
	
}
public void fetchItem() {
	fetchItem = (String)uid.getSelectedItem();
}

public void fetch_salary_record() {
	
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
	      ResultSet rsa = psmt.executeQuery();
//	      ResultSet rs = stm.executeQuery(query);
	    		  	while (rsa.next()) {
	    			 UID_r = rsa.getString("UID");
	  		        name_r = rsa.getString("Name");
	  		        acno_r = rsa.getString("Account_No");	
	  		        dob_r = rsa.getString("DOB");
	  		        doj_r = rsa.getString("DOJ");
	  		        pm = rsa.getString("Pay_Month");
	  		        da_r =rsa.getString("Department");
	  		        basic_r = rsa.getString("Basic");
	  		        
//	  		        max_days = rsa.getString("Total_days");
	  		  
	  		        
	  		        
	  		     
	  		      }
	    		  	
	  con.close();
	  } catch(SQLException e) {
	      e.printStackTrace();
	    }
}
public void fetch_id_month_year_record() {
	fetch_r_uid = (String)uid_r.getSelectedItem();
//	uid_r.addItem(UID);
	fetch_r_month = (String)month_r.getSelectedItem();
	fetch_r_year = (String)year_r.getSelectedItem();
}
public void CheckExist_OR_NOT(String UID,String Paymonth)

{
try {
		      String url = "jdbc:mysql://localhost:3306/ems?autoReconnect=true&useSSL=false";
		      String user = "root";
		      String password = "";
		      Connection con = DriverManager.getConnection(url, user, password);
		     String query= "SELECT EXISTS(SELECT * from payroll WHERE (UID=? AND Pay_Month = ?) ) AS Result";
		      PreparedStatement psmt = con.prepareStatement(query);
		      psmt.setString(1,UID);
		      psmt.setString(2,Paymonth);		      
		      ResultSet rs = psmt.executeQuery();

		    		  while (rs.next()) {
		  		       ok = rs.getString("Result");
		  		      System.out.println(e1);

		  		        
		  		      }
		  con.close();
		  } catch(SQLException e) {
		      e.printStackTrace();
		    }
}

public void fetch_For_Record(String uid,String paymonth) {
	try 
	  {
	      String url = "jdbc:mysql://localhost:3306/ems?autoReconnect=true&useSSL=false";
	      String user = "root";
	      String password = "";
	    
	      Connection con = DriverManager.getConnection(url, user, password);
	      Statement stm = con.createStatement();
	    
	      String query = "SELECT * FROM payroll WHERE (UID = ? AND Pay_Month = ?)";
	      PreparedStatement psmt = con.prepareStatement(query);
	      psmt.setString(1,uid);
	      psmt.setString(2,mon_r);
	      ResultSet rsa = psmt.executeQuery();
	    		  	while (rsa.next()) {
	    			UID_record = rsa.getString("UID");
	  		        name_record = rsa.getString("Name");
	  		        acno_record = rsa.getString("Account_No");	
	  		        EPF_record = rsa.getString("EPF");
	  		        dob_record = rsa.getString("DOB");
	  		        doj_record = rsa.getString("DOJ");
	  		        dep_record =rsa.getString("Department");
	  		        basic_record = rsa.getString("Basic");
	  		        Workingday_record = rsa.getString("Working_days");
	  		        esi_record = rsa.getString("ESI");
	  		        DA_F_record= rsa.getString("DA");
	  		        HRA_record = rsa.getString("HRA");
	  		        itax_record = rsa.getString("Income_Tax"); 
	  		        earning_record =  rsa.getString("Total_Earning");
	  		        dedeu_record = rsa.getString("Total_Deducation");
	  		        netpay_record = rsa.getString("NetPay");
	  		        pm_record = rsa.getString("Pay_Month");

	  		        
	  		        
	  		     
	  		      }
	    		  	
	  con.close();
	  } catch(SQLException e) {
	      e.printStackTrace();
	    }
	
}
public static int Login_check(String id,String pass){
	String  user = "admin";
	String pas = "admin777";
	if(user.equals(id) && pas.equals(pass)) {
		return 1;
	}
	else {
		return 0;
	}
}
}
