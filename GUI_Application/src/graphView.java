import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class graphView implements ActionListener{


	public graphView(){}

	public graphView(String order) {
	
		gui();
	
	}
	
	
	void gui() throws NullPointerException{
			
			
			graph();
		
	}
	void graph() {			
		 
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(  
						"jdbc:mysql://192.168.1.115:3306/karnadb","karna","1k2k3k4k5k6k");  
				PreparedStatement pst1,pst2,pst3,pst4,pst5,pst6,pst7,pst8,pst9,pst10,pst11,pst12=null;
				ResultSet rs1,rs2,rs3,rs4,rs5,rs6,rs7,rs8,rs9,rs10,rs11,rs12= null;
				
				String fn = JOptionPane.showInputDialog("Input Years in Four Digits [YYYY]");
				
				if(!fn.equals(null)) {	
				//String dat=txYear.getText();
				Pattern pd=Pattern.compile("[0-9]{4}");		//for date
				Matcher md=pd.matcher(fn);
				
				if(md.matches()) {
				
					if(Integer.valueOf(fn)>(Calendar.getInstance().get(Calendar.YEAR))){
						JOptionPane.showMessageDialog(null, 
						          "Invalid Date!!", 
						          "Warning", 
						          JOptionPane.INFORMATION_MESSAGE);
					}
					else {
				int year=Integer.parseInt(fn);
				
				double tot1=0,tot2=0,tot3=0,tot4=0,tot5=0,tot6=0,tot7=0,tot8=0,tot9=0,tot10=0,tot11=0,tot12=0;
				
				pst1=con.prepareStatement("Select amount from expense where month(date)=1 and year(date)=?");
				pst1.setInt(1,year);
				rs1=pst1.executeQuery();
				while(rs1.next())  {		tot1+=rs1.getInt(1);		}
				
				pst2=con.prepareStatement("Select amount from expense where month(date)=2 and year(date)=?");
				pst2.setInt(1,year);
				rs2=pst2.executeQuery();
				while(rs2.next())  {		tot2+=rs2.getInt(1);		}
				
				pst3=con.prepareStatement("Select amount from expense where month(date)=3 and year(date)=?");
				pst3.setInt(1,year);
				rs3=pst3.executeQuery();
				while(rs3.next())  {		tot3+=rs3.getInt(1);		}
				
				pst4=con.prepareStatement("Select amount from expense where month(date)=4 and year(date)=?");
				pst4.setInt(1,year);
				rs4=pst4.executeQuery();
				while(rs4.next())  {		tot4+=rs4.getInt(1);		}
				
				pst5=con.prepareStatement("Select amount from expense where month(date)=5 and year(date)=?");
				pst5.setInt(1,year);
				rs5=pst5.executeQuery();
				while(rs5.next())  {		tot5+=rs5.getInt(1);		}
				
				pst6=con.prepareStatement("Select amount from expense where month(date)=6 and year(date)=?");
				pst6.setInt(1,year);
				rs6=pst6.executeQuery();
				while(rs6.next())  {		tot6+=rs6.getInt(1);		}
				
				pst7=con.prepareStatement("Select amount from expense where month(date)=7 and year(date)=?");
				pst7.setInt(1,year);
				rs7=pst7.executeQuery();
				while(rs7.next())  {		tot7+=rs7.getInt(1);		}
				
				pst8=con.prepareStatement("Select amount from expense where month(date)=8 and year(date)=?");
				pst8.setInt(1,year);
				rs8=pst8.executeQuery();
				while(rs8.next())  {		tot8+=rs8.getInt(1);		}
				
				pst9=con.prepareStatement("Select amount from expense where month(date)=9 and year(date)=?");
				pst9.setInt(1,year);
				rs9=pst9.executeQuery();
				while(rs9.next())  {		tot9+=rs9.getInt(1);		}
				
				pst10=con.prepareStatement("Select amount from expense where month(date)=10 and year(date)=?");
				pst10.setInt(1,year);
				rs10=pst10.executeQuery();
				while(rs10.next())  {		tot10+=rs10.getInt(1);		}
				
				pst11=con.prepareStatement("Select amount from expense where month(date)=11 and year(date)=?");
				pst11.setInt(1,year);
				rs11=pst11.executeQuery();
				while(rs11.next())  {		tot11+=rs11.getInt(1);		}
				
				pst12=con.prepareStatement("Select amount from expense where month(date)=12 and year(date)=?");
				pst12.setInt(1,year);
				rs12=pst12.executeQuery();
				while(rs12.next())  {		tot12+=rs12.getInt(1);		}
				
				DefaultCategoryDataset barCharData=new DefaultCategoryDataset();
				barCharData.setValue(tot1, "Expense", "January"); 
				barCharData.setValue(tot2, "Expense", "February"); 
				barCharData.setValue(tot3, "Expense", "March"); 
				barCharData.setValue(tot4, "Expense", "April"); 
				barCharData.setValue(tot5, "Expense", "May"); 
				barCharData.setValue(tot6, "Expense", "June"); 
				barCharData.setValue(tot7, "Expense", "July"); 
				barCharData.setValue(tot8, "Expense", "August"); 
				barCharData.setValue(tot9, "Expense", "September"); 
				barCharData.setValue(tot10, "Expense", "October"); 
				barCharData.setValue(tot11, "Expense", "November"); 
				barCharData.setValue(tot12, "Expense", "December"); 
				// wer are using jar file for this graph creation
				JFreeChart chart= ChartFactory.createBarChart("Monthly Expense",year+" YEAR","Dollars",barCharData, PlotOrientation.VERTICAL, true, true, false);
				chart.setBackgroundPaint(Color.cyan);
				chart.getTitle().setPaint(Color.red);
				CategoryPlot p=chart.getCategoryPlot();
				p.setRangeGridlinePaint(Color.cyan);
				ChartFrame frm= new ChartFrame("BAR CHART", chart);
				frm.setVisible(true);
				frm.setBounds(150, 200, 1100, 350);
			
				rs1.close();rs2.close();rs3.close();rs4.close();rs5.close();rs6.close();rs7.close();rs8.close();
				rs9.close();rs10.close();rs11.close();rs12.close();
				pst1.close();pst2.close();pst3.close();pst4.close();pst5.close();pst6.close();pst7.close();
				pst8.close();pst9.close();pst10.close();pst11.close();pst12.close();
				con.close(); 
				}
				}
				else
				{
				JOptionPane.showMessageDialog(null, 
		          "Fix the Year!!", 
		          "Check Input Details", 
		          JOptionPane.INFORMATION_MESSAGE);
				}
			  }//end of outer if
				else
				{
					JOptionPane.showMessageDialog(null, 
					          "Fix the Year!!", 
					          "Check Input Details", 
					          JOptionPane.INFORMATION_MESSAGE);	
				}
			}
			catch(Exception e) {e.printStackTrace();}
			//catch(NullPointerException en) {en.printStackTrace();}
			}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		new graphView("This is new gui");
	}
}
