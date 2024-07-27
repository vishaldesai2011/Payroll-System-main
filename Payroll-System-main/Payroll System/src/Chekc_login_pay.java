public class Chekc_login_pay {
	
	public static void main(String []args) {
	int log = Payroll.Login_check("admin","admin777");
	System.out.println(log);
	if (log == 1) {
		System.out.println("Success");
	}
	else {
		System.out.println("Failed");
	}
	}
}
