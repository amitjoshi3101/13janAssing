package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assing3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection co=makeConnection();
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the id you want to delete:");
		int id =sc.nextInt();
		deleteRowById(co,id);
		
		

	}

	public static Connection makeConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver Class not found in filepath");
		}
		String url ="jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pwd = "root";
		Connection conn=null;
		try {
			conn= DriverManager.getConnection(url, uname, pwd);
			System.out.println("Connection Sucessfull "+conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not connect to DB-"+e);
		}
		return conn;
	}
	public static void deleteRowById(Connection conn, int id) throws SQLException 
	{
		Statement stmt=null;
		try {
			 stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Statement not found!!");
			
		}
		
		String str = "delete from product where _id="+id;
		
		stmt.executeUpdate(str);
		
		
		
	}
}
