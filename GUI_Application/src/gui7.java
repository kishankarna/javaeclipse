import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gui7 extends JFrame{

	
	gui7(){
		//JFrame frame= new JFrame("Karna");
		
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar mBar= new JMenuBar();
		this.setJMenuBar(mBar);
		
		JMenu mFile= new JMenu("File");
		mBar.add(mFile);
		JMenuItem mOpn= new JMenuItem("Open");
		JMenuItem mExt= new JMenuItem("Exit");
		mFile.add(mOpn);	mFile.add(mExt);
		mOpn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("File is opened!!");
				}});
		mExt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("File is exited!!");
				}});
		
		JMenu mEdit= new JMenu("Edit");
		mBar.add(mEdit);
		JMenuItem mCut= new JMenuItem("Cut");
		JMenuItem mPaste= new JMenuItem("Paste");
		mEdit.add(mCut);mEdit.add(mPaste);
		mCut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is cut command");
			}});
		mPaste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is paste command");
			}});
		
		JMenu mHelp= new JMenu("Help");
		mBar.add(mHelp);
		JMenuItem mAbout= new JMenuItem("About");
		mHelp.add(mAbout);
		mAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("This is about menu!!");
			}});
	}
	
	

	public static void main(String[] args) {
		gui7 k=new gui7();
		
		k.setVisible(true);
		
	}

}
