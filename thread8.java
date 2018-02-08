//daemon thread
class testthread8 extends Thread{
	
	public void run() {
		
		for(int i=1;i<10;i++) {
			
			System.out.println("Daemon thread!!");
			try{Thread.sleep(1000); }
			catch(InterruptedException e) {e.printStackTrace();}
		}
	}
	
}

public class thread8{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testthread8 t= new testthread8();
		t.setDaemon(true);
		t.start();
		
		for(int i=1;i<3;i++) {
			
			System.out.println("main thread!!");
			try{Thread.sleep(1000); }
			catch(InterruptedException e) {e.printStackTrace();}
		}
	}

}
