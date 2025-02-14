package com.example.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.mapper.AlphaMapper;

import util.Alpha;
import util.Oracle;
import util.VT100;

public class AlphaController4 {

	public static void main(String[] args) throws SQLException {
		VT100.reset();
		VT100.clearScreen();
		
		Connection conn = Oracle.getInstance();
		conn.setAutoCommit(false);
		
		AlphaMapper mapper = new AlphaMapper(conn);
		
		mapper.deleteAll();
		
		int insertCount = 0;
		int updateCount = 0;
		
		for (int i=0;;i++) {
			Alpha a = new Alpha();
			a.setNo(i);
			
			int rows = mapper.selectCountByLineColumn(a.getLine(), a.getColumn());
			if (rows==0) {
				// insert
				mapper.insertAlpha(a);
				insertCount++;
				VT100.cursorMove(1, 1);
				VT100.print(String.format("insertCount = %04d", insertCount));
			} else {
				// update
				mapper.updateAlphaByLineColumn(a);
				updateCount++;
				VT100.cursorMove(2, 1);
				VT100.print(String.format("updateCount = %04d", updateCount));
			}
			
			int count = mapper.selectCountAll();
			if (count==800)
				break;

//			System.out.println(a);
		}
		
		Alpha[] alphas = mapper.selectAll("line, col");
		Alpha[] alphas2 = mapper.selectAll("line, col desc");
		Alpha[] alphas3 = mapper.selectAll("col, line");
		Alpha[] alphas4 = mapper.selectAll("col desc, line desc");
		view(alphas, 3, 1);
		view(alphas2, 3, 45);
		view(alphas3, 24, 1);
		view(alphas4, 24, 45);
		
		
		
		
//		for (var a : alphas)
//			System.out.println(a);
		
		
		conn.commit();
		conn.close();
		
		System.out.println("End...");

	}
	
	static void view(Alpha[] alphas, int offLine, int offColumn) {
		for (var a : alphas) {
			VT100.cursorMove(a.getLine() + offLine-1, a.getColumn() + offColumn-1);
			VT100.setForeground(a.getFg());
			VT100.setBackground(a.getBg());
			VT100.print(a.getCh());
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
