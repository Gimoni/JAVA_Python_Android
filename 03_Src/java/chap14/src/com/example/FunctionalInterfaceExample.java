package com.example;

public class FunctionalInterfaceExample {
	/* 모든 인터페이스는 익명 구현 객체로 표현 가능하다.
	 * 함수형 인터페이스 만 람다식으로 표현 가능하다. 
	 * 
	 */
	
	@FunctionalInterface
	interface Checkable {	// 함수형 인터페이스 
		boolean check(int i, int j);
//		void show();
	}
	
	public static void main(String[] args) {
		Checkable c = new Checkable() {
			
			@Override
			public boolean check(int i, int j) {
				return false;
			}
		};
		
		Checkable c2 = (i, j) -> true;
		Checkable c3 = (i, j) -> {return true;};
		Checkable c4 = (int i, int j) -> i>=j;
		
		Runnable r = () -> {};
	}
	
	
}
