package com.sseju.java.workorder.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.workorder.serivce.WorkOrderService;
import com.sseju.java.workorder.serivce.WorkOrderVO;


@Controller
public class WorkOrderController {
	
	@Autowired
	WorkOrderService woService;
	
	//작업 지시 페이지 띄움
	@GetMapping("/workOrder")
	public String WorkOrderList() {
		return "/admin/produce/workOrderList";
	}
	
    //지시 목록 가져옴
	@GetMapping("/getWorkOrderList")
	@ResponseBody
	public List<WorkOrderVO> getWorkOrderList(){
        return woService.getWorkOrderList();
     }
	   
	//지시 등록
	@PostMapping("/insertWorkOrder")
	@ResponseBody
	public String insertWorkOrder(WorkOrderVO woVO) {
		woService.insertWorkOrder(woVO);
		return "redirect:workOrderList";
	}
	
	@PostMapping("/deleteWorkOrder")
	@ResponseBody
	public int deleteWorkOrder(@RequestParam(value="deleteWorkOrder[]", required=false) List<String> deleteWorkOrder) {
		int res = 0;
		for(int i=0; i<deleteWorkOrder.size(); i++) {
			String line = deleteWorkOrder.get(i);
			
			WorkOrderVO woVO = new WorkOrderVO();
			woVO.setPreNo(line);
			
			res += woService.deleteWorkOrder(woVO);
		}
		return res;
	}
	
	
	/*
	 * @PostMapping("/selectDeleteWO") public String deleteWorkOrder(WorkOrderVO
	 * woVO, Model model) { model.addAttribute("workOrderList",
	 * woService.deleteWorkOrder(woVO)); return "/admin/produce/workOrderList"; }
	 */
}
