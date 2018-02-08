//nested interface
interface IT11{

	interface IT12{
			void m1();
	}
	
}

public class interface3 implements IT11.IT12 {
	public void m1() {	System.out.println("This is nested interface method");}

	public static void main(String[] args) {
		
		interface3 ob= new interface3();
		ob.m1();
	}
}
