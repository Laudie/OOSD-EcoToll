package application;
import java.sql.*;
public class MySqlConnection {
	
	public static Connection Connector() {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://51.75.200.121:3306/EcoToll?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","objsw","$obj!sw$");
			return conn;
			
		} catch(Exception e)
			{
			System.out.print(e);
			return null;
			}
	}
	
}
