import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
class phone{
	String name;
	String address;
	String phn;
	
	phone(String name, String address, String phn){		//cons
	this.name=name;
	this.address=address;
	this.phn=phn;
		
	}
}

public class arragain {

	public static void main(String[] args) throws IOException {
		boolean status=true;
		int count=1;	//for the record count
		phone phn;					//class object reference
		ArrayList<phone> arr= new ArrayList<phone>();	//database
		
		//Scanner sn= new Scanner(System.in);
		BufferedReader rd= new BufferedReader(new InputStreamReader(System.in));
		do {
		//System.out.println("---------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("            Enter 1 to continue: ");
		System.out.println("            Enter 2 to show data: ");
		System.out.println("            Enter 4 to EXIT: ");
		//int a=sn.nextInt();
		int a=Integer.parseInt(rd.readLine());
		if(a==1) {
			System.out.println(count+ "  record for phone!!");
			System.out.println("------------------------");
			System.out.println("Enter name: ");
			//String nam= sn.nextLine();
			String nam=rd.readLine();
			System.out.println("Enter address: ");
			//String add= sn.nextLine();
			String add=rd.readLine();
			System.out.println("Enter phone: ");
			//String pn=sn.nextLine();
			String pn=rd.readLine();
		
			
			arr.add(new phone(nam,add,pn));			//adding file objects to arraylist
			System.out.println("---------------Record is updated-----------------");
			count++;	//for the record time
		}
		else if(a==2) {		
			        if(arr.isEmpty()) {	System.out.println("There is no Records!!");}
			        else {
			        	System.out.println("--------------------Database--------------------");
					for(phone kk:arr) {
						
						//System.out.println("------------------------------------------------");
						System.out.println(kk.name+ "         "+kk.address+"         "+kk.phn);
						}System.out.println("------------------------------------------------");
						
				    }
		}
		else if(a==4) {	status=false;	System.out.println("----Terminated----"); System.exit(0);	 }
		else {	System.out.println("You can wrong choice!!");}
		
		}while(status== true);
		
			

	}
	
}
