package com.example.imple.country.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@SpringBootTest
public class CountryMapperTest {
	
	@Autowired
	CountryMapper countryMapper;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test 
	void countAll() {
		var cnt = countryMapper.countAll();
//		System.out.println(cnt);
		assertThat(cnt).isEqualTo(239);
	}
	
	@Test 
	void selectCitys() {
		var list = countryMapper.selectCitys("KOR");
		assertThat(list).isNotNull();
		assertThat(list.size()).isEqualTo(70);
		
		list = countryMapper.selectCitys("XXX");
		assertThat(list).isNotNull();
		assertThat(list).isEmpty();
	}
	
	@Test
	void selectAll() {
		var list = countryMapper.selectAll();
		assertThat(list.size()).isEqualTo(239);
		
		assertThat(list).allSatisfy(e -> {
			assertThat(e.getCitys()).isNull();
		});
	}
	
	@Test
	void selectAllWithCitys() {
		var list = countryMapper.selectAllWithCitys();
		assertThat(list.size()).isEqualTo(239);
		
		assertThat(list).allSatisfy(e -> {
			assertThat(e.getCitys()).isNotNull();
			if (e.getCitys().size()==0) {
				System.out.println(e);
			}
		});
	}

	@Test
	void selectPage( ) throws IOException {
		PageHelper.startPage(1, 5);
		PageHelper.orderBy("code desc");
		var list = countryMapper.selectPage();
		var paging = PageInfo.of(list); 
		paging.setList(null);
		objectMapper.createGenerator(System.out)
					.writeObject(paging);
	}
	
	@Test
	void selectPageWithCitys() throws IOException {
		PageHelper.startPage(1, 10);
		PageHelper.orderBy("code desc");
		var list = countryMapper.selectPageWithCitys();
		var paging = PageInfo.of(list);
		paging.setList(null);
		objectMapper.createGenerator(System.out)
					.writeObject(paging);
	}
	
	@Test 
	void selectByCode() {
		var country = countryMapper.selectByCode("aus");
		assertThat(country).isNotNull();
		
		country = countryMapper.selectByCode("koR");
		assertThat(country).isNotNull();
		
		country = countryMapper.selectByCode("Jpn");
		assertThat(country).isNotNull();
	}
	
	@Test 
	void selectByCodeWithCitys() {
		var country = countryMapper.selectByCodeWithCitys("kor");
		assertThat(country).isNotNull();
		assertThat(country.getCitys()).isNotEmpty();
		
		country = countryMapper.selectByCodeWithCitys("auS");
		assertThat(country).isNotNull();
		assertThat(country.getCitys()).isNotEmpty();
		
		country = countryMapper.selectByCodeWithCitys("jpN");
		assertThat(country).isNotNull();
		assertThat(country.getCitys()).isNotEmpty();
	}
}
