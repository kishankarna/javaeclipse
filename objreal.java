import java.util.Scanner;
public class objreal {

	public static void main(String[] args) {
		Scanner sn= new Scanner(System.in);
		System.out.println("Provide the number of paper to print: ");
		int pnum=sn.nextInt();
		
		printer p= new printer();
		paper pap= new paper();
		pap.setpaper(pnum);  //setting the paper
		p.prntpaper(pap); //priting the paper
		
	}
}

class printer{

	void prntpaper(paper pp) {  //passing paper object
		if (pp.page==0){ //checking paper count
			System.out.println("There no print at this time!!!");
		}else {  
			
			System.out.println("Printing "+pp.page+ " papers!!");
		}
		}
	}
class paper{
	
	int page;
	void setpaper(int a) {
		page=a;
	}
	int getpaper() {
		
		return page;
	}
}