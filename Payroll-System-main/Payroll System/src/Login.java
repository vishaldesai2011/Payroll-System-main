import javax.swing.*;
// import java.awt.Dimension;
// import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


	public class Login extends JFrame {

		public boolean log = false;
		public static int l = 0;
		
		private JPanel contentPane;
		private JTextField textField;
		private JPasswordField passwordField;
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login frame = new Login();
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
	public Login() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
         //contentPane.setBackground(Color.WHITE);
		// contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		lblNewLabel.setBounds(175, 10, 122, 86);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(86, 137, 95, 28);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(179, 136, 154, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(86, 182, 78, 28);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = e.getActionCommand();
				String s1 = "admin";
				String s2 = "admin123";
				String user = textField.getText();
				String pass = passwordField.getText();
				if (s.equals("Login"))
				{
					 if(user.equals(s1) && pass.equals(s2)){
						// textField_1.setText("UserName is True");
						
						// l = 1;
						contentPane.setVisible(false);
						// super.windowDeactivated(contentPane);
						Welcome obj = new Welcome();
						obj.setVisible(true);
					 } 
					 else{
						// JOptionPane.showMessageDialog(contentPane,"UserName or Password is Wrong"); 
						JOptionPane.showMessageDialog(contentPane,"UserName or Password is Wrong","Alert",JOptionPane.WARNING_MESSAGE);     
 
					 }  


				}
			}
			});

		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		btnNewButton.setBounds(179, 228, 110, 28);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 182, 154, 28);
		contentPane.add(passwordField);       
	}
	
}
