package com.example.imple.salgrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.imple.salgrade.mapper.SalgradeMapper;
import com.example.standard.controller.StandardController;

@Controller
@RequestMapping("/salgrade")
public class SalgradeController implements StandardController {

	@Autowired
	SalgradeMapper salgradeMapper;

	@Override
	public void list(Model model) {
		var list = salgradeMapper.selectAll();
	}

	@Override
	public String page(int pageNum, int pageSize, Model model) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
