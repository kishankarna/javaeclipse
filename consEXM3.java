//constructore calling ---constructor can only call one constructor inside it at a time
public class consEXM3 {
	public static void main(String[] args) {
		//named approach
		testcons ob= new testcons();
		//testcons ob1= new testcons(3);
		//testcons ob2= new testcons(3,4);
		
		//name less approach
		new testcons(3,4);
	}

}

class testcons{
	
	public testcons() {
		this(2,5);  ///always this must be first statement in constructor
		//this(3); this will be wrong 
		System.out.println("This is 0-argument constructor");
		// this(2,5);  will not work because it will be second statement in constructor
	}
	public testcons(int a) {
		System.out.println("This is 1-argument constructor");
	}
	public testcons(int a, int b) {
		this(4);
		System.out.println("This is 2-argument constructor");
	}
	
}
