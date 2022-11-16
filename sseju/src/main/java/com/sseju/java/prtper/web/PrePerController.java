package com.sseju.java.prtper.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//생산 실적 페이지 컨트롤러
@Controller
public class PrePerController {
	@GetMapping("/prtPer")
	public String prtPerList(Model model) {
		
		return "/admin/produce/prtPer"; 
	}
}
