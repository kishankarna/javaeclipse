import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.*;

public class swing2 extends JFrame{
	
	swing2(){
		//this.setVisible(true);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c= this.getContentPane();
		c.setLayout(null);
		JLabel lbNam= new JLabel("Name");	lbNam.setBounds(100, 100, 50, 20);
		JLabel lbAdd= new JLabel("Address");	lbAdd.setBounds(100, 150, 100, 20);
		
		JTextField txName= new JTextField();		txName.setBounds(200, 100, 100, 20);	
		JTextField txadd= new JTextField();		txadd.setBounds(200, 150, 100, 20);
		
		JPasswordField pass= new JPasswordField(); pass.setBounds(200, 200, 100, 15);																			txadd.setForeground(Color.red);
		
		JButton bOk= new JButton("Ok");			bOk.setBounds(130, 250, 40, 15);	
		JButton bCan= new JButton("Cancel");		bCan.setBounds(190, 250,70, 15);
		
		
		c.add(lbNam);	c.add(txName);	
		c.add(lbAdd);	c.add(txadd);
		c.add(pass);
		c.add(bOk);	c.add(bCan);
			
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new swing2();
		
			
	}

}
