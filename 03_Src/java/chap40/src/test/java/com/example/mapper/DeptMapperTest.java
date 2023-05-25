package com.example.mapper;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class DeptMapperTest {

	@Autowired
	DeptMapper deptMapper;
	
	@Autowired 
	ObjectMapper objectMapper;
	
	@Test
	void selectAll() throws IOException {
		var list = deptMapper.selectAll();
		
		System.out.println(list);
		objectMapper.createGenerator(System.out)
					.useDefaultPrettyPrinter()
					.writeObject(list);
	}
	
	@Test
	void selectDeptno() {
		var dept = deptMapper.selectByDeptno(10);
		System.out.println(dept);
		assertSame(10, dept.getDeptno());
		
		dept = deptMapper.selectByDeptno(90);
		System.out.println(dept);
		assertNull(dept);
	}
	
	@Test
	@Transactional
	void insert() {
		deptMapper.insert(50, "개발부","부산");
		System.out.println(deptMapper.selectByDeptno(50));
		
		deptMapper.insert(60, "개발2부", null);
		System.out.println(deptMapper.selectByDeptno(60));
		
		try {
			deptMapper.insert(50, "개발3부", "서울");
		} catch (Exception e) {
			System.out.println("50번 부서는 사용할 수 없습니다. 이미 사용중. ");
		}
		
		try {
			deptMapper.insert(70, null, null);			
		} catch (DataIntegrityViolationException e) {
			System.out.println(e.getMessage());
		}
		
		assertThrows(DataIntegrityViolationException.class, () ->{
			deptMapper.insert(100, "총무부", null);
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
