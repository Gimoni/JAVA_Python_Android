package com.example.alpha;
/*
 * 작성자 : 손진희
 * 작성일 : 023/04/11
 * 과목 : 데이터 베이스
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

import util.Color;
import util.VT100;

public class AlphaSortExample {

	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "scott";
	static String password = "tiger";
	
	static Connection conn;
	
	static Random r = new Random();
	
	static class Alpha {
		
		int line; 
		int column;
		Color fg;
		Color bg;
		char ch;
		
		public Alpha() {
			line = r.nextInt(1, 21);
			column = r.nextInt(1, 21);
			do {
				fg = Color.values()[r.nextInt(8)];
				bg = Color.values()[r.nextInt(8)];
			}while (fg==bg);
			ch = (char)r.nextInt('A', 'Z'+1);
		}
		
	}
	
	
	static void p1(Color fg, Color bg, char ch) throws SQLException, InterruptedException {
		var stmt = conn.createStatement();
		var pSelect = conn.prepareStatement("""
					select count(*) 
					  from random
					 where no = ? 
				""");
		
		var pInsert = conn.prepareStatement("""
					insert into random values(?, 1) 
				""");
		
		var pUpdate = conn.prepareStatement("""
					update random
					   set cnt= (select cnt from random where no = ?) + 1 
					 where no = ? 
			""");
		
		var pDelete = conn.prepareStatement("""
				delete from random
		""");
		
		pDelete.executeUpdate();
		
		for (;;) {
			int sequence = r.nextInt(1, 1001);
			System.out.println(sequence);
			pSelect.setInt(1, sequence);
			
			var rs = pSelect.executeQuery("""	
							select * 
					  		  from alpha
					         order by line asc, col asc, fg asc, bg asc
					""");
			while(rs.next()){
				int line = rs.getInt("line");
				int column = rs.getInt("col");
				fg = Color.valueOf(rs.getString("fg"));
				bg = Color.valueOf(rs.getString("bg"));
				ch = rs.getString("ch").charAt(0);

				VT100.cursorMove(line+3, column);
				VT100.setForeground(fg);
				VT100.setBackground(bg);
				VT100.print(ch);
				
				Thread.sleep(1);
			}
			
			rs.close();
			stmt.close();
			
			if(rs.getInt(1)==0) {	// insert
				pInsert.setInt(1, sequence);
				pInsert.executeUpdate();
				} else {
					int line = r.nextInt(1, 21);
					int column = r.nextInt(1, 21);
					do {
						fg = Color.values()[r.nextInt(8)];
						bg = Color.values()[r.nextInt(8)];
					}while (fg==bg);
					ch = (char)r.nextInt('A', 'Z'+1);
			
				    pUpdate.setInt(1, r.nextInt(line));
				    pUpdate.setInt(2, r.nextInt(column));
				    pUpdate.setString(3, fg.toString());
				    pUpdate.setString(4, bg.toString());
				    pUpdate.setString(5, Character.toString(ch));
				    pUpdate.setInt(6, sequence);
				    pUpdate.executeUpdate();
		}
			
			var rs2 = stmt.executeQuery("select count(*) from random");
			rs2.next();
			int count = rs2.getInt(1);
			if (count==800) 
				break;
		
		}
		
	}
	
	
	static void p2() throws SQLException, InterruptedException {
		var stmt = conn.createStatement();
		var pSelect = conn.prepareStatement("""
					select count(*) 
					  from random
					 where no = ? 
				""");
		
		var pInsert = conn.prepareStatement("""
					insert into random values(?, 1) 
				""");
		
		var pUpdate = conn.prepareStatement("""
					update random
					   set cnt= (select cnt from random where no = ?) + 1 
					 where no = ? 
			""");
		
		var pDelete = conn.prepareStatement("""
				delete from random
		""");
		
		pDelete.executeUpdate();
		
		for (;;) {
			int sequence = r.nextInt(1, 1001);
			System.out.println(sequence);
			pSelect.setInt(1, sequence);
			
			var rs = pSelect.executeQuery("""	
					select * 
			  		  from alpha
			         order by line asc, col asc, fg asc, bg asc
			""");
			rs.next();
			
			if(rs.getInt(1)==0) {	// insert
					pInsert.setInt(1, sequence);
					pInsert.executeUpdate();
			} else {				// update
					pUpdate.setInt(1, sequence);
					pUpdate.setInt(2, sequence);
					pUpdate.executeUpdate();
			}
			
			var rs2 = stmt.executeQuery("select count(*) from random");
			rs2.next();
			int count = rs2.getInt(1);
			if (count==800) 
				break;
		
		}
	}
	static void p3() throws SQLException, InterruptedException {
		var stmt = conn.createStatement();
		var pSelect = conn.prepareStatement("""
					select count(*) 
					  from random
					 where no = ? 
				""");
		
		var pInsert = conn.prepareStatement("""
					insert into random values(?, 1) 
				""");
		
		var pUpdate = conn.prepareStatement("""
					update random
					   set cnt= (select cnt from random where no = ?) + 1 
					 where no = ? 
			""");
		
		var pDelete = conn.prepareStatement("""
				delete from random
		""");
		
		pDelete.executeUpdate();
		
		for (;;) {
			int sequence = r.nextInt(1, 1001);
			System.out.println(sequence);
			pSelect.setInt(1, sequence);
			
			var rs = pSelect.executeQuery("""	
					select * 
			  		  from alpha
			         order by line asc, col asc, fg asc, bg asc
			""");
			rs.next();
			
			if(rs.getInt(1)==0) {	// insert
					pInsert.setInt(1, sequence);
					pInsert.executeUpdate();
			} else {				// update
					pUpdate.setInt(1, sequence);
					pUpdate.setInt(2, sequence);
					pUpdate.executeUpdate();
			}
			
			var rs2 = stmt.executeQuery("select count(*) from random");
			rs2.next();
			int count = rs2.getInt(1);
			if (count==800) 
				break;
		
		}
	}
	static void p4() throws SQLException, InterruptedException {
		var stmt = conn.createStatement();
		var pSelect = conn.prepareStatement("""
					select count(*) 
					  from random
					 where no = ? 
				""");
		
		var pInsert = conn.prepareStatement("""
					insert into random values(?, ?, ?, ?, ?, ?) 
				""");
		
		var pUpdate = conn.prepareStatement("""
					update random
					   set cnt= (select cnt from random where no = ?) + 1 
					 where no = ? 
			""");
		
		var pDelete = conn.prepareStatement("""
				delete from random
		""");
		
		pDelete.executeUpdate();
		
		for (;;) {
			int sequence = r.nextInt(1, 1001);
			System.out.println(sequence);
			pSelect.setInt(1, sequence);
			
			var rs = pSelect.executeQuery("""	
					select * 
			  		  from alpha
			         order by line asc, col asc, fg asc, bg asc
			""");
			rs.next();
			
			if(rs.getInt(1)==0) {	// insert
					pInsert.setInt(1, sequence);
					pInsert.executeUpdate();
			} else {				// update
					pUpdate.setInt(1, sequence);
					pUpdate.setInt(2, sequence);
					pUpdate.executeUpdate();
			}
			
			var rs2 = stmt.executeQuery("select count(*) from random");
			rs2.next();
			int count = rs2.getInt(1);
			if (count==800) 
				break;
		
		}
	}
	
	public static void main(String[] args) throws SQLException, InterruptedException {
		VT100.reset();
		VT100.clearScreen();
		conn = DriverManager.getConnection(url, user, password);
		
		conn.setAutoCommit(false);
		
		var r = new Random();
		var a = new Alpha();
		
		var stmt = conn.createStatement();
		
		var pSelect = conn.prepareStatement("""
				select count(*) 
				  from random
				 where no = ? 
			""");
	
		var pInsert = conn.prepareStatement("""
					insert into random values(?, ?, ?, ?, ?, ?) 
				""");
		
		var pUpdate = conn.prepareStatement("""
					update random
					   set cnt= (select cnt from random where no = ?) + 1 
					 where no = ? 
			""");
		
		var pDelete = conn.prepareStatement("""
				delete from random
		""");
		
		pDelete.executeUpdate();
		
		int no = r.nextInt(1, 1000);
		for (;;) {
//			System.out.println(sequence);
//			pSelect.setInt(1, a.line);
//			pSelect.setInt(2, a.column);
		
			
			var rs = pSelect.executeQuery("""	
							select * 
					  		  from alpha
					         order by line asc, col asc, fg asc, bg asc
					""");
			while(rs.next()){
				a.line = rs.getInt("line");
				a.column = rs.getInt("col");
				a.fg = Color.valueOf(rs.getString("fg"));
				a.bg = Color.valueOf(rs.getString("bg"));
				a.ch = rs.getString("ch").charAt(0);
	
				VT100.cursorMove(a.line+3, a.column);
				VT100.setForeground(a.fg);
				VT100.setBackground(a.bg);
				VT100.print(a.ch);
				
				Thread.sleep(1);
			}
			
			rs.close();
			stmt.close();
			
			rs.next();

			int count = rs.getInt(1);
			if(count==0) {	// insert
				pInsert.setInt(1, no++);
			    pInsert.setInt(2, r.nextInt(a.line));
			    pInsert.setInt(3, r.nextInt(a.column));
			    pInsert.setString(4, a.fg.toString());
			    pInsert.setString(5, a.bg.toString());
			    pInsert.setString(6, Character.toString(a.ch));
				pInsert.executeUpdate();
				} else {
					a.line = r.nextInt(1, 21);
					a.column = r.nextInt(1, 21);
					do {
						a.fg = Color.values()[r.nextInt(8)];
						a.bg = Color.values()[r.nextInt(8)];
					}while (a.fg==a.bg);
					a.ch = (char)r.nextInt('A', 'Z'+1);
			
					pUpdate.setInt(1, no++);
				    pUpdate.setInt(2, r.nextInt(a.line));
				    pUpdate.setInt(3, r.nextInt(a.column));
				    pUpdate.setString(4, a.fg.toString());
				    pUpdate.setString(5, a.bg.toString());
				    pUpdate.setString(6, Character.toString(a.ch));
				    pUpdate.executeUpdate();
		}
			
			var rs2 = stmt.executeQuery("""	
					select * 
			  		  from alpha
			         order by line asc, col asc, fg asc, bg asc
			""");
			while(rs2.next()){
				a.line = rs.getInt("line");
				a.column = rs.getInt("col");
				a.fg = Color.valueOf(rs.getString("fg"));
				a.bg = Color.valueOf(rs.getString("bg"));
				a.ch = rs.getString("ch").charAt(0);
	
				VT100.cursorMove(a.line+3, a.column + 45);
				VT100.setForeground(a.fg);
				VT100.setBackground(a.bg);
				VT100.print(a.ch);
				
				Thread.sleep(1);
			}
			
			rs2.close();
			stmt.close();
			rs2.next();
			
			var rs3 = stmt.executeQuery("""	
					select * 
			  		  from alpha
			         order by line asc, col asc, fg asc, bg asc
			""");
			while(rs3.next()){
				a.line = rs.getInt("line");
				a.column = rs.getInt("col");
				a.fg = Color.valueOf(rs.getString("fg"));
				a.bg = Color.valueOf(rs.getString("bg"));
				a.ch = rs.getString("ch").charAt(0);
	
				VT100.cursorMove(a.line+25, a.column);
				VT100.setForeground(a.fg);
				VT100.setBackground(a.bg);
				VT100.print(a.ch);
				
				Thread.sleep(1);
			}
			
			rs3.close();
			stmt.close();
			rs3.next();
			
			var rs4 = stmt.executeQuery("""	
					select * 
			  		  from alpha
			         order by line asc, col asc, fg asc, bg asc
			""");
			while(rs4.next()){
				a.line = rs.getInt("line");
				a.column = rs.getInt("col");
				a.fg = Color.valueOf(rs.getString("fg"));
				a.bg = Color.valueOf(rs.getString("bg"));
				a.ch = rs.getString("ch").charAt(0);
	
				VT100.cursorMove(a.line+25, a.column + 45);
				VT100.setForeground(a.fg);
				VT100.setBackground(a.bg);
				VT100.print(a.ch);
				
				Thread.sleep(1);
			}
			
			rs4.close();
			stmt.close();
			rs4.next();
			
			if (count==800) 
				break;
		
		}
			
		
	
		conn.commit();
		conn.close();

		VT100.reset();
		VT100.cursorMove(45, 1);
		System.out.println("Program End.. I do not know about my code at all.. ");

	}

}


