package com.example.imple.salgrade.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.imple.emp.mapper.EmpMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.var;

@SpringBootTest
public class SalgradeMapperTest {

	@Autowired
	SalgradeMapper salgradeMapper;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void countSalgradeAll() {
		int cnt = salgradeMapper.countSalgradeAll();
	}
	
	@Test
	void selectSalgrade() {
		var list = salgradeMapper.selectSalgrade();
	}
	


}
	
	

