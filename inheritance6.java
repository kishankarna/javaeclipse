
public class inheritance6 {
	public static void main(String[] args)
	{
		new child6();
		new child6();
		
	}
}

class parent6{
	{// instance block -- depends on object creation
		System.out.println("parent class instance block");
	}
}

class child6 extends parent6{
	{ // instance block-- depends on object creation
		System.out.println("Child class instance block");
	}
	
}