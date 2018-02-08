
public class psbyval {
	public static void main(String[] args) {
	
		int a=2;
		int b=5;
		
		swap(a,b);  ///cal by value in java  \\you can only call by value in java #no call by referance
	
		System.out.println(a);
		System.out.println(b);
	
	}
	
	
	
	
	public static void swap(int a, int b) {
		
		int temp=a;
		a=b;
		b=temp;
		System.out.println(a);
		System.out.println(b);
	}
}
