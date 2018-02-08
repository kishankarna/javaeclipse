
public class varlengthARG {
	public static void main(String[] ags) {
		
		System.out.println("The average is: "+ AVG(2,4,6,12,13,14,25,2,2,5,5,44));
	}
	
	public static int AVG(int...average) {
		
		int sum=0;
		for(int x:average)
			sum+=x;
		return sum/average.length;
	}
}
