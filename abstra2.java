// abstraction example to complete method implementation
public class abstra2 {
	public static void main(String[] args) {
		exam3 ob= new exam3();
		ob.m1();
		ob.m2();
		ob.m3();
	}
}
abstract class exam{
	abstract void m1();
	abstract void m2();
	abstract void m3();
	
}

abstract class exam1 extends exam{ //this has still m2 and m3 method to implement
	
	void m1() {	System.out.println("This is m1 method");}  
	//developer only knows m1 method to implement
}

abstract class exam2 extends exam1{ // this has still m3 method to implement
	
	void m2() {	System.out.println("This is m2 method");}
	//developer only knows m2 method to implement
	
}

class exam3 extends exam2{  //we dont need abstract keyword for this class b'coz all methods are done
	void m3() {	System.out.println("This is m3 method");}
	//developer only knows m3 method to implement and also finally all methods are implemented
}