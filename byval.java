
public class byval {

		public static void main(String[] args) {
			
		int a=10,b=20;
		byval.swap(a, b);
		System.out.println("The value of a in main: "+a);
		System.out.println("The value of b in main: "+b);
		
		
		}
		
		
		static void swap(int a, int b) {
			
			int temp;
			temp=a;
			a=b;
			b=temp;
			System.out.println("The value of a: "+a);
			System.out.println("The value of b: "+b);
		}
		
		
}
