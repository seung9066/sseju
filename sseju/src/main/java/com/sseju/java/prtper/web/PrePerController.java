package com.sseju.java.prtper.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sseju.java.prtper.service.PrtPerService;
import com.sseju.java.prtper.service.PrtPerVO;
//생산 실적 페이지 컨트롤러
@Controller
public class PrePerController {
	
	@Autowired
	PrtPerService ppService;
	
	//생산 실적 등록 C
	@PostMapping("/insertPrtPer")
	public String insertPrtPer(PrtPerVO ppVO) {
		ppService.insertPrtPer(ppVO);
		return "/admin/produce/prtPer";
	}
	//페이지 불러오기(리스트 출력 R)
	@GetMapping("/prtPer")
	public String prtPerList(Model model) {
		
		return "/admin/produce/prtPer"; 
	}
	
	//생산 실적 삭제 D
//	@PostMapping("/deletePrtPer")
//	public String deletePrtPer() {
//		
//	}
}
