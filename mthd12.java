import java.util.Scanner;

public class mthd12 {
	public static void main(String[] args) {
		Scanner sn= new Scanner(System.in);
		System.out.println("provide numbers to calculate: ");
		int a=sn.nextInt();
		int b=sn.nextInt();
		int c=sn.nextInt();
		mthd12 ob= new mthd12();
		
		//int res=ob.add(a,b);
		//System.out.println("Addition is : "+res);
		
		int ress=ob.add(a, b, c);
		System.out.println("Addition is : "+ress);
	}
	
	int add(int a, int b) {
		System.out.println("This is addition method for 2 numbers: ");
		return a+b;
	}
	
	int add(int a, int b, int c) {
		System.out.println("This is addition method between 3 numbers : ");
		return a+b+c;
	}
	
	double add(double a, double b, double c) {
		System.out.println("This is addition between 3 decimal numbers: ");
		return a+b+c;
		
	}
	


}
