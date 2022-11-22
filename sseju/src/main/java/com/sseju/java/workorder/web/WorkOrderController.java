package com.sseju.java.workorder.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String WorkOrderList(Model model) {
		//상품명, 코드 가져오기
		model.addAttribute("prt", woService.getPrtList());
		//사원명, 이름 가져오기
		model.addAttribute("idName", woService.getManagerList());
		//주문번호, 상품명, 주문수량, 주문일자 가져오기
		return "/admin/produce/workOrderList";
	}
	
    //지시 목록 가져옴
	@GetMapping("/getWorkOrderList")
	@ResponseBody
	public List<WorkOrderVO> getWorkOrderList(){
        return woService.getWorkOrderList();
     }
	
	//주문번호~일자, 상품명, 수량 가져오기
	@GetMapping("/getOrderList")
	@ResponseBody
	public List<WorkOrderVO> getOrderList(){
		return woService.getOrderList();
	}
	
	//지시 등록
	@PostMapping("/insertWorkOrder")
	@ResponseBody
	public String insertWorkOrder(WorkOrderVO woVO, Model model) {
		woService.insertWorkOrder(woVO);
		return "redirect:workOrder";
	}
	
	//작업 지시 삭제
	@PostMapping("/selectDeleteWO")
	@ResponseBody
	public int deleteWorkOrder(@RequestParam(value="deleteWorkOrder[]", required=false) List<String> deleteWorkOrder) {
		int res = 0;
		for(int i=0; i<deleteWorkOrder.size(); i++) {
			String line = deleteWorkOrder.get(i);
			System.out.println(line);
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
