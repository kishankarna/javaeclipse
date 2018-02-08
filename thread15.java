class counter{				//bus counter
	
	 synchronized static void greet(String m) {
	 //static void greet(String m) {  by default non-synchronized
		for(int i=0;i<4;i++) {
			System.out.println("Good morning "+ m);
			try{Thread.sleep(1000);}
			catch(InterruptedException e) {e.printStackTrace();	}
		}
	}
}

class cust1thread extends Thread{	//1st customer class
	public void run()	{	counter.greet("Karna");	}
}
class cust2thread extends Thread{	//2nd customer class
	public void run()	{	counter.greet("Nanu");}
}
class cust3thread extends Thread{	//3rd customer class
	public void run()	{	counter.greet("Nikson");}
}
public class thread15 {

	public static void main(String[] args) {
		new cust1thread().start();	//calling thread nameless approach
		new cust2thread().start();
		new cust3thread().start();

	}

}
