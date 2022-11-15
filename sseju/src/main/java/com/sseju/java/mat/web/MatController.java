package com.sseju.java.mat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MatController {
	
	//@Autowired
	
	
	@RequestMapping("/mat")
	public String mat() {
		return "mat/mat";
	}
	
	@RequestMapping("/ex")
	public String ex() {
		return "mat/example";
	}
	
	@RequestMapping("/matt")
	public String matt() {
		return "mat/matt";
	}
}
