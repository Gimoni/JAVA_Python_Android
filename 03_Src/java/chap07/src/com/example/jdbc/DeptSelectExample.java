package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeptSelectExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Class.forName("oracle.jdbc.OracleDriver");
		// sqlplus scott/tiger 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		Statement stmt =  conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from dept");
		
		rs.next();
		
//		int deptno = rs.getInt(1);
		int deptno = rs.getInt("deptno");
		String dname = rs.getString("dname"); 
		String loc = rs.getString("loc"); 
		
		System.out.printf("%4d %10s %10s\n", deptno, dname, loc);
		
		
		
		
		System.out.println("Program End...");
	
	}

}
