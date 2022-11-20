package com.sseju.java.processcheck.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProcessCheckController {

	@GetMapping("/processCheckList")
	public String processCheckList(Model model) {
		
		return "/admin/quamanage/processCheck";
	}
}
