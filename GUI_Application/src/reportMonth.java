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
import javax.swing.table.DefaultTableModel;

class reportMonth extends JFrame implements ActionListener {
	DefaultTableModel model;
	JTable table;
	JPanel c;
	
	public reportMonth() {}
	public reportMonth(String order) {
		gui();
	}
	void gui() {
		
			setBounds(200, 80,1000, 700);
			setTitle("Database --Monthly-- Reports");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			c= new JPanel(null);
			this.add(c);
			
			String[] msg= {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
			JComboBox box= new JComboBox(msg);			box.setBounds(200, 70, 140, 20);
			
			JLabel lbMonth= new JLabel("Enter Month");	lbMonth.setBounds(100, 70, 100, 20);
			
			//JButton btnExit= new JButton("EXIT");	btnExit.setBounds(140,130, 100, 30);
			JButton btnSubmit= new JButton("SUBMIT");btnSubmit.setBounds(240,130, 100, 30);
			
			c.add(lbMonth); c.add(box);
			//c.add(btnExit);
			c.add(btnSubmit);
			setVisible(true);
			
			btnSubmit.addActionListener(new ActionListener() {		//inner class
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//String mon=box.getSelectedItem().toString();
					int month=box.getSelectedIndex()+1;
					maketable(month);
					
					table.setVisible(true);
					
				}
			});	
			
		}	//end of gui method
	
		void maketable(int month) {		
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
						
						pst=con.prepareStatement("Select * from expense where month(date)=?");
						//select * from expense where month(date)=1
						pst.setInt(1, month);
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
			
			new reportMonth("make new gui");
		
		}
}
