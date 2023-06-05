package com.example.standard.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

public interface CreateController {
	
	@GetMapping("/create")
	void create(Model model, HttpServletRequest request); 
	
	@PostMapping("/create")
	public String create(Model model, HttpServletRequest request, RedirectAttributes attr); 
}
