//both approach for threading

class firstTh extends Thread{
	public void run() 	{
		for(int i=0;i<4;i++) {	System.out.println("First approach thread");}
	}
}

class secondTh implements Runnable{
	public void run()	{	
		for(int i=0;i<4;i++) {	System.out.println("Second approach thread");}
	}
}

public class thread14 {

	public static void main(String[] args) {
		
		//nameless approach for both threads
		new firstTh().start();
		new Thread(new secondTh()).start();

	}

}
