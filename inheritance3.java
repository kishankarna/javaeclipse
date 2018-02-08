
 public class inheritance3 {
public static void main(String[] args) {
		new child1();
		
	}

}
class parent1{
	parent1(){
		System.out.println("This is o-args parent class constructor!!");
	}
	
}

class child1 extends parent1{
	child1(){
		this(1);
		System.out.println("This is 0-args child class constructor!!");
	}
	
	child1(int a){
		super();
		System.out.println("This is 1-args child class constructor!!");
	}
	
}

