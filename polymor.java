// 2 Types of polymosphism in JAVA: --one thing in many form--
// compile-time polymorphism or //static binding  or // early binding
	// by using method overloading concept

// runtime polymorphism    or   //dynamic binding or // late binding
	// by using method overriding concept

public class polymor {
	public static void main(String[] args) {
		new childpol().marry();
	}
}
class parentpol{   
	void marry() {	//overriden method
		System.out.println("Black girl");
	}
}

class childpol extends parentpol{  
	void marry() {	//overriding method
		System.out.println("Red girl");
	}
}