import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regExp1 {
	public static void main(String[] args) {
		
		Pattern pt=Pattern.compile("bb");
		//String k=/^xcvcxvcxv$/;
		Matcher m=pt.matcher("abaaaabbbaab");
		
		if(m.matches()) {System.out.println("true");}
		int cnt=0;
		while(m.find())
		{
			System.out.println("Starts at "+m.start()+ " ends@"+m.end() +"  The word is "+m.group());
			cnt++;
		}
		System.out.println(cnt+" times present");
	}
	
	
}
