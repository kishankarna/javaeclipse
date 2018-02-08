class testthread5 extends Thread{
	public void run() {
		
	}
	
}
public class thread5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testthread5 t1=new testthread5();
		t1.start();
		testthread5 t2=new testthread5();
		t2.start();
		
		System.out.println(t1.getName());	//getting thread name
		System.out.println(t2.getName());
		//System.out.println(new testthread5().getName());
		t1.setName("Karna thread");		//setting thread name
		System.out.println(t1.getId());	//getting thread ID
		System.out.println(t2.getId());
		System.out.println(t1.getName());
		System.out.println(Thread.currentThread().getName());		//getting main thread name
		Thread.currentThread().setName("This is customized karna main thread");//setting
		System.out.println(Thread.currentThread().getName());
		
		System.out.println(t1.isAlive());	//if not alive return false else true
		System.out.println(Thread.activeCount());
		
	}

}
