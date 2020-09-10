package connecter;

import java.sql.*;

public class ConnectionData {
	
	private static Connection con;
	
	private ConnectionData() {}
	
	public static ConnectionData getObj() {
		ConnectionData c = new ConnectionData();
		return c;
	}
	
	public static Connection getConObj() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","fanfrank","1234567");
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return con;
	}
}
