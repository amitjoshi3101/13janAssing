package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assing1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pass = "root";

		Connection conn = DriverManager.getConnection(jdbc_url, uname, pass);
		System.out.println("Connection successfull"+conn);

		Statement stmt = conn.createStatement();
		Scanner sc = new Scanner(System.in);
		String[] spl = new String[5];
		while(true)
		{
			System.out.println("Enter the Product id,Product name,Product cost, product desc, product expiry date seperated by comma:");
			String str = sc.nextLine();
			
			spl=str.split(",");
			String sql = "insert into product values("+spl[0]+",'"+spl[1]+"',"+spl[2]+",'"+spl[3]+"','"+spl[4]+"')";
			stmt.executeUpdate(sql);

			System.out.println("Do you want to insert the product details:(Yes/No)");
			String s= sc.nextLine();
			if(s.equalsIgnoreCase("no"))
			{
				break;
			}
		}

	}

}
