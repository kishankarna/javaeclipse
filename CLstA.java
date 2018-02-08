
//this class calls CLstB & CLstC class static blocks
public class CLstA {
	
	public static void main(String[] args) throws ClassNotFoundException  //need this exception when you call another classes
	{

		Class.forName("CLstB");  //calling CLstB class
		Class.forName("CLstC");  //calling CLstC class
		//Class.CLstA;
		
	}



static {
		System.out.println("This is satic block from main class");
		}
}
