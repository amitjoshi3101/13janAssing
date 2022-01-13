package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assingm1 {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc =new Scanner (System.in);
		Connection conn = makeConnection();
		
		insertvalues(conn,sc);
		

	}

	public static Connection makeConnection()
	
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class not found in mypath");
		}
		
		String url_nm = "jdbc:mysql://localhost:3306/bookshop";
		String unmae = "root";
		String pwd = "root";
		
		Connection con=null;
	     try {
			 con = DriverManager.getConnection(url_nm, unmae, pwd);
			 System.out.println("Connection Sucessful!!-->" +con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed!!-->"+e);
		}
		
	     return con;
	}
	public static void insertvalues(Connection con,Scanner sc) throws SQLException
	{
		Statement stmt = con.createStatement();
		String [] spl = new String[5];
		while(true)
		{
			System.out.println("Enter the values seperated by comma (Product id,Product name, Product cost, Product Desc, Expiry date)");
			String in = sc.nextLine();
			spl = in.split(",");
			
			String sql = "insert into product values("+spl[0]+",'"+spl[1]+"',"+spl[2]+",'"+spl[3]+"','"+spl[4]+"')";
			stmt.executeUpdate(sql);
			
			System.out.println("Do you want to insert values again(Yes/No):");
			String inp = sc.nextLine();
			if(inp.equalsIgnoreCase("no"))
			{
				break;
			}
		}
	}
}
