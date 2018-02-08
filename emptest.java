
public class emptest implements Comparable{

	int eID;
	String eName;
	
	emptest(int eID, String eName){
		
		this.eID=eID;
		this.eName=eName;
	}
	
	/*
	public int compareTo(Object o) { //overiding method of comparable class //sorting by ID/ integer
		emptest e=(emptest)o;
		
		if(eID==e.eID)		//
			return 0;
		else if(eID>e.eID)
			return 1;
		else
			return -1;
		
	}
	*/
	@Override
	public int compareTo(Object o) { //overiding method of comparable class //sorting by string
		emptest e=(emptest)o;
		return (eName.compareTo(e.eName));	//for ascending order
		//-return (eName.compareTo(e.eName));	//for descending
		
	}
}

