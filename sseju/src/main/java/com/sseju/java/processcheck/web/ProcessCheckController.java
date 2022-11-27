package com.sseju.java.processcheck.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.processcheck.service.ProcessCheckService;
import com.sseju.java.processcheck.service.ProcessCheckVO;

@Controller
public class ProcessCheckController {
	
	@Autowired
	ProcessCheckService pcService;
	
	@GetMapping("/processCheckList")
	public String processCheckList(Model model) {
		return "/admin/quamanage/processCheck";
	}
	
	@GetMapping("/getProcessCheckList")
	@ResponseBody
	public List<ProcessCheckVO> getProcessCheckList(){
		return pcService.getProcessCheck();
	}
}