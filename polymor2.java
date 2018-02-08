//changing return type at class level for overridng concept

class animal{}
class cat extends animal{}

public class polymor2 {
	public static void main(String[] args) {
		new childpol2().talk();
		
	}
}

class parentpol2{
	animal talk() {
		System.out.println("This is animal talk method");
		return new animal();
		// or
		// animal a= new animal();
		// return a;
	}
}

class childpol2 extends parentpol2{
	cat talk() {
		System.out.println("This is cat talk method");
		return new cat();
	}
	
}
