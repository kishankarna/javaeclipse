//bean class behavior--- contains private properties and getter and setter method
public class encap1 {
	private int eID;
	private String eName;
	
	
	//setter
	public void setID(int eID) {
		this.eID=eID;
	}
	
	public void setName(String eName) {
		this.eName=eName;
	}
	
	///getter
	public int getID() {
		return eID;
	}
	
	public String getName() {
		return eName;
	}
}
