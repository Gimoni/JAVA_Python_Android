package com.example.imple.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.imple.country.mapper.CountryMapper;
import com.example.standard.controller.PageableController;
import com.example.standard.controller.DetailController;
import com.example.standard.controller.ListController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/country")
public class CountryDetailController implements DetailController<String>{

	@Autowired
	CountryMapper countryMapper;
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public String detail(String key, Model model, HttpServletRequest request) {
		log.debug("key :{}", key);
		var country = countryMapper.selectByCode(key);
		model.addAttribute("country", country);
		
		return "country/detail";
	}
	

	

}
