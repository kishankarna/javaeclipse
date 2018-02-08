
import java.util.Scanner;
class paperPP{
	
	int paper;
	void setPaper(int paper) {	this.paper=paper; }
	int getPaper() 			{	return paper; }
}


public class obexam {
	
	
	public static void main(String[] args) {
		Scanner snn= new Scanner(System.in);
		
		System.out.println("how many pages you want to print: ");
		int page=snn.nextInt();
	
		paperPP pp= new paperPP();
		pp.setPaper(page);
	
		printerPrintPaper(pp);
	
	}
	
	public static void printerPrintPaper(paperPP p) {
			int k=p.getPaper(); //times
				for(int i=1;i<=k;i++)
			System.out.println("Printing.."+i+" Paper(s)");
	}
	
}
