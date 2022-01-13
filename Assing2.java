package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assing2 {

	public static void main(String[] args) throws SQLException {
		
		Connection co = makeConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id for product details:");
		int id = sc.nextInt();
		ShowProduct(co,id);
		
	}
	
	public static Connection makeConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class not found in my path");
		}
		String url_db = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pwd = "root";
		
		Connection con=null;
		try {
			con = DriverManager.getConnection(url_db, uname, pwd);
			System.out.println("Connection sucessfull!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed!!"+e);
		}
		return con;
		
		
	}

	public static void ShowProduct(Connection con, int id) throws SQLException
	{
		Statement stmt = con.createStatement();
		String sql = "select * from product where _id ="+id;
		ResultSet res = stmt.executeQuery(sql);
		
		while(res.next())
		{
			int idd = res.getInt(1);
			String name = res.getString("product_name");
			int cost = res.getInt(3);
			String desc = res.getString("product_desc");
			String exp = res.getString("product_expiry");
			
			System.out.println(idd+" "+name+" "+cost+" "+desc+" "+exp);
		}
		
	}
}
