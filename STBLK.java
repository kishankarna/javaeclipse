
//this is static blocks example
public class STBLK {

	public static void main(String args[]) {
		new cust(); //name less approach for object creation
		
		System.out.println("Hello there this is first java program");
	}
}


class cust{
	
	
	public cust() {  //constructor
		this(10); //this keyword is used to call constructor with 1- argument
		System.out.println("This is 0-args cosntructor");
	} 
	
	public cust(int a) { //constructor with 1 argument
		System.out.println("This is 1-args constructor");
		
	}
	
	static { ///this is static block and is excetuded when .class file is runned, excuted before main(String[] args)
		
		System.out.println("This is static block"); 
	}
	
	{ // this is instance block and is executed at object creation time and before constructor
		
		System.out.println("This is instance block");
	}
	static {
		System.out.println("This is second static block");
	}
	
	
}
