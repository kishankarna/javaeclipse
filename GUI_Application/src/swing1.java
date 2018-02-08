//import java.awt.Color;
import java.awt.*;
import javax.swing.*;


public class swing1 extends JFrame{

	swing1(){
		this.setTitle("Karna JAVA");
		//this.setVisible(true);
		this.setBounds(300,300, 500, 500);	//location and size together
		//this.setSize(300, 300);
		//this.setLocation(500,300);		//from left to bottom
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= this.getContentPane();
		c.setLayout(null);	//by default it is flow that is why set to null
		Font f= new Font("Arial", Font.BOLD,12);
		Color col= new Color(200, 100, 150);	///creating your owrn color
		c.setBackground(col);
		ImageIcon img= new ImageIcon("/Users/karna/Desktop/kk.jpg");
		JLabel iconLabl= new JLabel("image",img,JLabel.LEFT);
		
		c.add(iconLabl);
		iconLabl.setBounds(100, 200, 100, 100);
		
		//this.setResizable(false);
		JLabel lbName= new JLabel("Name");		lbName.setBounds(50, 50, 100, 10);	
		JLabel lbAdd	= new JLabel("Address");		lbAdd.setBounds(50, 50, 100, 50);
		
		JTextField txName= new JTextField();		txName.setBounds(100, 50, 100, 15);	txName.setFont(f);
		JTextField txadd= new JTextField();		txadd.setBounds(100, 70, 100, 15);	txadd.setBackground(Color.yellow);
		JPasswordField pass= new JPasswordField(); pass.setBounds(200, 70, 100, 15);																			txadd.setForeground(Color.red);
		
		JButton bOk= new JButton("Ok");			bOk.setBounds(90, 100, 40, 15);		bOk.setFont(f);
		JButton bCan= new JButton("Cancel");		bCan.setBounds(140, 100,70, 15);		bCan.setFont(f);
		
		c.add(lbName);	c.add(txName);	c.add(bOk);	c.add(pass);
		c.add(lbAdd);	c.add(txadd);	c.add(bCan);
		
		
	this.setVisible(true);
	}
	

	public static void main(String[] args) {
	swing1 s=new swing1();
	

	}

}
