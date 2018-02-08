
public class thread13 {
	
	public static void main(String[] args) 
	{	
		Runnable ob= new Runnable() 
		{						//inner class
			public void run() {
				for(int i=0;i<4;i++) {	System.out.println("thread from inner class");}
			}
		};	
		Thread t= new Thread(ob);
		t.start();
		
	}
}
