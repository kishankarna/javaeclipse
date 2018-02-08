import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class frame extends JFrame implements ActionListener{			//class for creating frame and action
	boolean status=false;				//instance variables
	JLabel lbHead;	JButton mbtn;
	JButton btn1;	JButton btn3;	JButton btn6;	JButton btn8;
	JButton btn2;	JButton btn4;	JButton btn5;	JButton btn7;	JButton btn9;
	
	
	frame(){						//constructor created
		Font f= new Font("Arial", Font.BOLD, 40);
		this.setTitle("Mind Game");
		//this.setSize(300, 300);
		this.setBounds(300,300, 300, 370);	//location and size together
		this.setResizable(false);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		Container cntn = this.getContentPane();	cntn.setLayout(null);
		
		mbtn= new JButton("RESET");	mbtn.setBounds(10 ,290, 280, 50);
		
		lbHead= new JLabel("Karna' TIC-TAC GAME");	lbHead.setBounds(90, 5, 300, 15);	
		lbHead.setBackground(Color.RED);
		lbHead.setForeground(Color.BLUE);
		btn1= new JButton("");			btn2= new JButton("");			btn3= new JButton("");
		btn1.setBounds(0, 20, 100, 90);	btn2.setBounds(100, 20, 100, 90);btn3.setBounds(200, 20, 100, 90);
		
		btn4= new JButton("");			btn5= new JButton("");			btn6= new JButton("");
		btn4.setBounds(0, 108, 100, 90);btn5.setBounds(100, 108, 100, 90);btn6.setBounds(200, 108, 100, 90);
		
		btn7= new JButton("");			btn8= new JButton("");			btn9= new JButton("");
		btn7.setBounds(0, 196, 100, 90);	btn8.setBounds(100, 196, 100, 90);btn9.setBounds(200, 196, 100, 90);
		
		
		this.add(lbHead);	this.add(btn1);	this.add(btn2);	this.add(btn3);	this.add(btn4);	this.add(mbtn);
		this.add(btn5);		this.add(btn6);	this.add(btn7);	this.add(btn8);	this.add(btn9);
		
		btn1.setFont(f);btn2.setFont(f);btn3.setFont(f);btn4.setFont(f);btn5.setFont(f);
		btn6.setFont(f);btn7.setFont(f);btn8.setFont(f);btn9.setFont(f);
		//action listener
		btn1.addActionListener(this);btn2.addActionListener(this);btn3.addActionListener(this);	mbtn.addActionListener(this);
		btn4.addActionListener(this);btn5.addActionListener(this);btn6.addActionListener(this);
		btn7.addActionListener(this);btn8.addActionListener(this);btn9.addActionListener(this);
		
		setVisible(true);
	}						//constructor ended here

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==mbtn) {enableBTN();}	//reseting buttons
		
		if(e.getSource()==btn1){				//setting X or O for the game
					if(status==false) {btn1.setText("X");status=true;btn1.setEnabled(false);btn1.requestFocus(true);}
					else if(status== true) {btn1.setText("O");status=false;btn1.setEnabled(false);btn1.requestFocus(true);}
							}
		else if(e.getSource()==btn2) {
					if(status==false) {btn2.setText("X");status=true;btn2.setEnabled(false);btn2.requestFocus(true);}
					else if(status== true) {btn2.setText("O");status=false;btn2.setEnabled(false);btn2.requestFocus(true);}
							}
		else if(e.getSource()==btn3) {
					if(status==false) {btn3.setText("X");status=true;btn3.setEnabled(false);btn3.requestFocus(true);}
					else if(status== true) {btn3.setText("O");status=false;btn3.setEnabled(false);btn3.requestFocus(true);}
							}
		else if(e.getSource()==btn4) {
					if(status==false) {btn4.setText("X");status=true;btn4.setEnabled(false);btn4.requestFocus(true);}
					else if(status== true) {btn4.setText("O");status=false;btn4.setEnabled(false);btn4.requestFocus(true);}
							}
		else if(e.getSource()==btn5) {
					if(status==false) {btn5.setText("X");status=true;btn5.setEnabled(false);btn5.requestFocus(true);}
					else if(status== true) {btn5.setText("O");status=false;btn5.setEnabled(false);btn5.requestFocus(true);}
							}
		else if(e.getSource()==btn6) {
					if(status==false) {btn6.setText("X");status=true;btn6.setEnabled(false);btn6.requestFocus(true);}
					else if(status== true) {btn6.setText("O");status=false;btn6.setEnabled(false);btn6.requestFocus(true);}
							}
		else if(e.getSource()==btn7) {
					if(status==false) {btn7.setText("X");status=true;btn7.setEnabled(false);btn7.requestFocus(true);}
					else if(status== true) {btn7.setText("O");status=false;btn7.setEnabled(false);btn7.requestFocus(true);}
							}
		else if(e.getSource()==btn8) {
					if(status==false) {btn8.setText("X");status=true;btn8.setEnabled(false);btn8.requestFocus(true);}
					else if(status== true) {btn8.setText("O");status=false;btn8.setEnabled(false);btn8.requestFocus(true);}
							}
		else if(e.getSource()==btn9) {
					if(status==false) {btn9.setText("X");status=true;btn9.setEnabled(false);btn9.requestFocus(true);}
					else if(status== true) {btn9.setText("O");status=false;btn9.setEnabled(false);btn9.requestFocus(true);}
							}
		
		
			checkGame();
		
		
		
	}//end of override-method
	
	void checkGame()  {
		//for x winner
		if((btn1.getActionCommand().contains("X")) && (btn2.getActionCommand().contains("X")) && (btn3.getActionCommand().contains("X")))
			{lbHead.setText("X-Player is a winner!!");disableBTN();}
		
		else if((btn4.getActionCommand().contains("X")) && (btn5.getActionCommand().contains("X")) && (btn6.getActionCommand().contains("X")))
			{lbHead.setText("X-Player is a winner!!");disableBTN();}
	
		else if((btn7.getActionCommand().contains("X")) && (btn8.getActionCommand().contains("X")) && (btn9.getActionCommand().contains("X")))
			{lbHead.setText("X-Player is a winner!!");disableBTN();}
	
		else if((btn1.getActionCommand().contains("X")) && (btn4.getActionCommand().contains("X")) && (btn7.getActionCommand().contains("X")))
			{lbHead.setText("X-Player is a winner!!");disableBTN();}
	
		else if((btn2.getActionCommand().contains("X")) && (btn5.getActionCommand().contains("X")) && (btn8.getActionCommand().contains("X")))
			{lbHead.setText("X-Player is a winner!!");disableBTN();}
	
		else if((btn3.getActionCommand().contains("X")) && (btn6.getActionCommand().contains("X")) && (btn9.getActionCommand().contains("X")))
			{lbHead.setText("X-Player is a winner!!");disableBTN();}
	
		else if((btn1.getActionCommand().contains("X")) && (btn5.getActionCommand().contains("X")) && (btn9.getActionCommand().contains("X")))
			{lbHead.setText("X-Player is a winner!!");disableBTN();}
	
		else if((btn3.getActionCommand().contains("X")) && (btn5.getActionCommand().contains("X")) && (btn7.getActionCommand().contains("X")))
			{lbHead.setText("X-Player is a winner!!");disableBTN();}
		
		//for O winner
		if((btn1.getActionCommand().contains("O")) && (btn2.getActionCommand().contains("O")) && (btn3.getActionCommand().contains("O")))
			{lbHead.setText("O-Player is a winner!!");disableBTN();}
	
		else if((btn4.getActionCommand().contains("O")) && (btn5.getActionCommand().contains("O")) && (btn6.getActionCommand().contains("O")))
			{lbHead.setText("O-Player is a winner!!");disableBTN();}

		else if((btn7.getActionCommand().contains("O")) && (btn8.getActionCommand().contains("O")) && (btn9.getActionCommand().contains("O")))
			{lbHead.setText("O-Player is a winner!!");disableBTN();}

		else if((btn1.getActionCommand().contains("O")) && (btn4.getActionCommand().contains("O")) && (btn7.getActionCommand().contains("O")))
			{lbHead.setText("O-Player is a winner!!");disableBTN();}

		else if((btn2.getActionCommand().contains("O")) && (btn5.getActionCommand().contains("O")) && (btn8.getActionCommand().contains("O")))
			{lbHead.setText("O-Player is a winner!!");disableBTN();}

		else if((btn3.getActionCommand().contains("O")) && (btn6.getActionCommand().contains("O")) && (btn9.getActionCommand().contains("O")))
			{lbHead.setText("O-Player is a winner!!");disableBTN();}

		else if((btn1.getActionCommand().contains("O")) && (btn5.getActionCommand().contains("O")) && (btn9.getActionCommand().contains("O")))
			{lbHead.setText("O-Player is a winner!!");disableBTN();}

		else if((btn3.getActionCommand().contains("O")) && (btn5.getActionCommand().contains("O")) && (btn7.getActionCommand().contains("O")))
			{lbHead.setText("O-Player is a winner!!");disableBTN();}
		
	}	//end of method
	
	void disableBTN() {	//disabling all buttons after win
		btn1.setEnabled(false);btn2.setEnabled(false);btn3.setEnabled(false);btn4.setEnabled(false);
		btn5.setEnabled(false);btn6.setEnabled(false);btn7.setEnabled(false);btn8.setEnabled(false);btn9.setEnabled(false);
	}
	
	void enableBTN() {	//enabling all buttons after reset
		btn1.setEnabled(true);btn2.setEnabled(true);btn3.setEnabled(true);btn4.setEnabled(true);
		btn5.setEnabled(true);btn6.setEnabled(true);btn7.setEnabled(true);btn8.setEnabled(true);btn9.setEnabled(true);
		status=false;
		btn1.setText("");	btn2.setText("");	btn3.setText("");	btn4.setText("");	btn5.setText("");
		btn6.setText("");	btn7.setText("");	btn8.setText("");	btn9.setText("");
		lbHead.setText("Karna' TIC-TAC GAME");
	}
	
}	//end of class


public class tictac {						//main class

	public static void main(String[] args) throws InterruptedException {
		new frame();							//calling constructor

	}

}											//main class ended
