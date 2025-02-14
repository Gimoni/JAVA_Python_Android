package com.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifeCycleTest {

	
	public LifeCycleTest() {
		System.out.println("## LifeCycleTest....");
	}
	
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("# beforeAll()..");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("# afterAll()..");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("## beforeEach()...");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("## afterEach()...");
	}	
	
	
	@Test
	void test1() {
		System.out.println("@test1 ...");
	}
	
	@Test
	void test2() {
		System.out.println("@test2 ...");
	}

}
