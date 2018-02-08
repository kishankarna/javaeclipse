import javax.swing.*;
import javax.swing.JTable;
import java.awt.*;
public class swing4 extends JFrame{
	
	JTable tb;
	swing4(){
		//setLayout(new FlowLayout());
		setTitle("Karna's Table");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pan= new JPanel();
		this.add(pan);
		
		
		Object[] colname= {"Name","Address","Phone"};
		
		Object[][]data= {{"Karna","faribanks","23423423"},
						{"Karna","faribanks","23423423"},
						{"Karna","faribanks","23423423"},
						{"Karna","faribanks","23423423"},
						{"Karna","faribanks","23423423"},
						{"Karna","faribanks","23423423"},
						{"Karna","faribanks","23423423"},
						{"Karna","faribanks","23423423"},
						{"Nanu","faribanks","23423423"},
						{"Nikson","faribanks","23423423"}};
		tb= new JTable(data,colname);
		
		
		tb.setPreferredScrollableViewportSize(new Dimension(400, 100));
		
		tb.setFillsViewportHeight(true);
		JScrollPane scroll= new JScrollPane(tb);
		
		//c.add(scroll);
		pan.add(scroll);
		
		//c.setVisible(true);
	
		
	}
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
		swing4 fr=new swing4();
		fr.setVisible(true);
		

	}

}
