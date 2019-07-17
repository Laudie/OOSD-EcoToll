package application.model;
import java.sql.*;
public class mysqlConnection {
	
	public static Connection Connector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			Connection conn=DriverManager.getConnection("jdbc:mysql://51.75.200.121:3306/EcoToll"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
					+ "serverTimezone=UTC","objsw","$obj!sw$");
			//Usare questa connssione per tunnel con SSH
/*			
				Connection conn1 =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EcoToll"					
						+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
						+ "serverTimezone=UTC","objsw","$obj!sw$");
				return conn;
*/
			return conn;
		}catch(Exception e) {	
			System.out.println(e);
			return null;
		}
	}
	
	public mysqlConnection() {
		// TODO Auto-generated constructor stub
	}

}
