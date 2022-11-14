package com.sseju.java.workorder.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sseju.java.workorder.serivce.WorkOrderService;
import com.sseju.java.workorder.serivce.WorkOrderVO;


@Controller
@RequestMapping("workOrder")
public class WorkOrderController {
	
	@Autowired
	WorkOrderService woService;
	
	//작업 지시 등록 폼
	@GetMapping("insert")
	public String insertForm(Model model) {
		model.addAttribute("no", woService.getWoNo());
		return "workOrder/insertForm";
	}
	
	//DB에 작업지시 등록 입력
	@PostMapping("insert")
	public String insertWorkOrder(WorkOrderVO woVO, RedirectAttributes ratt) {
		Map<String, Object> result = woService.insertWorkOrder(woVO);
		ratt.addFlashAttribute("message", result.get("result") + "건이 등록되었습니다.");
		return "redirect:list";
	}
	
	//작업 지시 전체 조회
	@GetMapping("list") public String WorkOrderList(Model model) {
		model.addAttribute("workOrderList", woService.getWorkOrderList());
		return "workOrder/wordOrderList";
	}
	
}
