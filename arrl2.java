//instance of approach for non generic data
import java.util.*;

public class arrl2 {
	public static void main(String[] args) {
		
		
		emp e1= new emp(11,"Karna");
		emp e2= new emp(22,"Nanu");
		
		ArrayList al0= new ArrayList();	//non generics
		
		al0.add("Karna"); //non generics addition
		al0.add(100);
		al0.add(e1);
		al0.add(e2);//------------------
		
		
		//instance of approach 
		//System.out.println(al0);
		for(Object kk:al0)
		{
			if( kk instanceof String)
				System.out.println(kk);
			
			if(kk instanceof Integer)
				System.out.println(kk);
			if(kk instanceof emp)
				{emp ee = (emp)kk;
				System.out.println(ee.eID+"  "+ee.eName);}
			
				
		
		}/// end of instance of approach
	}
	
	
}
