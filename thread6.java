class testthread6 extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
	}
	
}
public class thread6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testthread6 t1= new testthread6();
		testthread6 t2= new testthread6();
		//priority is from 1 to 10
		t1.setPriority(10);	//or   use constant from Thread class by t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(1);	//or   use constant from Thread class by t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
	}

}
