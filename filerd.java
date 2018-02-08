
import java.io.*;
//import java.io.FileOutputStream;

public class filerd {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		FileInputStream fIn= new FileInputStream("kk.txt");
		FileOutputStream fOut= new FileOutputStream("nk.txt");
		
		int c;
		while((c=fIn.read())!=-1)
			{
				fOut.write(c);
				
			}
		fIn.close();
		fOut.close();
	}

}
