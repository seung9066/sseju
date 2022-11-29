package com.sseju.java.processcheck.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.processcheck.service.ProcessCheckService;
import com.sseju.java.processcheck.service.ProcessCheckVO;

@Controller
public class ProcessCheckController {
	
	@Autowired
	ProcessCheckService pcService;
	//페이지 불러옴
	@GetMapping("/processCheckList")
	public String processCheckList(Model model) {
		return "/admin/quamanage/processCheck";
	}
	//ㄴ공정 조회 시 데이터 가져오기
	@GetMapping("/getProcessCheckList")
	@ResponseBody
	public List<ProcessCheckVO> getProcessCheckList(){
		return pcService.getProcessCheck();
	}
	//일자별 조회 버튼 클릭 이벤트(공정조회 - 일자별 검색 탭)
	@PostMapping("/prschkSearch")
	@ResponseBody
	public List<Map<String,Object>> prschkSearch(@RequestBody ProcessCheckVO pcVO){
		return pcService.clickDate(pcVO);
	}
}