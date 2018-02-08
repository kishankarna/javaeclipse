class testthread4 extends Thread{
	
	public void run() {
		System.out.println("Hello karna");
	}
}

class testthread4b extends Thread{
	public void run() {
		System.out.println("Hello Nikson");
	}
}

class testthread4c extends Thread{
	public void run() {
		System.out.println("Hello Nanu");
	}
	
	
}
public class thread4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new testthread4().start();
		new testthread4b().start();
		new testthread4c().start();

	}

}
