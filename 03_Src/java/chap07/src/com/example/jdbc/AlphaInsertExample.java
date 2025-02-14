package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import util.Color;

public class AlphaInsertExample {

	public static void main(String[] args) throws SQLException {
		// 예외처리 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url, user, password);
		conn.setAutoCommit(false);	
		// commit 전까지는 insert가 성공하더라도 db에 저장은 되지 않는다. 
		
		Statement stmt = conn.createStatement();
		stmt.execute("truncate table alpha");
		
		Random r = new Random();
		PreparedStatement pstmt = conn.prepareStatement(
						"insert into alpha values (?, ?, ?, ?, ?, ? )");	// place holder 
		
		for (int i=0; i<800; i++) {
			int no = i;
			int line = r.nextInt(1, 21);
			int column = r.nextInt(1, 21);
			Color fg = Color.values()[r.nextInt(8)]; 
			Color bg = Color.values()[r.nextInt(8)]; 
			char ch = (char)r.nextInt('A', 'Z'+1);
			
			pstmt.setInt(1, no);
			pstmt.setInt(2, line);
			pstmt.setInt(3, column);
			pstmt.setString(4, fg.toString());
			pstmt.setString(5, bg.toString());
			pstmt.setString(6, ch+"");	
			// primitive type을 문자열로 변환 할 때는 (+ " ") 사용.
			pstmt.executeUpdate(); 
			// 	변경사항 업데이트 executeUpdate() 
		}
		
		
		conn.commit(); 	
		// save 
		// commit의 반대는 rollback
		
		System.out.println("Program end...");

	}

}
