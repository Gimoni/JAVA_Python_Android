package com.example.imple.dept.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class DeptDTO {
	@NotNull 
	@Range(min= 10, max =99)
	Integer deptno;
	
	@NotBlank
	@Length(min = 1, max = 14)
	String dname;
	
	@Length(min = 1, max = 13)
	String loc;
	
	public Dept getModel() {
		return Dept.builder()
				   .deptno(deptno)
				   .dname(dname.trim())
				   .loc(loc)
				   .build();
	}
}
