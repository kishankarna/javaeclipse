import java.util.Scanner;
class thredVol extends Thread{
	
	volatile boolean counting=true;	//we put volatile modifier. so, this value is checked in
	int count=1;						// while(counting) every single time. b'coz 
									// sometime operating system wont check b coz it might
		public void run() {			//get cashed.
		
			while(counting) {
			
				System.out.println(count);
				count++;
				try{Thread.sleep(1000);}
				catch(InterruptedException e) {e.printStackTrace();	}
			}
		}
	
		public void stopCount() {
			counting=false;
		}
}
public class thread16 {
	
	public static void main(String[] args) {
		thredVol t= new thredVol();
		t.start();
		
		Scanner sn=new Scanner(System.in);
		sn.nextLine();	//hit enter key to stop thread
		t.stop();
		
	}
}
