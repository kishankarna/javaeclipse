//method vs returning objects  /// also returning different class object
class EMPP{}
class stu{}
public class mthd4 {
	
	EMPP m1() {
		System.out.println("This is m1 methid");
		EMPP e= new EMPP();
		return e;
		//one line code for it--- return new EMP();
	}
	
	stu m2() {
		System.out.println("This is m2 method");
		return new stu();
		
	}
	
	static String m3() {
		System.out.println("This is m3 method");
		return "KARNA";
	}
	
	public static void main(String[] args) {
		mthd4 ob = new mthd4();
		
		EMPP e1=ob.m1();
		System.out.println(e1);  // its going to print hash code
		
		stu s1=ob.m2();
		System.out.println(s1);   //its going to print hash code
		
		String str=mthd4.m3();
		System.out.println(str);
	}
}
