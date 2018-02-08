import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mdiForm extends JFrame  {


JMenuBar mBar;
JMenu mFile,mTrans,mIncome,mReport,mAbout,mLedger;
JMenuItem mDataCenter,mExit,entryMenu,delMenu,monMenu,yearMenu,catMenu,sumMenu,monPaymentMenu, balSheetMenu,graphViewMenu,
		  mSalary,mSalaryResult;	
JLabel l1;
	mdiForm(){
		createmainForm();
		createmenu();
	}
	
	void createmainForm() {
		
		setTitle("EXPENSE MANAGEMENT APPLICATION");
		setBounds(50, 100, 1300, 850);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//JLabel background=new JLabel(new ImageIcon("/Users/karna/Desktop/exp.jpg"));
		//JLabel background=new JLabel();	background.setSize(1300, 850);  background.setBackground(new Color.blue);
		//add(background);
	}
	
	void createmenu() {
		mBar= new JMenuBar();
		this.setJMenuBar(mBar);
		
		mFile= new JMenu("File");							mBar.add(mFile);
			mDataCenter= new JMenuItem("Data Center");		mFile.add(mDataCenter);
			mExit= new JMenuItem("Exit");					mFile.add(mExit);
			
			mDataCenter.addActionListener(new dataEngine());     //adding action for this menu
			mExit.addActionListener(new ActionListener() {		//inner class implemented action
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}});
		
		mTrans= new JMenu("Expenditure");						mBar.add(mTrans);
			monPaymentMenu= new JMenuItem("Montlhy Payment");		mTrans.add(monPaymentMenu);
			monPaymentMenu.addActionListener(new paymentMonth());//adding action for this menu
		
			entryMenu= new JMenuItem("Enter Purchase");			mTrans.add(entryMenu);	
			entryMenu.addActionListener(new expEntry());			//adding action to this menu
			
			delMenu= new JMenuItem("Delete-> Purchase");			mTrans.add(delMenu);
			delMenu.addActionListener(new delExp());				//adding action to this menu
			
		
		mIncome = new JMenu("Income");							mBar.add(mIncome);
			mSalary= new JMenuItem("Enter->Salary");				mIncome.add(mSalary);
			mSalaryResult= new JMenuItem("Display Salary");		mIncome.add(mSalaryResult);
			mSalary.addActionListener(new salary());  			//adding action
			mSalaryResult.addActionListener(new salaryResult());	//adding action
			
			
		mReport= new JMenu("Expense Reports");					mBar.add(mReport);
			monMenu= new JMenuItem("Monthly");					mReport.add(monMenu);
			monMenu.addActionListener(new reportMonth()); 		//adding action to this menu
			yearMenu= new JMenuItem("Yearly");					mReport.add(yearMenu);
			yearMenu.addActionListener(new reportYear()); 		//adding action to this menu
			catMenu= new JMenuItem("Category wise"); 			mReport.add(catMenu);
			catMenu.addActionListener(new reportCat()); 			//adding action to this menu
		
		mLedger= new JMenu("Summary");							mBar.add(mLedger);
			balSheetMenu= new JMenuItem("Balance Sheet");		mLedger.add(balSheetMenu);
			graphViewMenu= new JMenuItem("Graph view");			mLedger.add(graphViewMenu);
			balSheetMenu.addActionListener(new balanceForm());   //adding action to this menu
			graphViewMenu.addActionListener( new graphView()); 	//adding action to this menu
			
		mAbout= new JMenu("Help");								mBar.add(mAbout);
			sumMenu= new JMenuItem("Contact");					mAbout.add(sumMenu);
		
		sumMenu.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, 
                     "Karna Thapa\nkisanthapamagar@gmail.com\nCopyright@ 983-6909 Thapa", 
                     "System Administraor", 
                     JOptionPane.INFORMATION_MESSAGE);
					
				}
		});
	
	}
	
	public static void main(String[] args)  {
		mdiForm form =new mdiForm();
		//form.setBackground(new Color(255,255,0));
		form.setVisible(true);
	}}
