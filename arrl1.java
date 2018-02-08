import java.util.*;
public class arrl1 {

		public static void main(String[] args) {
			
			emp e1= new emp(11,"Karna");
			emp e2= new emp(22,"Nanu");
			emp e3= new emp(33,"Nikson");
			emp e4= new emp(44,"Hari");
			
			
			
			ArrayList<emp> al1= new ArrayList<emp>();
			ArrayList<emp> al2= new ArrayList<emp>();
			
		
			al1.add(e1);	//adding object
			al1.add(e2);
			
			al2.addAll(al1);	//adding another collection
			al2.add(e3);
			al2.add(e4);
			
			
			System.out.println(al2.containsAll(al1));	//checking for collection
			System.out.println(al2.contains(e4));		//checking for object
			
			
			al2.removeAll(al1);	//removing collectoin
			
			
			for(emp k:al2)
				System.out.println(k.eID+"   "+k.eName);
		}
		
}
