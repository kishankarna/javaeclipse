interface k{
	void m1();
	void m2();
	
}
abstract class interf implements k{
	public void m1() {	System.out.println("This is m1 method");}
	
}

public class interface1 extends interf {
	public void m2() {	System.out.println("This is m2 method");}

	public static void main(String[] args) {
		
		interface1 ob= new interface1();
		
		ob.m1();
		ob.m2();
	}
}
