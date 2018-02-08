
public class ridemethod extends ovr{

		public static void main(String[] args) {
			
			ridemethod ob= new ridemethod();
			ob.talk();
			
		}
		public void talk() {
			System.out.println("This is talk method from main");
		}
		
		void walk() {
			System.out.println("This is walk method from main");
		}
}


class ovr{
	
	void talk() {
		System.out.println("This is talk method from ovr");
		
	}
	
	void walk() {
		System.out.println("This is walk method from ovr");
		
	}
	void sleep() {System.out.println("This is sleep method from ovr");}
}