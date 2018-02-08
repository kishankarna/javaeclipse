
public class arrMethod {
	public static void main(String[] args) {
		
		
		int arr[]= {4,2,5,2,1};
	
		chng(arr);
		for(int y:arr)
			System.out.println(y);
	}
	
	
	
	public static void chng(int a[]) {
		
		
		for(int x=0;x<a.length;x++)
			a[x]=a[x]+5;
			
	}
}
