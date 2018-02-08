import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class dataEngine extends javax.swing.JFrame implements ActionListener {
	public dataEngine() {}
	public dataEngine(String order) {	gui();	}
	
	void gui() {
		
		setTitle("Datae --- Engine");
		this.setBounds(200, 80,800, 430);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBackground(Color.BLUE);
		this.setVisible(true);
		
		
		
		JFileChooser file= new JFileChooser();
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new dataEngine("This is new data engine gui");
		
	}
		
}
