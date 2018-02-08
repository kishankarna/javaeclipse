//this example show how to pass object as a parameters
class employe{}
class student{}

public class mthd1 {
	public static void main(String[] args) {
		
		mthd1 ob= new mthd1();
		employe e1= new employe();
		ob.m1(e1);
		//ob.m1(new employe());
		
		student s1= new student();
		mthd1.m2(s1);
		//mthd1.m2(new student());
	}
	
	
	
	void m1(employe e) {
		System.out.println("This is employee method with e object");
	}
	
	static void m2(student s) {
		
		System.out.println("This is student method with s object");
		
	}
	
}
