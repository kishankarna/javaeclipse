//This program is for compound Interest  ##A=P(1+R)^n #//amount=principle*Math.pow(1+ rate, num);
// p:> principle
// R:> Rate
// n:> number of years

import java.util.Scanner;
public class cmpdIntrst {
	public static void main(String[] args) {
		Scanner val= new Scanner(System.in);
		
		System.out.println("please provie amount :");
		double principle=val.nextDouble();
		
		System.out.println("Provide the number of year you want to calculate :");
		int num= val.nextInt();
		
		System.out.println("Your principle amount :"+principle);
		System.out.println("You want calculation for "+ num +" years");
		
		double rate=0.1;
		
		double amount=0;
		
		
		
		
		for(int i=1;i<=num;i++)
		{
			
			amount=principle*Math.pow(1+ rate, i);
			System.out.println("The amount in "+i+" year(s) :"+amount);
		}
	}
}
