import java.util.*;
public class arrl {

	public static void main(String[] args) {
		
		ArrayList arr= new ArrayList();
		
		
		arr.add(123);	///adding
		arr.add("Ram");
		arr.add(10.4);
		
		System.out.println(arr);
		arr.add(0,21);	//adding by index
		System.out.println(arr);
		
		arr.remove(3);	//remove by index
		System.out.println(arr);
		
		arr.remove("Ram");  //remove by object
		System.out.println(arr);
		
		System.out.println(arr.contains(21)); //check if it contains
		System.out.println(arr.isEmpty());	//check if it is empty
		
		arr.clear(); //clear all object from arraylist
		System.out.println(arr);
		System.out.println(arr.isEmpty());	//check if it is empty
	}
}
