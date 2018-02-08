//inner class approach for thread

public class thread12 {

	public static void main(String[] args) {
			
		new Thread()				//name less approach for object creation
		{						//inner anonymous class
			public void run() {
				for(int i=0;i<4;i++) {	System.out.println("thread from 1-inner class");}
			}
			
		}.start();
		
		Thread aa= new Thread()	// regular approach for object creation
		{						//inner anonymous class
			public void run() {
				for(int i=0;i<4;i++) {	System.out.println("thread from 2-inner class");}
			}
			
		};
		
		
		aa.start();
		
	}

}
