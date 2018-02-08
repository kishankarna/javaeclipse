
public class polymor3 {
	
	
	public static void main(String[] args) {
		/*
		 parentpol3 p= new parentpol3();		// valid
		 childpol3 c= new childpol3();		// valid
		 parentpol3 p1= new childpol3();		// valid
		 //childpol3 c1= new parentpol3();  //not valid
		*/
		parentpol3 p= new childpol3();
		p.m1();   		//compile-time :parent    run-time : child
		//p.m2();		//compile-time parent	 run-time : child  //thats why error b'coz
		//															it wont find parent m2()
		childpol3 c=(childpol3)p;  //type casting
		c.m2();
	}
}

class parentpol3{
	void m1() {
		System.out.println("This is parent m1 method");
	}
}

class childpol3 extends parentpol3{
	void m1() {
		System.out.println("This is child m1 method");
	}
	void m2() {
		System.out.println("This is child m2 method");
	}
	
}