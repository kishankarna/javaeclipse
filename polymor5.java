
public class polymor5 {
	
	public static void main(String[] args) {
		
		childpol5 c= new childpol5();
		c.m1();
	}
}

class parentpol5{
	 
	 public void m1() {	System.out.println("This is parent m1 method");}
}

class childpol5 extends parentpol5{
	  public void m1() {	System.out.println("This is child m1 method");}
	
}