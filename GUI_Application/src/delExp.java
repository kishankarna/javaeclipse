import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.net.protenait.sql.Dbutils;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
class delExp extends JFrame implements ActionListener {
	DefaultTableModel model;
	JTable table;
	JPanel c;

	public delExp() {			//dont make gui in this constructor, becoz this is default object created when main form componen made
		
	}
	public delExp(int k){		//make gui in this constructor bcoz show table can get updated in real time when done in deafault cons
		gui();
	}
	
	 void gui() {
		
		setBounds(200, 80,1000, 700);
		setTitle("Expense Delete Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		c= new JPanel(null);
		this.add(c);
		JLabel lbRemark= new JLabel("Input Expense-ID");	lbRemark.setBounds(300, 100, 200, 20);
		JTextField txExID= new JTextField();				txExID.setBounds(490, 100, 100, 20);
		JButton btnDelete= new JButton("DELETE");		btnDelete.setBounds(490,140, 100, 30);
		//JButton btnDisplay= new JButton("DISPLAY TABLE");btnDisplay.setBounds(450,140, 150, 30);
		
		c.add(lbRemark);c.add(txExID);
		c.add(btnDelete);//c.add(btnDisplay);
		maketable();
		setVisible(true);
		
			btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String data= txExID.getText();
				Pattern p= Pattern.compile("[0-9]+");
				Matcher m=p.matcher(data);
				if(m.matches()) 
				
				{	
					try {Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection(  
							"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k");  
						PreparedStatement pst=null;
						int id=Integer.parseInt(data);
						pst=con.prepareStatement("delete from expense where expenseid=?");
						pst.setInt(1,id);
						int rs=pst.executeUpdate();
						
					
							if(rs==1) {
							txExID.setText(null);
							JOptionPane.showMessageDialog(null, 
			                    "Purchase data Deleted", 
			                    "Successfull", 
			                    JOptionPane.INFORMATION_MESSAGE);
							}
							else
							{	
							JOptionPane.showMessageDialog(null, 
			                    "error", 
			                    "UnSuccessfull", 
			                    JOptionPane.INFORMATION_MESSAGE);
								txExID.setText(null);
							}
							
							updat_table();
							
							//close after operation
							pst.close();
							con.close();
							
					
						}
					catch(Exception ee){System.out.println(ee.getMessage());}
				}		
				else
				{	
					JOptionPane.showMessageDialog(null, 
		             "Enter Expense ID from table", 
		             "WARNING!!", 
		             JOptionPane.INFORMATION_MESSAGE);
					txExID.setText(null);
					updat_table();
				}
				}//method
			});//listener class
		
		
		
	}//gui method
	 
	 void maketable() {			//this is done using regular sql jar file
		 
			model= new DefaultTableModel();
			table = new JTable(model);
			
			
			model.addColumn("Expense ID");
			//model.addColumn("Category ID");
			model.addColumn("Amount");
			model.addColumn("Date");
			model.addColumn("Category");
			model.addColumn("Remarks");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(  
							"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k");  
					PreparedStatement pst=null;
					ResultSet rs= null;
					
					pst=con.prepareStatement("Select expense.expenseID,expense.amount,expense.date,category.name,expense.remark from expense,category "
							+ "where (category.categoryID=expense.categoryID)");
					//pst=con.prepareStatement("Select * from expense");
					rs=pst.executeQuery();
				
					while(rs.next())  {
				
						model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
					}
					table.setModel(model);
					table.setPreferredScrollableViewportSize(new Dimension(800, 400));
					table.setFillsViewportHeight(true);
					JScrollPane scpan = new JScrollPane(table);
					this.add(scpan,BorderLayout.NORTH);
					//this.revalidate();		//refresh the frame
					
					rs.close();
					pst.close();
					con.close();  
				}
				catch(Exception e) {e.printStackTrace();}
				
				}
	 
	 	void updat_table(){		//this update is done using rs2xml.jar file
		 
		 try {
			
			 Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(  
						"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k"); 
			//pst=con.prepareStatement("Select expense.expenseID,expense.amount,expense.date,category.name,expense.remark from expense,category "
					//+ "where (category.categoryID=expense.categoryID)");
			 String sql="Select expense.expenseID,expense.amount,expense.date,category.name,expense.remark from expense,category"
			 		+" where (category.categoryID=expense.categoryID)";
			PreparedStatement  pst = conn.prepareStatement(sql);
			 ResultSet rr=pst.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rr));		//using from rs2xml.jar file
			 //model.fireTableStructureChanged();
			 
			 rr.close();
			 pst.close();
			 conn.close();
		 	}
		 	catch(Exception ek){JOptionPane.showMessageDialog(null, ek);}
	 	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		new delExp(1);
	
		
		
	}
}
