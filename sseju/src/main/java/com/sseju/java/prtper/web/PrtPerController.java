package com.sseju.java.prtper.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.prtper.service.PrtPerService;
import com.sseju.java.prtper.service.PrtPerVO;
//생산 실적 페이지 컨트롤러
@Controller
public class PrtPerController {
	
	@Autowired
	PrtPerService ppService;
	
	//생산 실적 등록 C
	@PostMapping("/insertPrtPer")
	public String insertPrtPer(PrtPerVO ppVO) {
		ppService.insertPrtPer(ppVO);
		return "admin/produce/prtPer";
	}
	//페이지 불러오기(리스트 출력 R)
	@GetMapping("/prtPer")
	public String prtPerList() {
		return "admin/produce/prtPer"; 
	}
//	ㄴ페이지에 지시 목록 가져오기
	@GetMapping("/getPrtPerList")
	@ResponseBody
	public List<PrtPerVO> getPrtPerList(){
		return ppService.getPrtPerList();
	}
	//ㄴ행클릭시 불량코드, 불량명, 상세조회 가져오기
	@GetMapping("/getErrList")
	@ResponseBody
	public List<PrtPerVO> getErrList(PrtPerVO ppVO){
		
		return ppService.getErrList(ppVO);
	}
}
