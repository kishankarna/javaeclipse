
public class VARINS {
	static int a=100;  ///static var
	static String b;
	public static void main(String[] args) {
		
		System.out.println(a);  //one way to access static var
		System.out.println(VARINS.a); // 2nd way to access static var   // always try to call this method for static var
		VARINS ob= new VARINS();
		System.out.println(ob.a);   //3rd way to access static var
	
		System.out.println(VARINS.b);
	}
}
