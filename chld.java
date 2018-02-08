
public class chld extends prnt {

	
	public static void main(String agrs[]) {
		
		chld ob= new chld();
		
		ob.talk();
		System.out.println(ob.add(3, 4, 2));
		System.out.println(ob.add(3, 4));
		
	}
	
	
public double add(double a, double b, double c) {
		
		return a+b+c;
	}

}
