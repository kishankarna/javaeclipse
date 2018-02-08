import java.sql.*;

import javax.swing.JOptionPane;

public class datCRT {
	String jdbcDriver = "com.mysql.jdbc.Driver";
	//String url = "jdbc:mysql://192.168.1.115:3306";		//for server
    static String dbAddress = "jdbc:mysql://localhost:3306/";	//for local server
    static String userPass = "?user=root&password=NIKsonbaby";	//user and password
    static String dbName = "Karnadb";
    static String password = "NIKsonbaby";
    static String userName = "root";
    static Connection con=null;
    
	public static void main(String[] args) {
		
		createDB();
		createTb1();
		createTb2();
		createTb3();
	}	
	
	
		static void createDB() {
		
	    
			try {
	    		Class.forName("com.mysql.jdbc.Driver");
	    		con = DriverManager.getConnection(dbAddress+userPass);	
	    		String sql = "CREATE DATABASE if not Exists karnadb";	//putting db name
	    		PreparedStatement statement = con.prepareStatement(sql);
	        statement.executeUpdate();
	        
	        statement.close();
	        System.out.println("Database created");
			}
			catch(Exception e) {e.printStackTrace();}
		}
		
		///end of creation database
		static void createTb1() {
	        String myTableName = "CREATE TABLE category (" 
	            + "categoryID INT(11) primary key,"  
	            + "name VARCHAR(255))"; 
	        
	        try {
	        		Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(dbAddress + dbName, userName, password);// userName, password);
	            Statement statement = con.createStatement();
	            statement.executeUpdate(myTableName);
	            System.out.println("Table Created");
	        	  }
		      catch (SQLException e ) 			{	System.out.println("An error has occurred on Table Creation");}
	        	  catch (ClassNotFoundException e) {	System.out.println("An Mysql drivers were not found");}
	    }
		static void createTb2() {
	        String myTableName = "CREATE TABLE expense (" 
	            + "expenseID INT(11),"  
	            + "categoryID INT(11)," 
	            + "amount dobule,"
	            + "date DATE,"
	            + "remark VARCHAR(255),"
	            + "primary key(expenseID), foreign key(categoryID) references category(categoryID))"; 
	        
	        try {
	        		Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(dbAddress + dbName, userName, password);// userName, password);
	            Statement statement = con.createStatement();
	            statement.executeUpdate(myTableName);
	            System.out.println("Table Created");
	        	  }
		      catch (SQLException e ) 			{e.printStackTrace();}
	        	  catch (ClassNotFoundException e) {	System.out.println("An Mysql drivers were not found");}
	    }
		static void createTb3() {
	        String myTableName = "CREATE TABLE salaryTB (" 
	            + "salaryID INT(11),"  
	            + "salary double," 
	            + "date DATE,"  
	            + "salaryType enum('salary','bonus','other'))"; 
	        
	        try {
	        		Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(dbAddress + dbName, userName, password);// userName, password);
	            Statement statement = con.createStatement();
	            statement.executeUpdate(myTableName);
	            System.out.println("Table Created");
	        	  }
		      catch (SQLException e ) 			{	System.out.println("An error has occurred on Table Creation");}
	        	  catch (ClassNotFoundException e) {	System.out.println("An Mysql drivers were not found");}
	    }
}
