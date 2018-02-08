//this program includes all 5 elements of java class
public class CLSALL {
	
	int a=10;	//instance variable
	static int b=20; //static variable
	
	void m1(int a) { //instance method
		System.out.println("This is instance method");
	}
	static void m2(String str) { //static method
		System.out.println("This is static method");
	}
	CLSALL(){			//constructor with o-args
		System.out.println("0-args constructor");
	}
	CLSALL(int a){		//cosntructor with 1-args
		System.out.println("1-args constructor");
	}
	{					//instance block
		System.out.println("THis is instance blocks");
	}
	static { System.out.println("This is static block");		//static block
	}
	
public static void main(String args[]) {
	CLSALL ob= new CLSALL();   //ins,cons
	CLSALL ob2= new CLSALL(1); //ins, cons
	ob.m1(12);
	CLSALL.m2("Karna");
	
	}
}

