import java.util.ArrayList;

public class arrlst {
	public static void main(String[] args) {
		
	ArrayList<Integer> arr= new ArrayList<>(5);	
	
	for(int a=1;a<=10;a++)
	{
		arr.add(a);
		
	}
	for(int b:arr) {
		System.out.println(b);
	}
}
}