//this program covers about local,instance, static variables
public class VAREXMP {
	// instance variable
	int a=10;
	int b=20;
	// static variable
	static int x=100;
	static int y=200;
	
	// static method
	public static void main(String[] args) {
		//calling local variable
		int a=500;
		System.out.println(a);
		
		//calling static varibale
		System.out.println(VAREXMP.x);
		System.out.println(VAREXMP.y);
		
		//calling instance variable
		VAREXMP ob= new VAREXMP();
		System.out.println(ob.a);
		System.out.println(ob.b);
		m2();    ///calling static method no need object reference b'coz same area field
		ob.m1(); ///calling instance method need object reference b'coz differene area field
	}
	//instance method
	void m1() {
		System.out.println("This is instance method with instance variable :"+a);
		
	}
	//static method
	static void m2() {
		System.out.println("This is static method with static variable :"+VAREXMP.x);
		
	}
}
