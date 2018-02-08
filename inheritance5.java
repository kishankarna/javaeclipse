
public class inheritance5 {
	public static void main(String[] args) {
		
		new child3();
		new child3(1);
	}
}

class parent3{
	
	parent3(){
		
		System.out.println("This is parent class o arg constructor");
	}
}

class child3 extends parent3{
	
	child3(){
		//super();   // by default java will call super() of 0 arguments constructor only
		System.out.println("This is child class 0 arg constructor");
		}
	child3(int a){
		//super();  //by default java will call super () of 0 arguments constructor only
		System.out.println("This is child class 1 arg constructor");
	}
}