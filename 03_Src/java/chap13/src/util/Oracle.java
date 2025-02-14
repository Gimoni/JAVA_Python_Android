package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Oracle {
	static String url;
	static String user;
	static String password;
	
	static {
		Properties db = new Properties();
		try {
			db.load(Oracle.class.getResourceAsStream("db.properties"));
			url = db.getProperty("url");
			user = db.getProperty("user");
			password = db.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Oracle() {
		
	}
	
	public static Connection getInstance() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
