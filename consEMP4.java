

public class consEMP4 {
	public static void main(String args[]) {
		
		test ob=new test();
		new test(22);   //test ob2=new test(22);
		//System.out.println(ob);
	}
}

class test{
	int ducksize;
	
	test(){
		
		ducksize=12;
		size();
	}
	test(int a){
		
		ducksize=a;
		size();
		
	}
	public void size() {
		
		System.out.println(ducksize);
	}
	
	
}
