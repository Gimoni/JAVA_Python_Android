package com.example;

import java.util.Random;

import util.Alpha;

public class ObjectExample {

	static class A /*extends Object*/ { 
		
	}
	
	static class B extends A {
		
	}
	
	static class C extends B {
		
	}
	
	
	public static void main(String[] args) {
		// object 는 모든 타입을 줄수 있음 why? 모든 타입의 조상부모는 object이기 때문
		// 자바에서 모든 객체는 object로 명시 가능. 
		Object o1 = 10;
		Object o2 = 10.5;
		Object o3 = "Hello";
		Object o4 = new Alpha();
		Object o5 = new Random();
		
		A a = new A();
		B b = new B();
		C c = new C();
		
		
		Alpha alpha = new Alpha();
		
		System.out.println(alpha);
		
		
		
		
		
	}

}
