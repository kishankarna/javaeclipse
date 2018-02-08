//This is 10 digits phone number validation using The NANP number format. Summarized in the notation NPA-NXX-xxxx:

import java.util.regex.Pattern;	//importing Pattern from regex library to make a pattern
import java.util.regex.Matcher;  //importing Matcher from regex library to match with the Pattern
import java.util.Scanner;		//get system user input

public class UsPhoneNumberFormat {

	public static void main(String[] args) {
		UsPhoneNumberFormat phn= new UsPhoneNumberFormat();
		Scanner scan= new Scanner(System.in);
		
		System.out.printf("Input phone number: ");
		String input=  scan.nextLine();
		String kk=phn.formatPhoneNumber(input);
		System.out.println(kk);
		
		//int num=scan.nextInt();
		//System.out.println(phn.rec(num));
	}
	
	int rec(int num) {			//recursion method
		
		if(num<=0) {
		return 1;
		}
		else
		{
			return num * rec(num-1);
		}
	}
	String formatPhoneNumber(String number) {

		Pattern p= Pattern.compile("[2-9][0-9]{2}(-)?[2-9][0-9]{2}(-)?[0-9]{4}");
		//Pattern p= Pattern.compile("\\d{1,3}");
		Matcher m=p.matcher(number);				//this check the number with our defined pattern
		
		if(m.matches())							//if input number matcher return with the addition of '+1', 1 is US country code
		{										//this is for E.164 format
			Pattern p1=Pattern.compile("[2-9][0-9]{2}(-)?[2-9][1][1](-)?[0-9]{4}");	//futher checking for NXX position not to have N11 digits
			Matcher m1=p1.matcher(number);
			if(m1.matches()) {	return null;}
			else {
			return "+1"+number;
			}
		}
		else {
			return null;
		}
	}
	

	
}
