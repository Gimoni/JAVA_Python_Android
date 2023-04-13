package com.example;

public class DefaultMethodExample {

	interface A {
		// 상수 (public static final)
		// 추상메소드 (public abstract xxx()) 
		
		default void xxx() {
			System.out.println("xxx....");
		}
	}
	
	static class B implements A {
		
	}
	
	public static void main(String[] args) {
		
		B b = new B();
		
		b.xxx();
		
		
	}

}
