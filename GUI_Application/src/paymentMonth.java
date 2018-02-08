import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

class paymentMonth extends JFrame implements ActionListener {
	 Connection con=null;
	 Statement st=null;
	 ResultSet rs= null;
	DefaultTableModel model;
	JTable table;
	JPanel c;
	
	//gui button
	JComboBox boxMonth,boxYear;
	JLabel lbMonth,lbYear;
	JButton btnClear,btnSubmit;	//before
	
	JButton btnPaymentClear,btnSave;  //after
	JLabel lbPayment,lbAmount,lbDate,lbRemaark,lbDetail,lbExmp;
	JTextField txAmount,txDate,txRemark;
	JComboBox boxPayType;
	JList lstDetail;
	int MONTH;
	String YEAR;
	public paymentMonth() {		//making this cons because of object creation during main form load
		
	}
	
	public paymentMonth(String order) {		//making gui in this cons because need data table updated after table is loaded and deleted
		gui();
	}
	
	void gui() {

			setBounds(200, 80,1000, 700);
			setTitle("Mothly Regular Entry");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			c= new JPanel(null);
			this.add(c);
			
				
			String[] month= {"None","January","February","March","April","May","June","July","August",
							"September","October","November","December"};
			String[] year= {"None","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020",
							"2021","2022","2023","2024","2025","2026","2027","2028","2029","2030",
							"2031","2032","2033","2034","2035","2036","2037","2038","2039","2040",
							"2041","2042","2043","2044","2045","2046","2047","2048","2049","2050"};
			
			boxMonth= new JComboBox(month);			boxMonth.setBounds(350, 100, 150, 20);
			boxYear= new JComboBox(year);			boxYear.setBounds(350, 150, 150, 20);
			
			c.add(boxMonth);
			c.add(boxYear);
			
			lbMonth= new JLabel("Select Month");		lbMonth.setBounds(250, 100, 150, 20);
			lbYear= new JLabel("Select Year");		lbYear.setBounds(250, 150, 150, 20);
		
			btnClear= new JButton("CLEAR");	btnClear.setBounds(290,200, 100, 30);
			btnSubmit= new JButton("SUBMIT");btnSubmit.setBounds(390,200, 100, 30);
			
			c.add(lbYear);c.add(lbMonth);
			c.add(btnClear);c.add(btnSubmit);
			setVisible(true);
			
			btnClear.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					boxMonth.setSelectedIndex(0);   boxYear.setSelectedIndex(0);
				}
			});
			
			btnSubmit.addActionListener(new ActionListener()  {
				@Override
				public void actionPerformed(ActionEvent e) {
					if( (boxMonth.getSelectedIndex()==0) || (boxYear.getSelectedIndex()==0) )	///catch if not selected
					{
						
						JOptionPane.showMessageDialog(null, 
				                "Select Month/Year", 
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
					
					else {	
						
						maketableWithForm(boxMonth.getSelectedIndex(),boxYear.getSelectedItem().toString());
						setTitle(boxMonth.getSelectedItem().toString()+" "+ boxYear.getSelectedItem().toString());
						}
				}
			});	
			
		}	//end of gui method
	
	void maketableWithForm(int month,String year) {		//only make table no connection
		
		//clear button from previous
		c.remove(boxMonth);   c.remove(boxYear);  c.remove(btnClear); c.remove(btnSubmit);
		c.remove(lbMonth);  c.remove(lbYear);
		//
		this.YEAR=year;
		this.MONTH=month;
		//enter new component
		lbDetail = new JLabel("Payment Types");		lbDetail.setBounds(600,20, 150, 30);
		String[] data= {"Select","1-Electricity","2-Apartment Rent","3-Water","4-Internet","5-Phone",
						"6-Car Insurance","7-Car Loan Payment","8-Health Insurance","9-Credit Card"};
		lstDetail= new JList(data);					lstDetail.setBounds(600,50, 150, 170);
		lstDetail.setVisibleRowCount(9);
		
		lbPayment= new JLabel("Payment Type");		lbPayment.setBounds(100,20, 150, 30);
		lbAmount = new JLabel("Amount");				lbAmount.setBounds(100,50, 150, 30);
		lbDate=new JLabel("Date");					lbDate.setBounds(100,80, 150, 30);
		lbExmp= new JLabel("[YYYY-MM-DD]");			lbExmp.setBounds(350, 80, 150, 30);
		lbRemaark= new JLabel("Remark");				lbRemaark.setBounds(100,110, 150, 30);
		
		txAmount= new JTextField();					txAmount.setBounds(200,50, 150, 30);
		txDate= new JTextField();					txDate.setBounds(200,80, 150, 30);
		txRemark= new JTextField();					txRemark.setBounds(200,110, 150, 30);
		String[] pType= {"Select","1-Electricity","2-Apartment Rent","3-Water","4-Internet","5-Phone",
						"6-Car Insurance","7-Car Loan Payment","8-Health Insurance","9-Credit Card"};
		boxPayType= new JComboBox(pType);			boxPayType.setBounds(200,20, 150, 30);
		
		btnPaymentClear= new JButton("Clear");		btnPaymentClear.setBounds(130,150, 100, 30);
		btnSave= new JButton("Save");				btnSave.setBounds(250,150, 100, 30);
		
		btnPaymentClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txAmount.setText(""); 	txDate.setText(""); txRemark.setText(""); boxPayType.setSelectedIndex(0);
			}
		});
		
		btnSave.addActionListener(new ActionListener()  {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if( (txAmount.getText().isEmpty()) || (txDate.getText().isEmpty()) || (txRemark.getText().isEmpty()))
				{	JOptionPane.showMessageDialog(null, 
                    "Provide Expense Details", 
                    "Input required", 
                    JOptionPane.INFORMATION_MESSAGE);
				}
				
			else
			{
				try {
					String amt= txAmount.getText();
					String dat=txDate.getText(); //[yyyy-mm-dd]
					Pattern p= Pattern.compile("[0-9]*(\\.[0-9]+)?");	//Pattern p= Pattern.compile("[0-9]{1,5}(\\.[0-9]+)?");//for amt
					Pattern pd=Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");		//for date
					
					Matcher m=p.matcher(amt);
					Matcher md=pd.matcher(dat);
					
					if(m.matches()	&& md.matches()) 
					{
						String str[] = dat.split("-");
						int mo = Integer.parseInt(str[1]);
						String yr = String.valueOf(str[0]);
						if((boxMonth.getSelectedIndex()!=mo) || (!boxYear.getSelectedItem().toString().equals(yr))) 
						{	   JOptionPane.showMessageDialog(null, 
					           "You are putting wrong Month/Year for this form!!\nTry opening this window again", 
					           "Warning!!!", 
					           JOptionPane.INFORMATION_MESSAGE);
							
						}
						//catch date
						else if(LocalDate.parse(txDate.getText()).isAfter(LocalDate.now())) {
							JOptionPane.showMessageDialog(null, 
				                    "Invalid Date", 
				                    "Warning!!!", 
				                    JOptionPane.INFORMATION_MESSAGE);
							
						}
						else {
							int cid=boxPayType.getSelectedIndex();	
							double amount=Double.parseDouble(txAmount.getText());
							String date=txDate.getText();
							String remark=txRemark.getText();
							enterData(cid,amount,date,remark);
							txAmount.setText(null);txDate.setText(null);txRemark.setText(null); boxPayType.setSelectedIndex(0);
							//System.out.println("good amount");
						}
					}
					else {	
						JOptionPane.showMessageDialog(null, 
			            "Something went wrong!!", 
			            "Check Input Details", 
			            JOptionPane.INFORMATION_MESSAGE);
					}
					
					updat_table();
					
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			
			
			}		//end of if statem
				
			}
		});
		
		c.add(lbPayment); c.add(lbAmount);	c.add(lbDate);	c.add(lbRemaark);	c.add(lbExmp);
		c.add(txAmount);	c.add(txDate);	c.add(txRemark);	c.add(boxPayType);
		c.add(btnPaymentClear);	c.add(btnSave);
		c.add(lstDetail); c.add(lbDetail);
		// end of new component addition
		model= new DefaultTableModel();
		table = new JTable(model);
		
		
		//model.addColumn("Expense ID");
		model.addColumn("Expense ID");
		model.addColumn("Amount");
		model.addColumn("Date");
		model.addColumn("Category");   ///we gonna take from another table
		model.addColumn("Remarks");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection(  
						"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k");  
		
				PreparedStatement pst=null;
				ResultSet rr= null;
				
				pst=conn.prepareStatement("Select expense.expenseID,expense.amount,expense.date,category.name,expense.remark from expense,category "
						+ "where (expense.categoryID!=10) and (year(expense.date)=?) and (month(expense.date)=?) and (category.categoryID=expense.categoryID)");
				pst.setString(1, year);
				pst.setInt(2, month);
				rr=pst.executeQuery();
					//
			
				while(rr.next())  {
			
					model.addRow(new Object[]{rr.getString(1),rr.getString(2),rr.getString(3),rr.getString(4),rr.getString(5)});
				}
				table.setModel(model);
				table.setPreferredScrollableViewportSize(new Dimension(800, 400));
				table.setFillsViewportHeight(true);
				JScrollPane scpan = new JScrollPane(table);
				this.add(scpan,BorderLayout.NORTH);
				this.revalidate();		//refresh the frame
				
				rr.close();
				pst.close();
				conn.close();  
				
			}
			catch(Exception e) {e.printStackTrace();}
			table.setVisible(true);
		}
	void updat_table(){		//this update is done using rs2xml.jar file
		 int month=this.MONTH;
		 String year=this.YEAR;
		 
		 try {
			
			 Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(  
						"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k"); 
			 
			// String sql="select categoryid,amount,date,remark from expense where categoryid!=10 and date >? and date<?";
			
			//PreparedStatement pst=conn.prepareStatement("Select categoryID,amount,date,remark from expense where (categoryID!=10) and (year(date)=?) and (month(date)=?)");
			PreparedStatement pst=conn.prepareStatement("Select expense.expenseID,expense.amount,expense.date,category.name,expense.remark from expense,category "
					+ "where (expense.categoryID!=10) and (year(expense.date)=?) and (month(expense.date)=?) and (category.categoryID=expense.categoryID)");
			pst.setString(1, year);
			pst.setInt(2, month);
			 
			 ResultSet rr=pst.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rr));		//using from rs2xml.jar file
			 //model.fireTableStructureChanged();
			 
			 rr.close();
			 pst.close();
			 conn.close();
		 	}
		 	catch(Exception ek){JOptionPane.showMessageDialog(null, ek);}
	 	}
	
	void enterData( int cID, double amount,String date,String remark) throws SQLException{
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k"); 
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery("Select expenseID,categoryID,amount,date,remark from expense");
		
			rs.beforeFirst();
			rs.moveToInsertRow();	//to insert table should have primary key???
			//rs.updateInt(1, eID);	//it is automatic increment in database
			rs.updateInt(2, cID);
			rs.updateDouble(3, amount);
			rs.updateString(4, date);
			rs.updateString(5, remark);
			rs.insertRow();
			
			JOptionPane.showMessageDialog(null, 
                "Payment Completed", 
                "Successfull", 
                JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		finally {
			if(rs!=null) {rs.close();}	//close database
			  if(st!=null) {st.close();}
			  if(con!=null) {con.close();}
		}
		
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new paymentMonth("make new payment gui");
			
		}
}
