// example for abstraction class
public class abstra1 {
	public static void main(String[] args) {
		childabs1 ob1 = new childabs1();
		ob1.m1();
		ob1.m2();
		ob1.m3();
		
		parentabs1 ob= new childabs1();
		ob.m1();
		ob.m2();
		ob.m3();
		
	}
}
abstract class parentabs1{
	abstract void m1();
	abstract void m2();
	void m3() {	System.out.println("This is m3 method of parent class"); }
	
}

class childabs1 extends parentabs1{
	
	void m1()	{System.out.println("This is m1 method from child class");}
	void m2()	{System.out.println("This is m2 method from child class");}
	
}