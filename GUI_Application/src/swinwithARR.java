import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class empswin{
	
	String name;
	String Address;
	String Phone;
		empswin(String name,String address,String phone){
			this.name=name;
			this.Address=address;
			this.Phone=phone;
			
		}
}
public class swinwithARR extends JFrame{
	empswin emp;
	swinwithARR(){
		
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pan= new JPanel(null);
		this.add(pan);
		DefaultTableModel model= new DefaultTableModel();
		JTable table= new JTable(model);
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("Phone");
		
		ArrayList<empswin> arr= new ArrayList<empswin>();
		arr.add(new empswin("Karna", "Butwal", "232323232"));
	
		for(empswin kk :arr)
			model.addRow(new Object[] {kk.name,kk.Address,kk.Phone});
		
		table.setModel(model);
		table.setPreferredScrollableViewportSize(new Dimension(400, 100));
		table.setFillsViewportHeight(true);
		JScrollPane span = new JScrollPane(table);
		this.add(span,BorderLayout.NORTH);
		
		
		///new
		JLabel lbYear= new JLabel("Enter Year");	lbYear.setBounds(100, 70, 100, 20);
		JLabel lb= new JLabel("[YYYY-MM-DD]");	lb.setBounds(200, 90, 280, 20);
		JTextField txYear= new JTextField();		txYear.setBounds(200, 70, 100, 20);
		JButton btnClear= new JButton("CLEAR");	btnClear.setBounds(100,130, 100, 30);
		JButton btnSubmit= new JButton("SUBMIT");btnSubmit.setBounds(200,130, 100, 30);
		
		pan.add(lbYear); pan.add(txYear);pan.add(lb);
		pan.add(btnClear);pan.add(btnSubmit);
	}
	
	public static void main(String[] args) {
	new swinwithARR().setVisible(true);	
	}

}
