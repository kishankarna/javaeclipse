
public class consEX1 {
	public static void main(String[] args) {
		//int a[]= {1,2,3,4};
		conss ob=new conss();///constructer is executed when object is created
		//ob.talk(a);
	}
}


class conss{
	
	conss() {
		
		
		 talk(a);
	}

	private void talk(int[]arr) {
		
		for(int x:arr)
			System.out.print(x+"\t");
		//System.out.println("Hello this is method called  from constuctor");
	}
	
	int a[]= {1,2,3,4};
	
}