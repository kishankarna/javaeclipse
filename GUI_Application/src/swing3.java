import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.*;

public class swing3 extends JFrame{
	
	swing3(){
		this.setSize(300,300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		
		Container cont= getContentPane();
		cont.setLayout(null);
		ImageIcon icon= new ImageIcon("/Users/karna/Desktop/kar.png");
		Font f= new Font("Times new roman", Font.BOLD,14);
		Cursor cur= new Cursor(Cursor.HAND_CURSOR);		//making cursor object
		
		JPasswordField pss= new JPasswordField();	pss.setBounds(100, 100, 100, 20);
		JButton btn= new JButton(icon);	btn.setBounds(100,200, icon.getIconWidth(), icon.getIconHeight());
		btn.setCursor(cur);				//setting cursor
		JButton btn2= new JButton("Click Me");	btn2.setBounds(100,240, 100, 30);
		btn2.setBackground(Color.YELLOW);
		btn2.setForeground(Color.black);
		pss.setFont(f);	pss.setBackground(Color.RED);
		
		cont.add(pss); cont.add(btn);	cont.add(btn2);
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new swing3();

	}

}
