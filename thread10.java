//interrupt method-- it is only executed when sleep method is implemented
class testthread10 extends Thread{
	
	public void run() {
		for(int i=0;i<5;i++) {
			
			System.out.println(Thread.currentThread().getName());
			try{Thread.sleep(1000);}
			catch(InterruptedException e)
			{System.out.println("Interrupted here");}
		}
	}
	
}

public class thread10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testthread10 t= new testthread10();
		t.start();
		t.interrupt();
	}

}
