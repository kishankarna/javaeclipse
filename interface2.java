//multiple inheritance in interface

interface IT1{
	void m1();
}

interface IT2{
	void m2();
}

public class interface2 implements IT1,IT2 {
	public static void main(String[] args) {
		
		interface2 ob= new interface2();
		
		ob.m1();
		ob.m2();
	}
	
	public void m1() {
			System.out.println("This is m1 method");
	}
	public void m2() {
		System.out.println("This is m2 method");
	}
}
