

public class enumr {
	
	public enum status{
		ACTIVE,INACTIVE,PENDING,DELETED
		
	}
	
	public static void main(String[] args) {
		
		status st= status.DELETED;
		statusmethod(st);
	}
		
			
		
			public static void statusmethod(status s) {
			
			if(s==s.ACTIVE)
				System.out.println("You are awsome member");
			else
				System.out.println("You need to reactivate  membership");
			}
		
	
}
