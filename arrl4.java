//using sort and Iterator

import java.util.*;

public class arrl4 {
	public static void main(String[] args) throws Exception {
		
		ArrayList ob= new ArrayList();
		
		
		
		
		ob.add("Ram");
		ob.add("Hari");
		ob.add("Gita");
		
		
		//Iterator i= ob.iterator();
		
		System.out.println("Before Sorting data");
		for(Object k:ob)
			System.out.println(k);
		
		System.out.println("After Sorting data");
		Collections.sort(ob);     //sorting data
		
		for(Object kk:ob)
			System.out.println(kk);
		
		Iterator i= ob.iterator();
		System.out.println("New after iteration");
		while(i.hasNext()) {
			Object ar = i.next();
			System.out.println(ar +" ");
		}
		
		
	}
}
