package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Dept;

@SpringBootApplication
public class Chap31Application {

	public static void main(String[] args) {
		SpringApplication.run(Chap31Application.class, args);
		
		Dept dept = new Dept();
		
		dept.setDeptno(50);
		dept.setDname("영업부");
		dept.setLoc("경기");
	
		System.out.println(dept);
	}

}
