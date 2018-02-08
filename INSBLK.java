
public class INSBLK {
	public static void main(String args[]) {
		new TestT(); //instance block is called before this constructor
		new TestT(2); //instance block is called again before this constructor
		
	}
	
}

class TestT
	{
		
		TestT()//constructor
		{
			
			System.out.println("This is 0-args constructor");
		}
		TestT(int a) //constructor with parameters
		{
			System.out.println("This is 1-args constructor");
		}
		
		{//instance block
			System.out.println("This is instance block");
			
		}
		
	
	}
