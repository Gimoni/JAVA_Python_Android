package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Dept;

@SpringBootApplication
public class Chap30Application {

	public static void main(String[] args) {
		SpringApplication.run(Chap30Application.class, args);
		
		Dept dept = new Dept();
		
		dept.setDeptno(70);
		dept.setDname("개발부");
		dept.setLoc("부산 ");
		
		System.out.println(dept);
	}

}
