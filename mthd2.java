
public class mthd2 {
	int x=300;
	int y=400;
	
	public static void main(String[] args) {
		
		mthd2 ob= new mthd2();
	
		ob.m1(20, 20);
		//ob.m1(100);
	
	}

	void m1(int x, int y) {
		System.out.println(this.x+this.y);
		System.out.println(x+y);
	}
	
	void m1(int x) {
		System.out.println(this.x+this.y);
		
		
	}

}
