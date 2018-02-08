// checking for ip address, email address,, phone numbers
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

public class regexpn4 {
	public static void main(String[] args){
		
	m1();	
	//m2();	
	//m3();
	//m4();

	}
	
		static void m2() {	//checking 10 digit or 11 digit phone num but first number should be '0'
			Pattern p= Pattern.compile("0?[0-9]{10}");
			Matcher m=p.matcher("7289382940");
			if(m.matches()) {System.out.println("The phone number is valid");}
			else {	System.out.println("The phone number is invalid, please check the number");}
		}
	
	
			//-------------------------
			static void m1() {	//checking ip addresss
				Pattern p= Pattern.compile("\"^([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])\\\\.\" +\n" + 
						"		\"([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])\\\\.\" +\n" + 
						"		\"([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])\\\\.\" +\n" + 
						"		\"([01]?\\\\d\\\\d?|2[0-4]\\\\d|25[0-5])$\";");
				Matcher m=p.matcher("192.132.255.2");
				if(m.matches()) {System.out.println("The IP address is valid");}
				else {	System.out.println("The IP address is invalid, please check again");}
			}
				//------------------------
				static void m3() {	//checking email address
					Pattern p= Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
					Matcher m=p.matcher("2ksianthapamagar@yahoo.com");
					if(m.matches()) {System.out.println("The Email address is valid");}
					else {	System.out.println("Email address is invalid, please check again");}
				}
					//----------------------
					static void m4() {	//checking gmail email address only
					Pattern p= Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@gmail[.]com");
					String a="kisanthapamagr@gmail.com";	//putting in variable and making dynamic
					Matcher m=p.matcher(a);
					//Matcher m=p.matcher("2ksianthapamagar@gmail.com");
					if(m.matches()) {System.out.println("The Email address is valid");}
					else {	System.out.println("Email address is invalid, please check again");}
					}
		
}
