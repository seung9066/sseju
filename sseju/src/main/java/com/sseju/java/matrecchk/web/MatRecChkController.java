package com.sseju.java.matrecchk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatRecChkController {
	@GetMapping("/matRecChk")
	public String matRecChk() {
		return "/admin/quamanage/matRecChk";
	}
}
	
