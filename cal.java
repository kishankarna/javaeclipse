import java.util.Scanner;
public class cal {
	public static void main(String args[]) {
		Scanner nn= new Scanner(System.in);
		
		double fnum, snum, ans;
		
		System.out.println("Provide the first number:  ");
		fnum= nn.nextDouble();
		
		System.out.println("Provide the second number:  ");
		snum= nn.nextDouble();
		
		ans=fnum*snum;
		System.out.println("The multiplication answer is: "+ ans);
		
		System.out.println(ans++);
		System.out.println(ans);
		
	}
}
