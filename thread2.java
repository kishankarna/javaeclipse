class testthread2 extends Thread{
	
	public void run() {
		
		m1();
		m2();
	}

	private void m1() {
		// TODO Auto-generated method stub
		System.out.println("M1 method");
	}

	private void m2() {
		// TODO Auto-generated method stub
		System.out.println("M2 method");
	}

}
public class thread2 {
	public static void main(String[] args) {
	testthread2 th= new testthread2();
	th.start();
	
	}
}
