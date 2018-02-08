
public class array {
	public static void main(String args[]) {
		//int val[]= new int[3];
		System.out.println("Index\tValue");
		int val[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,28,29,30}; //given value for an array
		
		int std[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30}; //standard value for array
		int num=0; //
		
					for(int i=0;i<val.length;i++)
						{
							System.out.println(i+"\t"+val[i]);
						}
		
		for(int i=0;i<val.length;i++)
		{
			
			
			if(std[i]==val[i]) {
				//System.out.println(i+"\t"+val[i]);
				
			}
			else
			{
				num=std[i];
				
				System.out.println("Missing num is :"+num);
				break;
			}
		}
	
		
	}
}
