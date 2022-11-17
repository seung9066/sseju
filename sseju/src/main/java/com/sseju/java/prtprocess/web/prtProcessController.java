package com.sseju.java.prtprocess.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class prtProcessController {
	
	//생산 공저 페이지로 연결
	@GetMapping("/prtProcessList")
	public String prtProcessList(Model model) {
		return "/admin/produce/prtProcess";
	}
}
