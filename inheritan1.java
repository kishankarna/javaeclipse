
public class inheritan1 {
	public static void main(String[] agrs)
	{
		new B().add(10, 20);
	
	}

}

class A{
	int x=100;
	int y=200;
	
}

class B extends A{
	
	int x=1000;
	int y=2000;
	void add(int x, int y) {
		System.out.println(x+y);  //local varibles
		System.out.println(this.x+this.y);  //current class variable
		System.out.println(super.x+super.y);// parent/super variavles
		
	}
}


