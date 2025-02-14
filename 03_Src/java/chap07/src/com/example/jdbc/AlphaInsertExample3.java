package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import util.Color;
import util.VT100;

public class AlphaInsertExample3 {

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
		
		VT100.reset();
		VT100.clearScreen();
		
		Random r = new Random();
		PreparedStatement pstmt = conn.prepareStatement(
						"insert into alpha values (?, ?, ?, ?, ?, ? )");	// place holder 
		
		int no = 0;
		for (;;) {
			int line = r.nextInt(1, 21);
			int column = r.nextInt(1, 41);
			Color fg;
			Color bg;
			do {
				fg = Color.values()[r.nextInt(8)]; 
				bg = Color.values()[r.nextInt(8)]; 
			} while (fg==bg);
			char ch = (char)r.nextInt('A', 'Z'+1);
			
			VT100.cursorMove(line, column);
			VT100.setForeground(fg);
			VT100.setBackground(bg);
			System.out.print(ch);
			
			pstmt.setInt(1, no++);
			pstmt.setInt(2, line);
			pstmt.setInt(3, column);
			pstmt.setString(4, fg.toString());
			pstmt.setString(5, bg.toString());
			pstmt.setString(6, ch+"");	
			// primitive type을 문자열로 변환 할 때는 (+ " ") 사용.
			pstmt.executeUpdate(); 
			// 	변경사항 업데이트 executeUpdate() 
			
			// 쿼리 복사 붙여넣기 / 멀티라인 사용. 
			ResultSet rs = stmt.executeQuery(
					"""
						with duple as (
							select distinct line, col
							from alpha
						)
						select count(*) from duple	
					"""
					);
			rs.next();
			int count = rs.getInt(1);
			System.out.println();
			if (count==800)
				break;
		}
		
		
		
		
		conn.commit(); 	
		// save 
		// commit의 반대는 rollback
		VT100.reset();
		VT100.cursorMove(21, 1);
		System.out.println("Program end...");

	}

}
