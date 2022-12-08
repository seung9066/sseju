package com.sseju.java.workhistory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.workhistory.service.WorkHistoryService;
import com.sseju.java.workhistory.service.WorkHistoryVO;

@Controller 
public class WorkHistoryController {
	@Autowired
	WorkHistoryService whService;
	
	//작업 이력 페이지 이동
	@GetMapping("/workHistory")
	public String workHistoryList() {
		return "admin/produce/workHistory";
	}
	@GetMapping("/getWorkHistoryList")
	@ResponseBody
	public List<WorkHistoryVO> getWorkHistoryList(){
		return whService.getWorkHistoryList();
	}
	
}
