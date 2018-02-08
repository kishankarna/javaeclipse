
public class inheritance4 {
	public static void main(String[] args) {
		
		new child2();
	}
}

class parent2{
	
	parent2(){
		
		System.out.println("This is parent class constructor");
	}
}

class child2 extends parent2{
	
	child2(){
		//super();   // by default java will call super() of 0 arguments only
		System.out.println("This is child class constructor");
		}
}