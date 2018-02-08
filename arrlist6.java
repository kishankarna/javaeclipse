//sorting objects instead of primitive data// using comparator technique
//uses empID class, emptestlogic class
import java.util.*;
//driver class
public class arrlist6 {
	

			public static void main(String[] args) {
				
				emptestlogic e1= new emptestlogic(55,"Karna");
				emptestlogic e2= new emptestlogic(22,"Nanu");
				emptestlogic e3= new emptestlogic(33,"Nikson");
				emptestlogic e4= new emptestlogic(44,"Hari");
				
				
				
				ArrayList<emptestlogic> al= new ArrayList<emptestlogic>();
				
				al.add(e1);
				al.add(e2);
				al.add(e3);
				al.add(e4);
				
				Collections.sort(al,new empID());		//using comparator method
				for(emptestlogic kk:al)
					System.out.println(kk.eID+"  "+kk.eName);
			}
}
