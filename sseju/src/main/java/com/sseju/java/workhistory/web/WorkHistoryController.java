package com.sseju.java.workhistory.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class WorkHistoryController {
	@GetMapping("/workHistory")
	public String workHistoryList(Model model) {
		return "/admin/produce/workHistory";
	}
}
