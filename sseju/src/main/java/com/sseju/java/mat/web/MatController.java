package com.sseju.java.mat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MatController {
	
	//@Autowired
	
	
	@RequestMapping("/matOrd")
	public String mat() {
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
