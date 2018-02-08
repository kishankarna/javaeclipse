import javax.swing.JOptionPane;

public class gui2 {
	static int num1;
	static int num2;
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		
		int sum=gui2.num1+gui2.num2;
		JOptionPane.showMessageDialog(null,"The answer is : "+sum ,"Title",JOptionPane.PLAIN_MESSAGE);	
	
	
	
	}
	

	
static {
		
		String fn = JOptionPane.showInputDialog("Input first number :");
		String sn = JOptionPane.showInputDialog("Enter second number:");
		
		num1=Integer.parseInt(fn);
		num2=Integer.parseInt(sn);
	}
	
}
