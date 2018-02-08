import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class javamain {

	public static void main(String[] args) 
	{
		
		System.out.println(Calendar.getInstance().get(Calendar.MONTH)+1);
		System.out.println(Calendar.getInstance().get((Calendar.YEAR)));
		System.out.println(LocalDate.now());
	}
}
