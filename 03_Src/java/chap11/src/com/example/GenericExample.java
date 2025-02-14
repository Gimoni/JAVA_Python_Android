package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import util.Alpha;

public class GenericExample {
	
	static class BoxString {
		String content;
	}
	
	static class BoxInteger {
		Integer content;
	}
	
	static class BoxDouble {
		Double content;
	}
	
	static class BoxBoolean {
		Boolean content;
	}
	
	static class Box<T> {
		T content;
	}
	
	
	
	public static void main(String[] args) {
		
		Box<String> box1;
		Box<Integer> box2;
		Box<Boolean> box3;
		Box<Random> box4;
		Box<System> box5;
		
		String[] strs = {"java", "python", "html"};
		int[] nums = {10, 30, 15};
		Alpha[] alpha = {new Alpha(), new Alpha(), new Alpha()};
		
		ArrayList<String> li1 = new ArrayList<String>();
		li1.add("jsp");
		li1.add("html");
		
		ArrayList<Integer> li2 = new ArrayList<>();
		li2.add(10);
		li2.add(20);
		li2.add(30);
		
		ArrayList<Alpha> li3 = new ArrayList<>();
		li3.add(new Alpha());
		li3.add(new Alpha());
		
		// comparator 비교기 // 제너릭 인터페이스 
		Comparator<String> c1 = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		};
		
		Comparator<Integer> c2 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}
		};

		Comparator<Alpha> c3 = new Comparator<Alpha>() {

			@Override
			public int compare(Alpha o1, Alpha o2) {
				return 0;
			}
		};
		
		
	}

}
