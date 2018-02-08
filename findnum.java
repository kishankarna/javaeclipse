
public class findnum {
	public static void main(String[] args) {
	//System.out.println("This is java");
	int arr[]= {1,3,4,5,6,7,8,9,10};
	
	//sum=n*(n+1)/2
	//exp sum -act sum =result
	//System.out.println(arr[2]);
	int num=10;
	int sum,val=0;
	int actSum=0;
	sum=num*(num+1)/2; //expec sum
	
	//actual sum
	
	for(int x:arr)
	{
		actSum+=x;
	}
	val=sum-actSum;
	
	if(val!=0) {
			System.out.println("The missing number is : "+val);}
	else
		{System.out.println("There is no missing number" );
		}
	}
}
