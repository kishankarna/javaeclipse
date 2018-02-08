//simple GUI for the java
import java.awt.*;

public class gui1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f= new Frame();
		f.setVisible(true);
		f.setSize(250, 200);	//length* height
		
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
