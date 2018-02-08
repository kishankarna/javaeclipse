//hook thread
class testthread7 extends Thread{
	
	
	public void run() {
	System.out.println("This is hook thread!!");	
	}
}
public class thread7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	testthread7 t= new testthread7();
	Runtime r= Runtime.getRuntime();	///making hook thread
	r.addShutdownHook(t);			//
		
		for(int i=1;i<10;i++) {
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {e.getStackTrace();}	
			System.out.println("Main thread");
			
			if(i==5) {System.exit(0);}
		}
		
		
		
	}

}
