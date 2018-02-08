//shows database into the jtable
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class swing5 extends JFrame{
	
	swing5(){
		createwindow();
		
	}
	
	
	void createwindow() {
		
		this.setTitle("Karna swing table");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultTableModel model= new DefaultTableModel();
		JTable table = new JTable(model);
		JPanel pan= new JPanel();
		add(pan);
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("Phone");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k");  
			
			System.out.println("Connected!! to synology database");
			Statement stmt=con.createStatement();  
			
			ResultSet rs=stmt.executeQuery("select * from form order by name");  
			while(rs.next())  {
				
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
			}
				table.setModel(model);
				table.setPreferredScrollableViewportSize(new Dimension(400, 100));
				table.setFillsViewportHeight(true);
				JScrollPane span = new JScrollPane(table);
				pan.add(span);
				
			con.close();  
			
			}
		catch(Exception e) {e.printStackTrace();}
		
	}
	public static void main(String[] args) {
		swing5 win= new swing5();
		win.setVisible(true);
		
	}
	


}
