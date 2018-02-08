//runnable thread approach
class myrunnable implements Runnable{
	
	public void run() {
		for(int i=0;i<6;i++)
		{
			System.out.println("user thread");
		}
	}
}
public class thread11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myrunnable t= new myrunnable();
		Thread th= new Thread(t);	//taking help from Thread class to run thread
		th.start();
			for(int i=0;i<6;i++)
			{
				System.out.println("main thread");
			}
		
	}

}
