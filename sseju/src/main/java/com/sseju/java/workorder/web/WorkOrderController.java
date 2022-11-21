package com.sseju.java.workorder.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.workorder.serivce.WorkOrderService;
import com.sseju.java.workorder.serivce.WorkOrderVO;


@Controller
public class WorkOrderController {
	
	@Autowired
	WorkOrderService woService;
	
	//작업 지시 전체 조회 -페이지 연결만 해둠 기능X
	@GetMapping("/workOrder")
	public String WorkOrderList() {
		//model.addAttribute("workOrderList", woService.getWorkOrderList());
		return "/admin/produce/workOrderList";
	}
	
	@PostMapping("/insertWorkOrder")
	@ResponseBody
	public String insertWorkOrder(WorkOrderVO woVO) {
		woService.insertWorkOrder(woVO);
		return "redirect:workOrderList";
	}
	
	@PostMapping("/updateWorkOrder")
	public String updateWorkOrder(WorkOrderVO woVO, Model model) {
		model.addAttribute("workOrderList", woService.getWorkOrderList());
		return "/admin/produce/workOrderList";
	}
	
	@PostMapping("/selectDeleteWO")
	public String deleteWorkOrder(WorkOrderVO woVO, Model model) {
		model.addAttribute("workOrderList", woService.deleteWorkOrder(woVO));
		return "/admin/produce/workOrderList";
	}
}
