import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class salary extends JFrame implements ActionListener {
	 Connection con=null;
	 Statement st=null;
	 ResultSet rs= null;
	 JTextField txAmount; 
	
	 public salary() {}
	 public salary(String order) {
		 gui();
	 }
	 void gui() {
		
		setBounds(200, 80,1000, 500);
		setTitle("Salary Entry Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Container c= getContentPane();
		c.setLayout(null);
		
		JLabel lbAmount= new JLabel("Amount");		lbAmount.setBounds(100, 130, 100, 20);
		JLabel lbDate= new JLabel("Date");			lbDate.setBounds(100, 160, 100, 20);
		JLabel lbRemark= new JLabel("Salary Type");	lbRemark.setBounds(100, 190, 100, 20);
		
		txAmount= new JTextField();					txAmount.setBounds(200, 130, 150, 20);
		JTextField txDate= new JTextField();			txDate.setBounds(200, 160, 100, 20);
		
		JLabel lbSamp= new JLabel("[YYYY-MM-DD]");	lbSamp.setBounds(300, 160, 100, 20);
		
		//JTextField txSa= new JTextField();		txRemark.setBounds(200, 190, 150, 20);
		String[] msg= {"SELECT","salary","bonus","other"};
		JComboBox box= new JComboBox(msg);			box.setBounds(200, 190, 150, 20);
		JButton btnClear= new JButton("CLEAR");		btnClear.setBounds(150,230, 100, 30);
		JButton btnSubmit= new JButton("SUBMIT");	btnSubmit.setBounds(250,230, 100, 30);
	
		c.add(lbSamp);
		c.add(lbAmount);c.add(txAmount);
		c.add(lbDate);c.add(txDate);
		
		c.add(lbRemark);c.add(box);
		c.add(btnClear);c.add(btnSubmit);
		setVisible(true);
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 txAmount.setText(null);txDate.setText(null);box.setSelectedIndex(0);
				
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if( (txAmount.getText().isEmpty()) || (txDate.getText().isEmpty()) || (box.getSelectedIndex()==0))
					{	JOptionPane.showMessageDialog(null, 
                        "Provide Salary Details", 
                        "Warning!!!", 
                        JOptionPane.INFORMATION_MESSAGE);
					}
					
				else
				{
					try {
						String amt= txAmount.getText();
						String dat=txDate.getText();
						Pattern p= Pattern.compile("[0-9]*(\\.[0-9]+)?");				// checking patter for numbers
						Pattern pd=Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");		//for date
						
						Matcher m=p.matcher(amt);
						Matcher md=pd.matcher(dat);
						
						if(m.matches()	&& md.matches()) {
							
							if(LocalDate.parse(txDate.getText()).isAfter(LocalDate.now())) {
								JOptionPane.showMessageDialog(null, 
					                    "Invalid Date", 
					                    "Warning!!!", 
					                    JOptionPane.INFORMATION_MESSAGE);
								
							}
							else {
							double amount=Double.parseDouble(txAmount.getText());
							String date=txDate.getText();
							String salType=box.getSelectedItem().toString();
							enterData(amount,date,salType);
							txAmount.setText(null);txDate.setText(null);box.setSelectedIndex(0);
							//System.out.println("good amount");
							}
						}
						else {	
							JOptionPane.showMessageDialog(null, 
				                    "Something went wrong!!", 
				                    "Check Input Details", 
				                    JOptionPane.INFORMATION_MESSAGE);
							//System.out.println("bad amount");
							}
						
						
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				
				
				}		//end of if statement
				
			}});	//end of inner class for action and method
		
		
		
	 	}	//end of gui method
	 
		void enterData(double amount,String date,String salType) throws SQLException{
			try {

				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k"); 
				st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				//rs=st.executeQuery("Select expenseID,categoryID,amount,date,remark from expense");
				rs=st.executeQuery("Select * from salaryTB");
			
				rs.beforeFirst();
				rs.moveToInsertRow();	//to insert table should have primary key???
				//rs.updateInt(1, eID);	//it is automatic increment in database
				rs.updateDouble(2, amount);
				rs.updateString(3, date);
				rs.updateString(4, salType);
				rs.insertRow();
				
				JOptionPane.showMessageDialog(null, 
                    "Salary Inserted", 
                    "Congratulation!! Have Fun!!!", 
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
		
		new salary("make new gui");
		
	}
}
