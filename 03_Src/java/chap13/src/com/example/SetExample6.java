package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import util.Alpha;
import util.VT100;

public class SetExample6 {
	/*
	 * list는 생성순서에 맞게 출력..
	 * 
	 */
	
	static class SetAlpha extends Alpha implements Comparable<SetAlpha> {
		
		void show() {
			show(1, 1);
		}
		
		void show(int offLine, int offColumn) {
			VT100.cursorMove(line + offLine-1, column + offColumn-1);
			VT100.setForeground(fg);
			VT100.setBackground(bg);
			VT100.print(ch);
		}

		@Override
		public int compareTo(SetAlpha o) {
			//desc
			int rtn = o.line - this.line;
			if (rtn==0)
				rtn = o.column - this.column;
			return rtn;
		}
	}
	
	public static void main(String[] args) {
		VT100.reset();
		VT100.clearScreen();
		// set : TreeSet
		var set = new TreeSet<SetAlpha>();
		var list = new ArrayList<SetAlpha>();
		

		for(;;) {
			SetAlpha a = new SetAlpha();
			list.add(a);
			set.add(a);
			

			
			if (set.contains(a)) {
				set.remove(a);
			}
			
			set.add(a);
				
			if (set.size() == 800)
				break;
		}
		
		list.forEach(SetAlpha::show);
		
		// set 출력
		set.forEach(a -> {
			a.show(1, 42);
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		
		
		VT100.cursorMove(21, 1);
		System.out.println("End...");
	}
}
