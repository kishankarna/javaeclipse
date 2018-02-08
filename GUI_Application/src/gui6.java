import java.awt.event.WindowListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class gui6 extends Frame implements ActionListener{
	//component declare in instance
	TextField tx;
	
	int fVal=0,sVal=0,res=0;
	String fres=null;	//final value
	String sign=null;	//catch operator
	
	Button b8; Button b9; Button bCLR;			Button bDIV;
	Button b4; Button b5; Button b6; Button b7;	Button bMUL;
	Button b0; Button b1; Button b2; Button b3;	Button bADD;
	Button bDot;	Button bENTER;
	//-----------------------------------//
	gui6(){	//start constructore started
		
		setVisible(true);
		setSize(350,200);
		setBackground(Color.lightGray);
		setTitle("Calculator  KARNA's PRODUCTION");
		setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		
		
		tx= new TextField(40);	//creating components
		b7 =new Button("7");	 b8= new Button("8");	b9= new Button("9"); 	bDIV= new Button("/");
		b4= new Button("4");	 b5= new Button("5");	b6= new Button("6");		bMUL= new Button("*"); 
		b1= new Button("1"); b2= new Button("2");	b3= new Button("3");		bADD= new Button("+"); 
		b0= new Button("0"); bDot= new Button(".");  bCLR= new Button("c");   bENTER= new Button("=");
		
		add(tx);					//adding components to Frame
		add(b7);	add(b8);add(b9);		add(bDIV);		
		add(b4);	add(b5);add(b6);		add(bMUL);
		add(b1);	add(b2);add(b3)	;	add(bADD);	
		add(b0);add(bDot);add(bCLR);this.add(bENTER);	//another way to add
		
		//adding listener
		b0.addActionListener(this);	b1.addActionListener(this);    b2.addActionListener(this);	
		b3.addActionListener(this);  b4.addActionListener(this);    b5.addActionListener(this);
		b6.addActionListener(this);  b7.addActionListener(this);    b8.addActionListener(this);
		b9.addActionListener(this);  bDot.addActionListener(this);  bCLR.addActionListener(this);
		bDIV.addActionListener(this); bMUL.addActionListener(this); bADD.addActionListener(this);
		bENTER.addActionListener(this);
		
		
	}//-------------------------------------end constructore ended
	
	
	public static void main(String[] args) {			///main method
		
		new gui6();
		
	}//---------------------------------------// End main method
	
	@Override
	public void actionPerformed(ActionEvent e) {		//action performer
		//System.out.println("Hello button");
	
		
		if 		(e.getSource()==b0){ tx.setText("0");}
		
		else if (e.getSource()==b1){ tx.setText("1");}
		else if (e.getSource()==b2){ tx.setText("2");}
		else if (e.getSource()==b3){ tx.setText("3");}
		else if (e.getSource()==b4){ tx.setText("4");}
		else if (e.getSource()==b5){ tx.setText("5");}
		else if (e.getSource()==b6){ tx.setText("6");}
		else if (e.getSource()==b7){ tx.setText("7");}
		else if (e.getSource()==b8){ tx.setText("8");}
		else if (e.getSource()==b9){ tx.setText("9");}
		else if(e.getActionCommand().contains("+")) {
									sign="+";
									fVal=Integer.parseInt(tx.getText());		//getting first val
									tx.setText("");}
									//System.out.println("plus");}
		else if(e.getActionCommand().contains("/")) {
									sign="/";
									fVal=Integer.parseInt(tx.getText());		//getting first val
									tx.setText("");}
									
									//System.out.println("Divide");}
		else if(e.getActionCommand().contains("*")) {
									sign="*";
									fVal=Integer.parseInt(tx.getText());		//getting first val
									tx.setText("");}
									//System.out.println("MULTIPLY");}
		else if(e.getActionCommand().contains("=")) {
									sVal=Integer.parseInt(tx.getText());	//gettin secon val
									tx.setText("");
						if(sign=="+") {
									res=fVal+sVal;
									fres=String.valueOf(res);
									tx.setText(fres); }
						else if(sign=="*") {
							res=fVal*sVal;
							fres=String.valueOf(res);
							tx.setText(fres); }
						else if(sign=="/") {
							res=fVal/sVal;
							fres=String.valueOf(res);
							tx.setText(fres); }
						
			}		//System.out.println("Execure");}
		else if(e.getActionCommand().contains(".")) {tx.setText(".");}
		else if(e.getActionCommand().contains("c")) {tx.setText("");		sign=null;}
		
		
	}//-----------action performer ended
}//----------------class ended

