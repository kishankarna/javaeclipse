import java.util.Scanner;
public class condtiopr {

	public static void main(String args[]) {
		
	Scanner a= new Scanner(System.in);
	
	int age=a.nextInt();
	String val;
	
	
	//System.out.println((age<19)?"You are teen ager":"you are adult"); // this is also called ternary operator
	val=(age<21)?"your are young":age>=21 && age<=50?"you are adult":age<80?"you are really old":"you have to die now";
	System.out.println(val);
	}
}
