//import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class balanceForm  extends javax.swing.JFrame implements ActionListener{
	JComboBox boxMonth,boxYear;
	JList lstDetail;
	PreparedStatement pstS,pstB,pstO,pstMon,pstMis=null;
	ResultSet rsSal,rsBon,rsOth,rsMon,rsMis= null;	
	double sal,bon,oth,salTotal,month,misc,expTotal,netValue;
	
	Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
	Font f= new Font("Arial", Font.BOLD,18);
	Container c;
	//int totExp;
	public balanceForm() {}							//default constructor
	public balanceForm(String order) {	gui();	}	//defined constructor
	
	void gui() {
		setTitle("Balance --- Sheet");
		this.setBounds(200, 80,800, 430);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBackground(Color.BLUE);
		this.setVisible(true);
		
		c= getContentPane();
		c.setLayout(null);
		
		String[] monthStr= {"None","January","February","March","April","May","June","July","August",
						"September","October","November","December"};
		String[] year= {"None","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020",
						"2021","2022","2023","2024","2025","2026","2027","2028","2029","2030",
						"2031","2032","2033","2034","2035","2036","2037","2038","2039","2040",
						"2041","2042","2043","2044","2045","2046","2047","2048","2049","2050"};
		JLabel lbMonth= new JLabel("Select Month");		lbMonth.setBounds(50, 380, 150, 20);
		boxMonth= new JComboBox(monthStr);				boxMonth.setBounds(150, 380, 150, 20);
		JLabel lbYear= new JLabel("Select Year");		lbYear.setBounds(320, 380, 150, 20);
		boxYear= new JComboBox(year);					boxYear.setBounds(400, 380, 150, 20);
		
	
		JButton btnSubmit= new JButton("SUBMIT");btnSubmit.setBounds(650,375, 100, 30);
		c.add(boxMonth);	c.add(lbYear);	c.add(btnSubmit);
		c.add(boxYear);	c.add(lbMonth);	//c.add(btnClear);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			  if((boxMonth.getSelectedIndex()==0) || (boxYear.getSelectedIndex()==0))
				{			JOptionPane.showMessageDialog(null, 
				           "You are putting wrong Month/Year for this form!!\nTry opening this window again", 
				           "Warning!!!", 
				           JOptionPane.INFORMATION_MESSAGE);
				}
			//catch current date
				else if((boxMonth.getSelectedIndex()>(Calendar.getInstance().get(Calendar.MONTH)+1)) || (Integer.valueOf(boxYear.getSelectedItem().toString())>(Calendar.getInstance().get(Calendar.YEAR)))){
					JOptionPane.showMessageDialog(null, 
			                "Invalid Date", 
			                "Warning!!!", 
			                JOptionPane.INFORMATION_MESSAGE);
				}
				
			  else
				  {try {
					
					revalidate();
					int yy=Integer.parseInt(boxYear.getSelectedItem().toString());
					int mm=boxMonth.getSelectedIndex();
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(  
							"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k");  
			
					pstS=con.prepareStatement("Select salary from salaryTB where salaryType='salary' and month(date)=? and year(date)=?");
					pstS.setInt(1,mm);
					pstS.setInt(2,yy);
					rsSal=pstS.executeQuery();
					double tempS=0;
					while(rsSal.next())  {	tempS+=rsSal.getDouble(1);	}	sal=tempS;
					
					pstB=con.prepareStatement("Select salary from salaryTB where salaryType='bonus' and month(date)=? and year(date)=?");
					pstB.setInt(1,mm);
					pstB.setInt(2,yy);
					rsBon=pstB.executeQuery();
					double tempBon=0;
					while(rsBon.next())  {	tempBon+=rsBon.getDouble(1);	}	bon=tempBon;
					
					pstO=con.prepareStatement("Select salary from salaryTB where salaryType='other' and month(date)=? and year(date)=?");
					pstO.setInt(1,mm);
					pstO.setInt(2,yy);
					rsOth=pstO.executeQuery();
					double tempO=0;
					while(rsOth.next())  {	tempO+=rsOth.getDouble(1);	}	oth=tempO;
					
					pstMon=con.prepareStatement("Select amount from expense where categoryID<10 and month(date)=? and year(date)=?");
					pstMon.setInt(1,mm);
					pstMon.setInt(2,yy);
					rsMon=pstMon.executeQuery();
					double tempM=0;
					while(rsMon.next())  {	tempM+=rsMon.getDouble(1);	}	month=tempM;
					
					pstMis=con.prepareStatement("Select amount from expense where categoryID=10 and month(date)=? and year(date)=?");
					pstMis.setInt(1,mm);
					pstMis.setInt(2,yy);
					rsMis=pstMis.executeQuery();
					double tempMS=0;
					while(rsMis.next())  {	tempMS+=rsMis.getDouble(1);	}	misc=tempMS;
					
					salTotal= sal+bon+oth;		//for total salary
					expTotal= month+misc;		//for total expenditure
					netValue=salTotal-expTotal;	//for net income
					
					makeList();
					
					repaint();
					c.remove(btnSubmit);		//to disable after hitting button
					
					rsMon.close();	rsMis.close();  rsOth.close();  rsBon.close();  rsSal.close();
					pstB.close(); 	pstMon.close(); pstMis.close(); pstO.close();  	pstS.close();
					con.close();  
				}
				catch(Exception emsg) {emsg.printStackTrace();}
				}
			}
		});
		
		
		
	}					//end of gui
void makeList() {
			
		String[] data={"Income",
						"\t\t\t\t\t\t\t\t\t\t\t\t\tSalary:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t "+ sal,
						"\t\t\t\t\t\t\t\t\t\t\t\t\tBonus:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+ bon,
						"\t\t\t\t\t\t\t\t\t\t\t\t\tOther Income:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+						oth,
						"Total Income:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+					salTotal,
						"","","","","","",
						"Expense",
						"\t\t\t\t\t\t\t\t\t\t\t\t\tMonthly Regular Expense:\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t"+ 														month,
						"\t\t\t\t\t\t\t\t\t\t\t\t\tMiscellaneous:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+ 							misc,
						"Total Expense:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+								expTotal,
						"-------------------------------------------------------------------------"
						+ "---------------------------------",
						"Net Balance:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"
						+ "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+ 							netValue}; 
					
		lstDetail= new JList(data);					lstDetail.setBounds(50,30, 700, 320);
		lstDetail.setFont(f);
		lstDetail.setBounds(50, 20,700, 340);
		//lstDetail.setVisibleRowCount(9);
		lstDetail.setBorder(lineBorder);
		lstDetail.setToolTipText("Banace Sheet");
		lstDetail.setBackground(Color.gray);
		
		c.add(lstDetail);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new balanceForm("Create new gui again");
		
	}

}
