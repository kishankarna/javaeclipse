import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class reportCat extends JFrame implements ActionListener {
	DefaultTableModel model;
	JTable table;
	JPanel c;
	 
	public reportCat() {}
	public reportCat(String order) {
		gui();
		
	}
	void gui() {
		
		setBounds(200, 80,1000, 700);
		setTitle("Database --Categorywise-- Reports");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		c= new JPanel(null);
		this.add(c);
		
		JLabel lbCat= new JLabel("Categody-ID");	lbCat.setBounds(300, 100, 100, 20);
		//JTextField txCat= new JTextField();		//txCat.setBounds(200, 70, 100, 20);
		JButton btnClear= new JButton("CLEAR");	btnClear.setBounds(350,140, 100, 30);
		JButton btnSubmit= new JButton("SUBMIT");btnSubmit.setBounds(450,140, 100, 30);
		
		String[] msg= {"Select","1-Electricity","2-Apartment Rent","3-Water","4-Internet","5-Phone",
						"6-Car Insurance","7-Car Loan Payment","8-Health Insurance","9-Credit Card","10-Miscellaneus"};
		JComboBox box= new JComboBox(msg);			box.setBounds(400, 100, 150, 20);
		 
		
		JLabel lbHead= new JLabel("Categody-ID  Description");		lbHead.setBounds(600, 5, 300, 20);	c.add(lbHead);
		JLabel lb1= new JLabel("1 : ---------->Electricity");			lb1.setBounds(600, 25, 200, 20);	c.add(lb1);
		JLabel lb2= new JLabel("2 : ---------->Apartment Rent");		lb2.setBounds(600, 45, 200, 20);	c.add(lb2);
		JLabel lb3= new JLabel("3 : ---------->Water");				lb3.setBounds(600, 65, 200, 20);	c.add(lb3);
		JLabel lb4= new JLabel("4 : ---------->Internet");			lb4.setBounds(600, 85, 200, 20);	c.add(lb4);
		JLabel lb5= new JLabel("5 : ---------->Phone");				lb5.setBounds(600, 105, 200, 20);	c.add(lb5);
		JLabel lb6= new JLabel("6 : ---------->Car Insurance");		lb6.setBounds(600, 125, 200, 20);	c.add(lb6);
		JLabel lb7= new JLabel("7 : ---------->Car Loan Payment");	lb7.setBounds(600, 145, 200, 20);	c.add(lb7);
		JLabel lb8= new JLabel("8 : ---------->Health Insurance");	lb8.setBounds(600, 165, 200, 20);	c.add(lb8);
		JLabel lb9= new JLabel("9 : ---------->Credit Card");			lb9.setBounds(600, 185, 200, 20);	c.add(lb9);
		JLabel lb10= new JLabel("10 : -------->Miscellaneus");		lb10.setBounds(600, 205, 200, 20);	c.add(lb10);
	
		
		c.add(lbCat); c.add(box);
		c.add(btnClear);c.add(btnSubmit);
		setVisible(true);
		
			btnClear.addActionListener(new ActionListener() {		//inner class
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//txCat.setText(null);
				box.setSelectedIndex(0);
				
			}
			});
		
			btnSubmit.addActionListener(new ActionListener() {		//inner class
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//String cat=txCat.getText().toString();
				int cat=box.getSelectedIndex();
				//int month=box.getSelectedIndex()+1;
				maketable(cat);
				
				table.setVisible(true);
				
			}
			});
		
		}	//end of gui method
	
		void maketable(int category) {	
			model= new DefaultTableModel();
			table = new JTable(model);
			
			
			model.addColumn("Expense ID");
			model.addColumn("Category ID");
			model.addColumn("Amount");
			model.addColumn("Date");
			model.addColumn("Remarks");
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(  
							"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k");  
			
					//System.out.println("Connected!! to synology database");
					PreparedStatement pst=null;
					ResultSet rs= null;
					
					pst=con.prepareStatement("Select * from expense where categoryID=?");
					//select * from expense where month(date)=1
					pst.setInt(1, category);
					rs=pst.executeQuery();
					
					while(rs.next())  {
						
						model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
					}
					table.setModel(model);
					table.setPreferredScrollableViewportSize(new Dimension(800, 400));
					table.setFillsViewportHeight(true);
					JScrollPane scpan = new JScrollPane(table);
					this.add(scpan,BorderLayout.NORTH);
					this.revalidate();		//refresh the frame
					
				
					con.close();  
					
				}
				catch(Exception e) {e.printStackTrace();}
				table.setVisible(false);
			}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		new reportCat("make new gui");
	
	}
}
