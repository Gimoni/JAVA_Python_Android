package com.example.mapper;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Dept;
import com.example.model.Emp;
import com.example.util.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class EmpMapperTest {
	
	@Autowired
	DeptMapper deptMapper;
	
	@Autowired
	EmpMapper empMapper;
	
	@Autowired
	ObjectMapper objectMapper;
	

	@Test
	void countAll() {
		int cnt = empMapper.countAll();
		System.out.println("cnt = "+cnt);
		assertThat(cnt).isSameAs(14);
	}
	
	@Test
	void selectAll() throws IOException {
		var list = empMapper.selectAll();
		System.out.println(list);
		assertThat(list.size()).isSameAs(14);
		
		objectMapper.createGenerator(System.out)
					.useDefaultPrettyPrinter()
					.writeObject(list);
	}
	
	@Test
	void selectByEmpno() {
		var emp = empMapper.selectByEmpno(1001);
		System.out.println(emp);
		assertEquals(1001, emp.getEmpno());
		assertThat(emp.getEmpno()).isEqualTo(1001);
		
		emp = empMapper.selectByEmpno(9000);
		System.out.println(emp);
		assertNull(emp);
		assertThat(emp).isNull();
	}
	
	@Test
	@Transactional
//	@Rollback(false)
	void insertByEmpnoWithEname() {
		empMapper.insertByEmpnoWithEname(9000, "홍길동");
		System.out.println(empMapper.selectByEmpno(9000));
		
		int cnt = empMapper.insertByEmpnoWithEname(9001, "홍길동");
		System.out.println("cnt = "+ cnt);
		assertEquals(1, cnt);
		
		assertThrows(DataIntegrityViolationException.class, () ->{
			empMapper.insertByEmpnoWithEname(9001, null);
		});

		assertThatThrownBy(()-> {
			empMapper.insertByEmpnoWithEname(9001, null);
		}).isInstanceOf(DataIntegrityViolationException.class);
		
		assertThrows(DuplicateKeyException.class,()-> {
			empMapper.insertByEmpnoWithEname(1001, "홍길동");
		});
	}
	
	
//	@Test
//	@Transactional
//	void insertDapt() throws IOException {
//		var dept = new Dept(50, "개발1부", "경기");
//		deptMapper.insertDept(dept);
//		
//		objectMapper.createGenerator(System.out)
//		.useDefaultPrettyPrinter()
//		.writeObject(deptMapper.selectByDeptno(50));
//
//	}	
	

//	@Test
//	@Transactional
//	void insertDapt() throws IOException {
//		var dept = new Dept(50, "개발1부", "경기");
//		deptMapper.insertDept(dept);
//		
//		dept = new Dept(60, "개발2부", null);
//		deptMapper.insertDept(dept);
//		
//		objectMapper.createGenerator(System.out)
//					.useDefaultPrettyPrinter()
//					.writeObject(deptMapper.selectAll());
//		
//	}	
	
	
	@Test
	@Transactional
	void insertEmp() throws IOException {
		var emp = new Emp();
		emp.setEmpno(9000);
		emp.setEname("홍길동");
		emp.setDeptno(10);
		int cnt = empMapper.insertEmp(emp);
		assertThat(cnt).isEqualTo(1);
		
		var emp2 = empMapper.selectByEmpno(9000);
		System.out.println(emp2);
		assertThat(emp).isEqualTo(emp2);
		
		emp = new Emp();
		emp.setEmpno(9100);
		emp.setEname("홍길동");
		emp.setGender(Gender.M);
		emp.setHiredate(LocalDate.now());
		empMapper.insertEmp(emp);
		
		emp2 = empMapper.selectByEmpno(9100);
		System.out.println(emp2);
		assertThat(emp).isEqualTo(emp2);
		
		emp = new Emp();
		emp.setEmpno(9200);
		emp.setEname("홍순이");
		emp.setGender(Gender.F);
		emp.setDeptno(10);
		empMapper.insertEmp(emp);
		
		assertThrows(DataIntegrityViolationException.class, ()->{
			var e = new Emp();
			e.setEmpno(9200);
			e.setEname("홍순이");
			e.setGender(Gender.F);
			e.setDeptno(50);
			empMapper.insertEmp(e);
		});
		
		// 입력한 데이터 출력해보기. 
		objectMapper.createGenerator(System.out)
		.useDefaultPrettyPrinter()
		.writeObject(empMapper.selectByEmpno(9000));
		
		objectMapper.createGenerator(System.out)
		.useDefaultPrettyPrinter()
		.writeObject(empMapper.selectByEmpno(9100));
		
		objectMapper.createGenerator(System.out)
		.useDefaultPrettyPrinter()
		.writeObject(empMapper.selectByEmpno(9200));
		
		
//		dept = new Dept(60, "개발2부", null);
//		cnt = deptMapper.insertDept(dept);
//		assertThat(cnt).isEqualTo(1);
//		
//		assertThrows(DuplicateKeyException.class, () -> {
//			deptMapper.insertDept(new Dept(60, "개발3부", null));
//		}); // DuplicateKeyException error를 확신하는 테스트 60번은 이미 존재함. 
//		
//		assertThrows(DataIntegrityViolationException.class, ()-> {
//			deptMapper.insertDept(new Dept(60, null, null));
//		}); // DataIntegrityViolationException error를 확신하는 테스트 dename에는 null이 올 수 없다
//		
//		assertThrows(DataIntegrityViolationException.class, ()->{
//			deptMapper.insertDept(new Dept(100, "개발4부", null));
//		});	// DataIntegrityViolationException을 error를 확신하는 테스트 dename에는 null이 올 수 없다
//		
//		objectMapper.createGenerator(System.out)
//		.useDefaultPrettyPrinter()
//		.writeObject(deptMapper.selectAll());
	}	
	
	@Test
	@Transactional
	void updateByEmpnoWithSal() throws IOException {
		int cnt = empMapper.updateByEmpnoWithSal(1001, 500.45);
		assertThat(cnt).isEqualTo(1);
		
		var emp = empMapper.selectByEmpno(1001);
		assertThat(emp.getSal()).isEqualTo(500.45);
		
		//
		cnt = empMapper.updateByEmpnoWithSal(1000, 1000);
		assertThat(cnt).isEqualTo(0);
		
		objectMapper.createGenerator(System.out)
					.useDefaultPrettyPrinter()
					.writeObject(empMapper.selectByEmpno(1001));
	}
	
	@Test
	@Transactional
	void updateByEmpnoWithDeptno() throws IOException {
		int cnt = empMapper.updateByEmpnoWithDeptno(1001, 40);
		assertThat(cnt).isEqualTo(1);
		
		var emp = empMapper.selectByEmpno(1001);
		assertThat(emp.getDeptno()).isEqualTo(40);
		
		cnt = empMapper.updateByEmpnoWithDeptno(1002, null);
		assertThat(cnt).isEqualTo(1);
		
		assertThrows(DataIntegrityViolationException.class, ()-> {
			empMapper.updateByEmpnoWithDeptno(1002, 90);
		});
		
		objectMapper.createGenerator(System.out)
					.useDefaultPrettyPrinter()
					.writeObject(empMapper.selectByEmpno(1001));
		
		objectMapper.createGenerator(System.out)
					.useDefaultPrettyPrinter()
					.writeObject(empMapper.selectByEmpno(1002));
	}
	
	
	
	@Test
	@Transactional
	void updateEmp() throws IOException {
		var emp = empMapper.selectByEmpno(1001);
		emp.setJob("developer");
		emp.setHiredate(LocalDate.now());
		emp.setDeptno(40);
		
		int cnt = empMapper.updateEmp(emp);
		assertThat(cnt).isEqualTo(1);
		
		objectMapper.createGenerator(System.out)
					.useDefaultPrettyPrinter()
					.writeObject(empMapper.selectByEmpno(1001));
	}
	
	
	@Test
	@Transactional
	void delete() throws IOException {
		int cnt = empMapper.delete(1001);
		assertThat(cnt).isEqualTo(1);
		
		objectMapper.createGenerator(System.out)
					.useDefaultPrettyPrinter()
					.writeObject(empMapper.selectByEmpno(1001));
	}

}
