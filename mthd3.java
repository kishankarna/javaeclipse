//method vs returning primitive data types
public class mthd3 {
	int m1() {
		System.out.println("This is m1 method");
		return 10;
	}
	
	float m2() {
		System.out.println("This is m2 method");
		return 10.5f;
	}
	
	static char m3() {
		System.out.println("This is m3 method");
		return 'a';
	}
	
	public static void main(String[] args) {
		
		mthd3 ob= new mthd3();
		
		int x=ob.m1();
		System.out.println("The value of m1 method is :"+x);
		
		float y= ob.m2();
		System.out.println("The value of m2 method is :"+y);
		
		char z=mthd3.m3();
		System.out.println("The value of m3 method is :"+z);
	}
}
