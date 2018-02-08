import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class calgui {

	//public int a,b,sum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Frame f= new Frame();
	f.setVisible(true);
	f.setSize(200,150);
	f.setLayout(new FlowLayout());
	f.addWindowListener(new WindowAdapter() {		//inner class
		@Override
		public void windowClosing(WindowEvent a) {
			System.exit(0);
		}
	});
	
	
	Label l1= new Label("Enter Value 1: ");
	Label l2 =new Label("Enter Value 1: ");
	Label lRes= new Label("Result :");
	
	TextField t1= new TextField(10);
	TextField t2= new TextField(10);
	TextField tRes= new TextField(10);
	
	Button b1= new Button("Add");
	b1.addActionListener(new ActionListener() {		//inner class

		@Override
		public void actionPerformed(ActionEvent e) {
			int a,b,sum;
			//a=Integer.parseInt(t1.getText());
			a=Integer.valueOf(t1.getText());		//converting to int
			b=Integer.parseInt(t2.getText());
			sum=a+b;
			tRes.setText(Integer.toString(sum));		//converting to string
			
			
			//System.out.println("Hello addition button");
		}
	});
	
	f.add(l1);	f.add(t1);
	f.add(l2);	f.add(t2);
	f.add(lRes);	f.add(tRes);
	f.add(b1);
	
	
	}

}
