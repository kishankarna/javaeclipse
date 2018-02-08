
public class INSBLK2 {
	public static void main(String[] args) {
		new emp1().disp();
	}
	
}

class emp1
{
	int empID;
	
	
	{//instance block
		//System.out.println("This is instance block");
		empID=30;
		
	}
	void disp() {
		
		System.out.println("Employe ID is :"+empID);
	}
	
	

}
