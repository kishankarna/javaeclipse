//simple gui in java
import javax.swing.JOptionPane;
public class gui1 {
	
	public static void main(String[] agrs) {
		
		String fn = JOptionPane.showInputDialog("Input first number :");
		String sn = JOptionPane.showInputDialog("Enter second number:");
		
		int num1=Integer.parseInt(fn);
		int num2=Integer.parseInt(sn);
		
		int sum=num1+num2;
		JOptionPane.showMessageDialog(null,"The answer is : "+sum ,"Title",JOptionPane.PLAIN_MESSAGE);
	}
}
