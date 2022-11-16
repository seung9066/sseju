package com.sseju.java.matinputhistory.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatInputHistoryController {
	//생산관리 - 자재 투입 내역 페이지로 이동
	@GetMapping("/matInputHistory")
	public String matInputHistory(Model model) {
		return "/admin/produce/matInputHistory";
	}
}
