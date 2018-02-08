import java.util.regex.*;

public class regExp2 {

	public static void main(String[] args) {
		String a="w?";
		Pattern p= Pattern.compile("w?");
		
		Matcher m=p.matcher("abcw");
		
		while(m.find()) {
			
			System.out.println(m.start()	+ "  "+m.group());
		}

	}

}
