package com.example.imple.city.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.imple.city.model.City;
import com.example.imple.country.model.Country;
import com.example.imple.dept.model.Dept;
import com.github.pagehelper.Page;

@Mapper
public interface CityMapper {
	
	int countAll();

	Country selectCountry();
	List<City> selectAll();
	List<City> selectAllWithCountry();
	
	Page<City> selectPage();
	Page<City> selectPageWithCountry();
	
	City selectById(int id);
	City selectByIdWithCountry(int id);
	
	List<City> selectByCountryCode(String CountryCode);
	

	
//	@Select("select count(*) from city")
//	int countAll();
//	
//	@Results({
//		@Result(property = "countryCode", column= "country_code")
//	})
//	@Select("select * from city")
//	List<City> selectAll();
//	
//	@Results({
//		@Result(property="countryCode", column= "country_code")
//	})
//	@Select("select * from city")
//	Page<City> selectPage();
//	
//	@Results({
//		@Result(property = "countryCode", column = "country_code")
//	})
//	@Select("""
//			select * 
//			  from city
//			 where id = #{id}
//			""")
//	City selectById(@Param("id") int id);
//	
//	
//	@Results({
//		@Result(property = "countryCode", column = "country_code")
//	})	
//	@Select("""
//			select *
//			  from city
//			 where country_code =#{countryCode}
//			""")
//
//	List<City> selectByCountryCode(@Param("countryCode") String CountryCode);
}
