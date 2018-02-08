
public class VAREXMP4 {
	public static void main(String[] args) {
		
		VAREXMP4 ob= new VAREXMP4();
		ob.m1(4, 4);
		VAREXMP4.m2("This is karna method");
	}
	
	
	void m1(int a, int b) {
		int sum=0;
		sum=a+b;
		System.out.println(sum);
	}
	
	static void m2(String str) {
		System.out.println(str);
	
	}
	
	
}
