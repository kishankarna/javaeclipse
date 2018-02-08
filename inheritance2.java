
public class inheritance2 {
	public static void main(String[] args) {
		
		new child().m2();
		
	}

}

class parent{
	void m1() {System.out.println("This is parent method");}
}

class child extends parent{
	void m1() {System.out.println("This is child method");}
	
	void m2() {
		this.m1();  //child class method calling
		super.m1();  //parent class method calling
	}
	
}


