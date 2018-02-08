//display files from folder using pattern and also everything
import java.util.regex.Pattern;


import java.util.regex.Matcher;
import java.io.*;

public class regexp5 {

	public static void main(String[] args) {
		
		findFile();
	}

	
	static void findFile() {	//find files from folder that has .pdf extension
		Pattern p= Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9$_.]*[.]pdf");
		File f= new File("/Users/karna/Desktop/pen");
		String[] s=f.list();
		for(String s1:s)
		{
			//System.out.println(s1);		//all files and folder
			Matcher m=p.matcher(s1);
			if(m.matches()) {	System.out.println(s1);}
		}

	}
}
