package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assing5 {

	public static void main(String[] args) throws SQLException {
		Connection co =makeConnection();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id you want to change product name");
		int id = sc.nextInt();
		UpdateTable(co,id);
		

	}

	public static Connection makeConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class not avaibale in my path");
		}
		String url = "jdbc:mysql://localhost:3306/bookshop";
		String user = "root";
		String pwd = "root";
		
		Connection con=null;
		try {
			 con= DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection success!!"+con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed");
		
		}
		return con;
	}
	public static void UpdateTable(Connection con,int id) throws SQLException
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the product desc you want to update:");
		String nm = sc.nextLine();
		
		Statement stmt = con.createStatement();
		String sql = "update product set product_desc= '"+nm+"' where _id="+id;
		stmt.executeUpdate(sql);
		
		
	}
}
