// returning same class object
public class mthd5 {
	
	mthd5 m1() {
		System.out.println("This is m1 method");
		mthd5 m= new mthd5();
		return m;  // return new mthd5();   //or just return this  b'coz it is on same class
		
	}
	
	mthd5 m2() {
		System.out.println("This is m2 method");
		return this;
	}

	
	public static void main(String[] args) {
		mthd5 m=new mthd5();
		
		mthd5 m1=m.m1();
		mthd5 m2=m.m2();
		
	}
}
