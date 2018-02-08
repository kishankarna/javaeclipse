// In java with static method overriding is not allowed
// this is also known as method hiding concept
public class polymor4 {
	public static void main(String[] args) {
		
		parentpoly4 p= new childpoly4();
		p.m1();
		
		
	}
}

class parentpoly4{
	
	static void m1() {	System.out.println("This is parent m1 method");}
}

class childpoly4 extends parentpoly4{
	static void m1() { System.out.println("This is child m1 method"); }
	static void m2() {	System.out.println("This is child m2 method");  }
	
}