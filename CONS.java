
public class CONS {
	public static void main(String[] args) {
		
		tes obj=new tes();  ///constructer is executed when object is created
		tes obj2=new tes(5); ///constructer is executed when object is created
		
		//obj.toString();
		//obj2.toString();
	}
}

class tes{
	tes()
	{
		System.out.println("This is constructor");
	}
	tes(int a){
		
		System.out.println("This is second constructor"+a);
	}
	
}
