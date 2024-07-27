import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;

//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
//import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
 
/**
 * This class is used to create a pdf file using iText jar.
 * @author w3spoint
 */
public class PDF {
	String slip;
//  public static void main(String args[]){
	public void generatePDF(String UID,String Name,String Acno,String Basic,int workingdays,String Paymonth,String Dep,String Bdate,String DateofJoin,String DA_per) {
    try {
    	slip = "D:\\Projects\\Salary_Slip\\"+UID+"_"+Paymonth+".pdf";
    	
       	//Create Document instance.
	Document document = new Document();
	
	//Create OutputStream instance.
	OutputStream outputStream = 
//		new FileOutputStream(new File("D:\\TestPDF.pdf"));
			new FileOutputStream(new File(slip));
 
	//Create PDFWriter instance.
        PdfWriter.getInstance(document, outputStream);
 
        //Open the document.
        document.open();
        
//      Print Current Month and Date
        LocalDate currentdate = LocalDate.now();
      	Month currentMonth = currentdate.getMonth();
      	int currentYear = currentdate.getYear();
      
//        Font fontSize_16 =  FontFactory.getFont(FontFactory.TIMES, 22f);
        Font fontStyle_Normal =  FontFactory.getFont(FontFactory.TIMES, 18f, Font.BOLD);
        Font fontsize_13 =  FontFactory.getFont(FontFactory.TIMES, 13f, Font.BOLD);
        Font fontsize_10 =  FontFactory.getFont(FontFactory.TIMES, 10f, Font.BOLD);
//        Font fontColour_white =  FontFactory.getFont(FontFactory.TIMES, 13f, Font.BOLD, BaseColor.WHITE);
 
        //Add content to the document.
//        document.add(new Paragraph("Salary Recipt 2022-2023",fontStyle_Normal));
        Paragraph Employyer =new Paragraph("Company Name "+"\n\n",fontStyle_Normal);
        Employyer.setAlignment(Element.ALIGN_CENTER); 
        document.add(Employyer);
        
        
        Paragraph p =new Paragraph("Salary Slip "+"\n\n",fontStyle_Normal);
//        Make A Text Center
        p.setAlignment(Element.ALIGN_CENTER); 
        document.add(p);
//        Paragraph MON =new Paragraph("Salary Month : "+currentMonth+"-"+currentYear+"\n");
        Paragraph MON =new Paragraph("Salary Month : "+Paymonth+"\n");
        document.add(MON);
        Paragraph Eno =new Paragraph("EMP NO        : "+UID +"\n");
        document.add(Eno);
        Paragraph PFN =new Paragraph("PF NO           : "+"N/A \n");
        document.add(PFN);
        Paragraph DOB =new Paragraph("DOB              : "+Bdate+"\n");
        document.add(DOB);
        Paragraph DOJ =new Paragraph("DOJ               : "+DateofJoin+"\n");
        document.add(DOJ);
        Paragraph WRD =new Paragraph("WORKDAYS :"+workingdays+"\n");
        document.add(WRD);
        Paragraph DEP =new Paragraph("DEP               : "+Dep+"\n");
        document.add(DEP);
        Paragraph WRK =new Paragraph("Account NO  : "+Acno+"\n\n");
        document.add(WRK);	
        
        
        Calendar c = Calendar.getInstance();
        int MaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
//        Calculation For Slary
        int basic_salary1  = Integer.parseInt(Basic); 
        int DA_per1  = Integer.parseInt(DA_per); 
        int perday = basic_salary1 / MaxDays;
        
        basic_salary1 = workingdays * perday;
        int DA = (basic_salary1 * DA_per1)/100;
        double HRA = basic_salary1 * 0.04;
        int tpt = 1600;
        
        double Earning = basic_salary1 + DA +HRA + tpt ;
//        deducation
        int ProfTax = 200;
        double esi = basic_salary1 * 0.0075;
        int esi_i = (int)esi;
        double epf = basic_salary1 * 0.12;
        int epf_i = (int)epf;
        double tax;
        
//        int basic_salary = basic_salary1;
        int basic_salary = basic_salary1;
        
        
        if(basic_salary > 250000 && basic_salary < 500000) {
        	tax = (basic_salary - 250000) * 0.05;
//        	tax = tax/12;
        }
        else if(basic_salary > 500001 && basic_salary < 750000) {
//        	tax = 2500+12500;
        	tax = (basic_salary - 500000) * 0.10 + 12500;
//        	tax = tax/12;
        }
        else if(basic_salary > 750001 && basic_salary < 1000000) {
        	tax = (basic_salary - 750000) * 0.15 + 12500+25000;
//        	tax = tax/12;
        }
        else if(basic_salary > 1000001 && basic_salary < 1250000) {
        	tax = (basic_salary - 100000) * 0.20 + 12500+25000+37500;
//        	tax = tax/12;
        }
        else if(basic_salary > 1250001 && basic_salary < 1500000) {
        	tax = (basic_salary - 1250000) * 0.25 + 12500+25000+37500+50000;
//        	tax = tax/12;
        }
        else if(basic_salary > 1500000){
        	tax = (basic_salary - 150000) * 0.30 + 12500+25000+37500+50000+62500;
//        	tax = tax/12;
        }
        else {
        	tax = 0;
        }
        
        DecimalFormat df_obj = new DecimalFormat("#");
        String tax1 = df_obj.format(tax);
        String esi1 = df_obj.format(esi);
        String epf1 = df_obj.format(epf);
        System.out.println(tax1);
//        basic_salary= basic_salary/12;
        int tax_i = (int)tax;
//        int tax_i = (int)tax/12;
        double Deducation = ProfTax + esi + epf +tax;
//        int Deducation_1 = ProfTax + esi_i + epf_i +tax_i;
        
        String ded1 = df_obj.format(Deducation);
        
        double netpay = Earning - Deducation;
        int npay = (int)netpay;
        String npay_s = df_obj.format(npay);
        String HRA_s = df_obj.format(HRA);
        String Earning_s = df_obj.format(Earning);
//        String npay1 = df_obj.format(npay);
        
        
       
       
//        tax = Integer.parseInt(tax1);
        
        
//        Making Table
        PdfPTable pdfPTable = new PdfPTable(4);	
        
      //Create cells
        PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Name",fontsize_13));
        PdfPCell pdfPCell2 = new PdfPCell(new Paragraph(Name,fontsize_13));
        PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Earning",fontsize_13));
        PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("Amount(Rs.)",fontsize_13));
        PdfPCell pdfPCell5 = new PdfPCell(new Paragraph("Deducation",fontsize_13));
        PdfPCell pdfPCell6 = new PdfPCell(new Paragraph("Amount(Rs.)",fontsize_13));
        PdfPCell pdfPCell7 = new PdfPCell(new Paragraph("Basic Pay   "));
        PdfPCell pdfPCell8 = new PdfPCell(new Paragraph(basic_salary+".00"));
        PdfPCell pdfPCell9 = new PdfPCell(new Paragraph("Professional Tax  "));
//        Profational Tax is 200 if Salary Gratterthan 12000
        PdfPCell pdfPCell10 = new PdfPCell(new Paragraph(ProfTax+".00"));
        PdfPCell pdfPCell11 = new PdfPCell(new Paragraph("DA "));
        PdfPCell pdfPCell12 = new PdfPCell(new Paragraph(DA+".00"));
        PdfPCell pdfPCell13 = new PdfPCell(new Paragraph("E.S.I "));
        PdfPCell pdfPCell14 = new PdfPCell(new Paragraph(""+esi1+".00"));
        PdfPCell pdfPCell15 = new PdfPCell(new Paragraph("HRA"));
        PdfPCell pdfPCell16 = new PdfPCell(new Paragraph(""+HRA_s));
        PdfPCell pdfPCell17 = new PdfPCell(new Paragraph("E.P.F "));
        PdfPCell pdfPCell18 = new PdfPCell(new Paragraph(""+epf1+".00"));
        PdfPCell pdfPCell19 = new PdfPCell(new Paragraph("TPT Allow"));
        PdfPCell pdfPCell20 = new PdfPCell(new Paragraph(tpt+".00"));
        PdfPCell pdfPCell21 = new PdfPCell(new Paragraph("Income Tax"));
        PdfPCell pdfPCell22 = new PdfPCell(new Paragraph(""+tax1+".00"));
        PdfPCell pdfPCell23 = new PdfPCell(new Paragraph("Total Earning",fontsize_13));
        PdfPCell pdfPCell24 = new PdfPCell(new Paragraph(""+Earning_s+".00",fontsize_13));
        PdfPCell pdfPCell25 = new PdfPCell(new Paragraph("Total Deducation",fontsize_13));
        PdfPCell pdfPCell26 = new PdfPCell(new Paragraph(""+ded1+".00",fontsize_13));
        PdfPCell pdfPCell27 = new PdfPCell(new Paragraph("Net Pay : "+npay_s+".00/-",fontsize_13));
        PdfPCell pdfPCell28 = new PdfPCell(new Paragraph("In Word : "+numberToWord(npay)+" Rupee Only",fontsize_13));
        
        update_with_value(ProfTax,DA,esi1,HRA,epf1,tpt,tax1,Earning,ded1,npay,UID,Paymonth,basic_salary);        
        
        // Use To Get Colspan
        pdfPCell2.setColspan(3);
        pdfPCell27.setColspan(4);
        pdfPCell28.setColspan(4);
        
        pdfPCell1.setHorizontalAlignment(Element.ALIGN_CENTER); 
        pdfPCell3.setHorizontalAlignment(Element.ALIGN_CENTER); 
        pdfPCell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell5.setHorizontalAlignment(Element.ALIGN_CENTER); 
        pdfPCell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell7.setHorizontalAlignment(Element.ALIGN_CENTER); 
        pdfPCell8.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell9.setHorizontalAlignment(Element.ALIGN_CENTER); 
        pdfPCell10.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell11.setHorizontalAlignment(Element.ALIGN_CENTER); 
        pdfPCell11.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell12.setHorizontalAlignment(Element.ALIGN_CENTER); 
        pdfPCell13.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell14.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell15.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell16.setHorizontalAlignment(Element.ALIGN_CENTER); 
        pdfPCell17.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell18.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell19.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell20.setHorizontalAlignment(Element.ALIGN_CENTER); 
        pdfPCell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell22.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell23.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell24.setHorizontalAlignment(Element.ALIGN_CENTER); 
        pdfPCell25.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell26.setHorizontalAlignment(Element.ALIGN_CENTER);
        
        
//        For BackGround Color
//        pdfPCell3.setBackgroundColor(BaseColor.GRAY);
        

        
        //Add cells to table
        pdfPTable.addCell(pdfPCell1);
        pdfPTable.addCell(pdfPCell2);
        pdfPTable.addCell(pdfPCell3);
        pdfPTable.addCell(pdfPCell4);
        pdfPTable.addCell(pdfPCell5);
        pdfPTable.addCell(pdfPCell6);
        pdfPTable.addCell(pdfPCell7);
        pdfPTable.addCell(pdfPCell8);
        pdfPTable.addCell(pdfPCell9);
        pdfPTable.addCell(pdfPCell10);
        pdfPTable.addCell(pdfPCell11);
        pdfPTable.addCell(pdfPCell12);
        pdfPTable.addCell(pdfPCell13);
        pdfPTable.addCell(pdfPCell14);
        pdfPTable.addCell(pdfPCell15);
        pdfPTable.addCell(pdfPCell16);
        pdfPTable.addCell(pdfPCell17);
        pdfPTable.addCell(pdfPCell18);
        pdfPTable.addCell(pdfPCell19);
        pdfPTable.addCell(pdfPCell20);
        pdfPTable.addCell(pdfPCell21);
        pdfPTable.addCell(pdfPCell22);
        pdfPTable.addCell(pdfPCell23);
        pdfPTable.addCell(pdfPCell24);
        pdfPTable.addCell(pdfPCell25);
        pdfPTable.addCell(pdfPCell26);
        pdfPTable.addCell(pdfPCell27);
        pdfPTable.addCell(pdfPCell28);

 
        //Add content to the document using Table objects.
        document.add(pdfPTable);
       
        //Create Image object
        Paragraph SIG =new Paragraph("Payee's Signature");
        SIG.setAlignment(Element.ALIGN_CENTER);
        Image image = Image.getInstance("D:\\vishal.jpg");
        image.setAlignment(Element.ALIGN_CENTER);
        //Add content to the document using Image object.
        document.add(image);
        document.add(SIG);	
        
        //Close document and outputStream.
        document.close();
        outputStream.close();
 
        System.out.println("Pdf created successfully.");
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
//}
//https://www.javamadesoeasy.com/2016/06/how-to-set-font-name-size-style-and.html

// Convert Ruppes InTo Word in
private static String numberToWord(int number) {
    // variable to hold string representation of number 
    String words = "";
    String unitsArray[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", 
                  "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                  "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", 
                  "Eighteen", "Nineteen" };
String tensArray[] = { "zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
                  "Sixty", "Seventy", "Eighty", "Ninety" };

if (number == 0) {
    return "Zero";
}
// add minus before conversion if the number is less than 0
if (number < 0) { 
       // convert the number to a string
       String numberStr = "" + number; 
       // remove minus before the number 
       numberStr = numberStr.substring(1); 
       // add minus before the number and convert the rest of number 
       return "minus " + numberToWord(Integer.parseInt(numberStr)); 
    } 
    // check if number is divisible by 1 million
    if ((number / 1000000) > 0) {
   words += numberToWord(number / 1000000) + " Million ";
   number %= 1000000;
}
// check if number is divisible by 1 thousand
if ((number / 1000) > 0) {
    words += numberToWord(number / 1000) + " Thousand ";
    number %= 1000;
}
// check if number is divisible by 1 hundred
if ((number / 100) > 0) {
     words += numberToWord(number / 100) + " Hundred ";
     number %= 100;
}

if (number > 0) {
     // check if number is within teens
     if (number < 20) { 
                // fetch the appropriate value from unit array
                words += unitsArray[number];
         } else { 
            // fetch the appropriate value from tens array
            words += tensArray[number / 10]; 
            if ((number % 10) > 0) {
	    words += "-" + unitsArray[number % 10];
            }  
     }
      }
  return words;
}
public void update_with_value(int ProfTax,int DA,String esi1,double HRA,String epf1,int tpt,String tax1,double earning,String ded1,int netpay,String UID,String Paymonth,int basic) {
	try{  
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/ems","root","");  
		//here ems is database name, root is username and password  

		//String q ="update record(Name,Phone,Email,DOB,Department,Gender,Address,City,Salary) values(?,?,?,?,?,?,?,?,?) where UID = ?";
		String q = "UPDATE payroll SET ProfTax = ?,DA = ?,ESI = ?,HRA = ?,EPF = ?,TPT = ?,Income_Tax = ?,Total_Earning = ?,Total_Deducation = ?,NetPay = ?,Basic = ? WHERE (UID = ? AND Pay_Month = ?)";
		//get Prepared Statement
		 

		PreparedStatement psmt = con.prepareStatement(q);
		//Set The Value
		String ProfTax1 = Integer.toString(ProfTax);
		String DA1 = Integer.toString(DA);
		String HRA1 = Double.toString(HRA);
		String tpt1 = Integer.toString(tpt);
		String earning1 = Double.toString(earning); 
		String netpay1 = Integer.toString(netpay);
		String basic1 = Integer.toString(basic);
		
		psmt.setString(1,ProfTax1);
		psmt.setString(2,DA1);
		psmt.setString(3,esi1);
		psmt.setString(4,HRA1);
		psmt.setString(5,epf1);
		psmt.setString(6,tpt1);
		psmt.setString(7,tax1);
		psmt.setString(8,earning1);
		psmt.setString(9,ded1);
		psmt.setString(10,netpay1);
		psmt.setString(11,basic1);
		psmt.setString(12,UID);
		psmt.setString(13,Paymonth);
		psmt.executeUpdate();
//		System.out.println("Upadte Successfully...."+fetchItem);
		con.close();
		}catch(Exception e){ System.out.println(e);}    
		} 
}

