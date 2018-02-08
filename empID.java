import java.util.Comparator;

public class empID implements Comparator{
	
	
	public int compare(Object o1, Object o2) {
		
	emptestlogic e1= (emptestlogic)o1;
	emptestlogic e2=(emptestlogic)o2;
	
	if(e1.eID==e2.eID) {
		return 0;
	}
	else if(e1.eID>e2.eID) {
		return 1;
	}
	else
	{	return -1;
		
	}
	
	
	
	}		
}
