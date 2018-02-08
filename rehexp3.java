import java.util.regex.Pattern;
import java.util.StringTokenizer;
public class rehexp3 {

	public static void main(String[] args) {
		
	//space();
	//wDot();
	//token();
	token1();	
	//sSplit();
	}

static void space() {
	Pattern p=Pattern.compile("\\s");	//with respect to space
	String[] sarr=p.split("karna bahadur thapa");
	
	for(String s:sarr)
		System.out.println(s);
	
}

static void wDot() {
	Pattern p=Pattern.compile("\\.");	//with respect to '.'
	String[] sarr=p.split("www.google.com");
	
	for(String s:sarr)
		System.out.println(s);
	
}

static void token() {			//StringTokenizer class tokenization
	StringTokenizer st= new StringTokenizer("Karna bahadur thapa");
	while(st.hasMoreTokens()) {
		
		System.out.println(st.nextToken());
	}
}

static void token1() {		//StringTokenizer delim style
	StringTokenizer st= new StringTokenizer("Karna:bahadur-thapa",":");
	while(st.hasMoreTokens()) {
		
		System.out.println(st.nextToken());
	}
	
}

static void sSplit() {		//String class has split method
	String s="karna bahadur thapa";
	String[] sarr=s.split("\\s");
	for(String k:sarr)
		System.out.println(k);
}

}
