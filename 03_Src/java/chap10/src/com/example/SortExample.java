package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import util.Color;

public class SortExample {

	static Random r = new Random();
	
	static class Alpha {
		int line;
		int column;
		Color fg;
		Color bg;
		char ch;
		
		public Alpha() {
			line = r.nextInt(1, 11);
			column = r.nextInt(1, 11);
			do {
				fg = Color.values()[r.nextInt(8)];
				bg = Color.values()[r.nextInt(8)];
			} while (fg==bg);
			ch = (char)r.nextInt('A', 'Z'+1);
		}
		
		//Override 
		public String toString() {
			return String.format("(%2d,%2d,%7s,%7s,'%c')", line, column, fg, bg, ch);
		}
	}
	
	static class Order implements Comparator<Alpha>{

		@Override
		public int compare(Alpha o1, Alpha o2) {
			int rtn = 0;
			if (o1.line > o2.line)
				rtn = 1;
			else if (o1.line==o2.line) {
				rtn = o1.column-o2.column;
				rtn = -rtn;
			} else
				rtn = -1;
			
			return rtn;
		}

		
	}
	
	static class Order2 implements Comparator<Alpha>{

		@Override
		public int compare(Alpha o1, Alpha o2) {
			return o1.fg.ordinal() - o2.fg.ordinal();
		}
		
	}
	
	public static void main(String[] args) {
		
		Alpha[] alphas = new Alpha[10];
		for (int i=0; i<alphas.length; i++) {
			alphas[i] = new Alpha();
		}
		
		System.out.println(alphas);
		
		Arrays.sort(alphas, new Order2());
		
		for (var a: alphas) {
			System.out.println(a);
		}
		
		
		
	}
	
	public static void main3(String[] args) {
		
		Alpha[] alphas = new Alpha[10];
		for (int i=0; i<alphas.length; i++) {
			alphas[i] = new Alpha();
		}
		
		System.out.println(alphas);
//		System.out.println(Arrays.toString(alphas));
		
		Arrays.sort(alphas, new Order());
		
		for (var a: alphas) {
			System.out.println(a);
		}
		
		
		
	}
	
	
	public static void main2(String[] args) {
		Random r = new Random();
		int[] nums = new int[10];
		
		for (int i=0; i<nums.length; i++) {
			nums[i] = r.nextInt(10);
		}
		System.out.println(nums);
		System.out.println(Arrays.toString(nums));		// 배열정렬 유틸리티 Arrays
		
		Arrays.sort(nums);		//  배열원소를 정렬. 
		System.out.println(Arrays.toString(nums));
		
	}

}
