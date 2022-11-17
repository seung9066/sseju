package com.sseju.java.mat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sseju.java.mat.service.MatService;

@Controller
public class MatController {
	
	@Autowired
	MatService service;
	
	
	@RequestMapping("/matOrd")
	public String matOrd(Model model) {
		model.addAttribute("matordList", service.matBuyList());
		return "/admin/mat/matOrd";
	}
	
	@RequestMapping("/matInout")
	public String ex() {
		return "/admin/mat/matInout";
	}
	
	@RequestMapping("/matStock")
	public String matt() {
		return "/admin/mat/matStock";
	}
	
	@RequestMapping("/matCheck")
	public String hh() {
		return "/admin/mat/matCheck";
	}
	
	@RequestMapping("/exex")
	public String exex() {
		return "/admin/mat/exex";
	}
}
