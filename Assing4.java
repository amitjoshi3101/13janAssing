package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assing4 {

	public static void main(String[] args) throws SQLException {
		
      Connection c =makeConnection();
      showProducts(c);
		
	}
    
	public static Connection makeConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			System.out.println("Drive class not available in path");
		}
		String url_db = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pwd = "root";
		
		Connection con = null;
		try {
			 con = DriverManager.getConnection(url_db, uname, pwd);
			 System.out.println("Connection Successfull "+con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public static void showProducts(Connection con) throws SQLException
	{
		Statement stmt = con.createStatement();
		String sql = "select product_name, product_expiry from product ";
		
		ResultSet res = stmt.executeQuery(sql);
		
		while(res.next())
		{
			String name = res.getString("product_name");
			String date = res.getString("product_expiry");
			
			System.out.println(name+" "+date+" ");
		}
	}
}
