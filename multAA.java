//two dimentional array
public class multAA {

	public static void main(String[] agrs) {
		
		int a[][]    = {{3,2,1},{23,54,23}};
		//  a[row][col]={{first row},{second row}};
		// a.lenth :> row length
		// a[0].lenth :> column length
		int b[][]= {{4,7,8},{6},{76,85,53}};
		display(a);
		System.out.println("This is second array");
		display(b);
		//         first row, second, third
		//4   7   8
		//6
		//76  85  53
		
		
		//System.out.println(b[1][0]);
	}
	
	public static void display(int x[][]) {
		
		for(int row=0;row<x.length;row++)
		{
			
			for(int col=0;col<x[row].length;col++) {
				System.out.print(x[row][col]+"\t");
			}
			System.out.println("");
		}//System.out.println("****");
		
	}
	
}
