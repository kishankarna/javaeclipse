import java.util.Arrays;
import java.util.Scanner;

public class que {

	static String[] queArr= new String[10];
	int front=-1;
	int rear=-1;
	int max=9;
	static boolean status=true;
	public static void main(String[] args)
	{
		que ob= new que();
		Scanner scan= new Scanner(System.in);
		while(status==true) {
		System.out.println("Enter 1: to insert in que: ");
		System.out.println("Enter 2: to delete in que: ");
		System.out.println("Enter 3: to show data from que: ");
		System.out.println("Enter 4: to terminate program: ");
		String kk=scan.nextLine();
		
		switch(kk) {
		
		case "1":
				System.out.println("enter data to insert: ");
				String n= scan.nextLine();
				ob.insert(n);
				break;
		case "2":
				String dat=ob.remove();
				System.out.println("removed data: "+dat);
				break;
		case "3":
				for(int i=0;i<queArr.length;i++) {
					System.out.println("que data: index "+i+" : "+ queArr[i]);
				}
				break;
		case "4":
				status=false;
				System.exit(0);
		default:
				System.out.println("Wrong choice!! try again!!");
				break;
		}
		}
		//ob.insert(kk);
	}
	
	
	void insert(String data) {
		if(rear<max) {
			rear=rear+1;
			this.queArr[rear]=data;
		}
		else {	System.out.println("overflow!!");}
		
		
	}
	
	String remove() {
		
		if(front!=rear) {
			front=front+1;
			String kk =this.queArr[front];
			this.queArr[front]=null;
			if(front==rear) { front=rear=-1;}
			return kk;
		}
		else {
			System.out.println("there is no data");
			return null;
		}
	}
}
