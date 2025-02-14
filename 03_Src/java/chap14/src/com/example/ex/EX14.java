package com.example.ex;

public class EX14 {
	interface Max {
		int max(int a, int b);
	}
	
//	14-3 IntFunction
	
	public static void main(String[] args) {
		// 익명 구현 객체
		Max m1 = new Max() {
			
			@Override
			public int max(int a, int b) {
				return a >= b ? a : b;	//a가 b보다 크면 a를 리턴하고 작으면 b를 리턴
			}
		};
		
		// 람다식
		Max m2 = (a, b) -> a>=b ? a:b;
		
		System.out.println(m1.max(10, 20));
		System.out.println(m2.max(10, 20));
	}

}
