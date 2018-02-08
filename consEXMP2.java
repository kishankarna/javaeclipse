
public class consEXMP2 {

	public static void main(String[] args) {
		
		exmp ob=new exmp(12,"kana",50000);
		exmp ob2=new exmp(22,"Nanu",40000);
		ob.disp();
		ob2.disp();
	}
}

class exmp{ 
	int empid; //instance variable
	String ename;
	double esalary;
	
	exmp(int empid, String ename, double esalary)  //user defined constructor with local variables
	{
		this.empid=empid;
		this.ename=ename;
		this.esalary	=esalary;
	}
	void disp() {
		System.out.println("The emp id is :"+empid);
		System.out.println("The emp name is :"+ename);
		System.out.println("The emp salary is :"+esalary);
		
	}		
}
