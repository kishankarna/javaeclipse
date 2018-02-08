//convert array in arralylist
import java.util.*;

public class arrl3 {

	public static void main(String[] args) {
		
		String arr[]= {"Ram","Ratna","Hari"}; //array
		
		ArrayList<String> arl= new ArrayList<String>(Arrays.asList(arr));	//converting to ArrayList
		
		arl.add("Gita");
		arl.add("Sita");
		
		for(String kk:arl)
			System.out.println(kk);
		
		
	}
}
