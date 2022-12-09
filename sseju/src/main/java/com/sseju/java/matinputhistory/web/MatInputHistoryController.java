package com.sseju.java.matinputhistory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.matinputhistory.service.MatInputHistoryService;
import com.sseju.java.matinputhistory.service.MatInputHistoryVO;

@Controller
public class MatInputHistoryController {
	@Autowired
	MatInputHistoryService mihService;
	//생산관리 - 자재 투입 내역 페이지로 이동
	@GetMapping("/matInputHistory")
	public String matInputHistory() {
		return "admin/produce/matInputHistory";
	}
	@GetMapping("/getmihList")
	@ResponseBody
	public List<MatInputHistoryVO> getmihList() {
		return mihService.getMatInputHistory();
	}
}
