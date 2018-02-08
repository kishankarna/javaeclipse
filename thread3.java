class testthread3 extends Thread{
	public void run() {
			System.out.println("This is thread karna");
	}
	
	
}
public class thread3 {
	public static void main(String[] args) {
		testthread3 th1 = new testthread3();
		th1.start();
		
		testthread3 th2= new testthread3();
		th2.start();
		
		testthread3 th3= new testthread3();
		th3.start();
		
		new testthread3().start();	//name less style
		new testthread3().start();
	}
}
