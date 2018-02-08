
class testthread extends Thread{
	
	public void run() {
		
		for(int i=1;i<=4;i++)
			System.out.println("User thread");
	}

}


public class thread1 {
	public static void main(String[] args) {	//main thread
		
		testthread th= new testthread();	//user thread
		th.start();
		//th.start(); you can not stat it gives error
		//th.run();	//basic method calling///thread not created
		for(int i=1;i<=4;i++)	//logic of main thread
			System.out.println("main thread");
		
	}
}
