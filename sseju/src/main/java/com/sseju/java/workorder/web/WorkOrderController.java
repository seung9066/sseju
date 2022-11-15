package com.sseju.java.workorder.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sseju.java.workorder.serivce.WorkOrderService;
import com.sseju.java.workorder.serivce.WorkOrderVO;


@Controller
public class WorkOrderController {
	
	@Autowired
	WorkOrderService woService;
	
	//작업 지시 전체 조회 -페이지 연결만 해둠 기능X
	@GetMapping("/list")
	public String WorkOrderList(Model model) {
		//model.addAttribute("workOrderList", woService.getWorkOrderList());
		return "workOrder/workOrderList";
	}
	
	//작업 지시 등록 폼
	@GetMapping("/insertForm")
	public String insertForm() {
		return "workOrder/insertForm";
	}
	//작업 지시 DB 등록
	@PostMapping("/insert")
	public String insertWorkOrder(WorkOrderVO woVO, Model model) {
		try {
			int result = woService.insertWorkOrder(woVO);
			if(result > 0) {
				return "workOrder/workOrderList";
			}else {
				model.addAttribute("msg", "작업 지시 등록에 실패했습니다.");
				return "workOrder/insertForm";
			}
		}catch(Exception e) {
			model.addAttribute("msg", "작업 지시 등록 실패");
			return "workOrder/insertForm";
		}
	}
	
	@PostMapping("/update")
	public String updateWorkOrder(WorkOrderVO woVO, Model model) {
		model.addAttribute("workOrderList", woService.getWorkOrderList());
		return "workOrder/list";
	}
	
	@PostMapping("/delete")
	public String deleteWorkOrder(@RequestParam int preNo, Model model) {
		model.addAttribute("workOrderList", woService.deleteWorkOrder(preNo));
		return "workOrder/list";
	}
}
