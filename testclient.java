
public class testclient {
	public static void main(String[] args) {
		//class instantiation or object creation
		encap1 emp1= new encap1();
		encap1 emp2=new encap1();
		//using setter method
		emp1.setID(101);
		emp1.setName("Karna");
		
		//called getter method
		System.out.println("employe 1 ID :"+emp1.getID());
		System.out.println("Employee 1 Name: "+emp1.getName());
		//using setter method
		emp2.setID(102);
		emp2.setName("Name");
		//called getter method
		System.out.println("employe 1 ID :"+emp2.getID());
		System.out.println("Employee 1 Name: "+emp2.getName());
		
	}
}
