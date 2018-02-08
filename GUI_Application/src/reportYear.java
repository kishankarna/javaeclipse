import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class reportYear extends JFrame implements ActionListener {

	DefaultTableModel model;
	JTable table;
	JPanel c;
	
	public reportYear() {		//making this cons because of object creation during main form load
		
	}
	
	public reportYear(String order) {		//making gui in this cons because need data table updated after table is loaded and deleted
		gui();
	}
	
	void gui() {

			setBounds(200, 80,1000, 700);
			setTitle("Database --Yearly-- Reports");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			c= new JPanel(null);
			this.add(c);
			
				
			JLabel lbYear= new JLabel("Enter Year");	lbYear.setBounds(150, 70, 100, 20);
			JLabel lb= new JLabel("[YYYY]");	lb.setBounds(250, 90, 100, 20);
			JTextField txYear= new JTextField();		txYear.setBounds(250, 70, 100, 20);
			JButton btnClear= new JButton("CLEAR");	btnClear.setBounds(150,130, 100, 30);
			JButton btnSubmit= new JButton("SUBMIT");btnSubmit.setBounds(250,130, 100, 30);
			
			c.add(lbYear); c.add(txYear);c.add(lb);
			c.add(btnClear);c.add(btnSubmit);
			setVisible(true);
			
			btnClear.addActionListener(new ActionListener() {		//innser class
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txYear.setText(null);
				}
			});
			
				btnSubmit.addActionListener(new ActionListener() {		//inner class
				
					@Override
					public void actionPerformed(ActionEvent e) {
					
				
					String dat=txYear.getText();
					Pattern pd=Pattern.compile("[0-9]{4}");		//for date
					Matcher md=pd.matcher(dat);
					
					if(md.matches()) {
						if(Integer.valueOf(dat)>(Calendar.getInstance().get(Calendar.YEAR))){
							JOptionPane.showMessageDialog(null, 
							          "Invalid Date!!", 
							          "Warning", 
							          JOptionPane.INFORMATION_MESSAGE);
						}
						else {
						String year=txYear.getText();
						maketable(year);
						table.setVisible(true);
						}
					}
					else
						{
						JOptionPane.showMessageDialog(null, 
				          "Fix the Year!!", 
				          "Check Input Details", 
				          JOptionPane.INFORMATION_MESSAGE);
						}
					
					
				}});
			
			
			
		}	//end of gui method
	
	void maketable(String year) {		//only make table no connection
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
		
				PreparedStatement pst=null;
				ResultSet rs= null;
				
				pst=con.prepareStatement("Select * from expense where date >? and date <?");
				pst.setString(1, year+"-01-01");
				pst.setString(2, year+"-12-31");
				rs=pst.executeQuery();
					//
			
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
			
			new reportYear("make new gui");
			//new reportYear();
		}
}
