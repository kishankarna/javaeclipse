
public class inheritance7 {

	public static void main(String[] args) {
		
		new child7();
	}
}

class parent7{
	static {
		System.out.println("This is parent static blocks");
	}
	{
		System.out.println("This is parent instance block");
	}
	parent7(){
		System.out.println("This is parent 0 arg constructor");
	}
}

class child7 extends parent7{
	static {
		System.out.println("This is child static blocks");
	}
	{
		System.out.println("This is child instance block");
	}
	child7(){
		System.out.println("This is child 0 arg constructor");
	}
	
}