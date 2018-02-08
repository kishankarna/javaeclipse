//sorting objects instead of primitive data
import java.util.*;
//driver class
public class arrl5 {

		public static void main(String[] args) {
			
			emptest e1= new emptest(55,"Karna");
			emptest e2= new emptest(22,"Nanu");
			emptest e3= new emptest(33,"Nikson");
			emptest e4= new emptest(44,"Hari");
			
			
			
			ArrayList<emptest> al= new ArrayList<emptest>();
			
			al.add(e1);
			al.add(e2);
			al.add(e3);
			al.add(e4);
			
			Collections.sort(al);		//using comparable method
			for(emptest kk:al)
				System.out.println(kk.eID+"  "+kk.eName);
		}
}
