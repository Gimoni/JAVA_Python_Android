package com.example.imple.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.imple.dept.mapper.DeptMapper;
import com.example.standard.controller.CreateController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/dept")
@Slf4j
public class DeptCreateController implements CreateController {

	@Autowired
	DeptMapper mapper;

	@Override
	public void create(Model model, HttpServletRequest request) {
		log.info("GET create()...");
		
	}

	@Override
	public String create(Model model, HttpServletRequest request, RedirectAttributes attr) {
		log.info("POST create()...");
		
		return "redirect:/dept/list";
	}


}
