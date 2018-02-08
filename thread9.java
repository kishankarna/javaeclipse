//join thread
class testthread9 extends Thread{
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName());
			try{Thread.sleep(1000);}
			catch(InterruptedException e) {e.printStackTrace();}
		}
		
	}
}

public class thread9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testthread9   t1= new testthread9();
		testthread9 t2= new testthread9();
		
		t1.start(); t2.start();
		try{t1.join(2000);} //waits for 2 second //if empty waits untilll completion
		catch(InterruptedException e) {e.printStackTrace();}
		
		for(int i=0;i<5;i++) {
			System.out.println("main thread");
			try{Thread.sleep(1000);}
			catch(InterruptedException e) {e.printStackTrace();}
		}

	}

}
