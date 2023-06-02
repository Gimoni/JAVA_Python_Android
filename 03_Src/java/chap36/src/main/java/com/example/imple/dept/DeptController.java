package com.example.imple.dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.imple.dept.mapper.DeptMapper;
import com.example.standard.controller.StandardController;

@Controller
@RequestMapping("/dept")
public class DeptController implements StandardController{
	
	@Autowired
	DeptMapper mapper;
	
	@Override
	public void list(Model model) {
		var list = mapper.selectAllWithEmps();
		model.addAttribute("list", list);
	}

	@Override
	public String page(int pageNum, int pageSize, Model model) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@GetMapping("/list")
//	void list(Model model) {
//		model.addAttribute("list", mapper.selectAllWithEmps());	
//	}    /// StandardController interface create at StandardController..  
}
