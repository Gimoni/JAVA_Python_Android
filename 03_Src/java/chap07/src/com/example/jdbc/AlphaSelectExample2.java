package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

import util.Color;
import util.VT100;

public class AlphaSelectExample2 {

	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "scott";
	static String password = "tiger";
	
	static Connection conn;
	
	// Refactoring 
	static void print1() throws SQLException {
		var stmt = conn.createStatement();
		
		var rs = stmt.executeQuery(
				"""
				
					select * 			
					  from alpha
					 order by no asc
				"""
				);
		
		while(rs.next()) {
			int line = rs.getInt("line");
			int column = rs.getInt("col");
			Color fg = Color.valueOf(rs.getString("fg"));
			Color bg = Color.valueOf(rs.getString("bg"));
			char ch = rs.getString("ch").charAt(0);
			
			VT100.cursorMove(line, column);
			VT100.setForeground(fg);
			VT100.setBackground(bg);
			VT100.print(ch);
			
		}
		
		rs.close(); // resource 종료. 
		stmt.close();
		
	}
	
//	static void print2() throws SQLException {
//		var stmt = conn.createStatement();
//		
//		var rs = stmt.executeQuery(
//				"""
//				
//					select * 			
//					  from alpha
//					 order by line 
//				"""
//				);
//		
//		while(rs.next()) {
//			int line = rs.getInt("line");
//			int column = rs.getInt("col");
//			Color fg = Color.valueOf(rs.getString("fg"));
//			Color bg = Color.valueOf(rs.getString("bg"));
//			char ch = rs.getString("ch").charAt(0);
//			
//			VT100.cursorMove(line, column);
//			VT100.setForeground(fg);
//			VT100.setBackground(bg);
//			VT100.print(ch);
//			
//		}
//		
//		rs.close(); // resource 종료. 
//		stmt.close();
//		
//	}
//	
//	static void print3() throws SQLException {
//		var stmt = conn.createStatement();
//		
//		var rs = stmt.executeQuery(
//				"""
//				
//					select * 			
//					  from alpha
//					 order by col 
//				"""
//				);
//		
//		while(rs.next()) {
//			int line = rs.getInt("line");
//			int column = rs.getInt("col");
//			Color fg = Color.valueOf(rs.getString("fg"));
//			Color bg = Color.valueOf(rs.getString("bg"));
//			char ch = rs.getString("ch").charAt(0);
//			
//			VT100.cursorMove(line, column);
//			VT100.setForeground(fg);
//			VT100.setBackground(bg);
//			VT100.print(ch);
//			
//		}
//		
//		rs.close(); // resource 종료. 
//		stmt.close();
//		
//	}
//	
//	static void print4() throws SQLException {
//		var stmt = conn.createStatement();
//		
//		var rs = stmt.executeQuery(
//				"""
//				
//					select * 			
//					  from alpha
//					 order by line desc
//				"""
//				);
//		
//		while(rs.next()) {
//			int line = rs.getInt("line");
//			int column = rs.getInt("col");
//			Color fg = Color.valueOf(rs.getString("fg"));
//			Color bg = Color.valueOf(rs.getString("bg"));
//			char ch = rs.getString("ch").charAt(0);
//			
//			VT100.cursorMove(line, column);
//			VT100.setForeground(fg);
//			VT100.setBackground(bg);
//			VT100.print(ch);
//			
//		}
//		
//		rs.close(); // resource 종료. 
//		stmt.close();
//		
//	}
	
	
	public static void main(String[] args) throws SQLException {
		
		VT100.reset();
		VT100.clearScreen();

		conn = DriverManager.getConnection(url, user, password);
		
		print1();
		
//		print2();
//		
//		print3();
//		
//		print4();
//		
		
		conn.close();	// connection 종료. 
		
		VT100.reset();
		VT100.cursorMove(21, 1);
		System.out.println("Program End...");
	}
}
