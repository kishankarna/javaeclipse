// implementing actionlistener and window listener in regular class by implementing interface
import java.awt.*;
import java.awt.event.*;
/*	normal way				//this class have to implements all method with
 * 							//logics or without logics from interface*/
class gutestt implements WindowListener{
	public void windowOpened(WindowEvent arg) {}
	public void windowClosing(WindowEvent arg) {System.exit(0);}
	public void windowClosed(WindowEvent arg)	{}
	public void windowIconified(WindowEvent arg)	{}
	public void windowDeiconified(WindowEvent arg)	{}
	public void windowActivated(WindowEvent arg)	{System.out.println("Activated");}
	public void windowDeactivated(WindowEvent arg)	{}
	
}

class bu implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Button pressed");
	}
	
	
}


public class gui2 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f= new Frame();
		f.setVisible(true);
		f.setSize(250, 200);	//length* height
		f.addWindowListener( new gutestt());
		f.setLayout(new FlowLayout());
		
		Checkbox ch1= new Checkbox("Bachelor",true);
		Checkbox ch2= new Checkbox("Master",false);
		
		
		CheckboxGroup cg= new CheckboxGroup();
			Checkbox cr1 = new Checkbox("Male",cg,false);
			Checkbox cr2 = new Checkbox("Female",cg,true);
			
		
		Label l1= new Label("User Name");
		Label l2= new Label("Password");
		
		TextField t1= new TextField(20);
		TextField t2= new TextField(20);
		t2.setEchoChar('*');
		Button b= new Button("Click");
		b.addActionListener(new bu());
		
		
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(ch1);
		f.add(ch2);
		f.add(cr1);
		f.add(cr2);
		f.add(b);
		
		
	}

}
