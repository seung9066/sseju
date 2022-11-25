package com.sseju.java.workorder.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		model.addAttribute("idName", woService.getWoEmpList());
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
	
	//사원이름, 아이디 가져오기
	@GetMapping("/getWoEmpList")
	@ResponseBody
	public List<WorkOrderVO> getWoEmpList(){
		return woService.getWoEmpList();
	}
	
	//지시 등록
	@PostMapping("/insertWorkOrder")
	public String insertWorkOrder(WorkOrderVO woVO, Model model) {
		woService.insertWorkOrder(woVO);
		woService.updateOrderYn(woVO);
		return "redirect:workOrder";
	}
	
	//작업 지시 수정
	@PostMapping("/updateWorkOrder")
	@ResponseBody
	public int updateWorkOrder(@RequestBody WorkOrderVO woVO) {
		return woService.updateWorkOrder(woVO);
	}
	
	//작업 지시 삭제
	@PostMapping("/selectDeleteWO")
	@ResponseBody
	public int deleteWorkOrder(@RequestParam(value="deleteWorkOrder[]", 
								required=false) List<String> deleteWorkOrder, 
			@RequestParam(value="deleteOrder[]", required=false) List<String> deleteOrder				
			,@RequestParam(value="deleteCode[]", required=false) List<String> deleteCode
							) {
		int res = 0;
		for(int i=0; i<deleteWorkOrder.size(); i++) {
			String line = deleteWorkOrder.get(i);
			WorkOrderVO woVO = new WorkOrderVO();
			woVO.setPreNo(line);
			
			line = deleteOrder.get(i);
			woVO.setOrderNo(line);
			res += woService.deleteWorkOrder(woVO);
			//지시 칸에서 삭제되어 반환값이 들어오면 updateorderyn이 실행되면서 주문칸에 다시 값이 들어가게
			line = deleteCode.get(i);
			woVO.setPrtCode(line);
			
			woService.updateOrderYn(woVO);
			
		}
		return res;
	}
	
	//주문 신청 내역 그리드의 행 삭제
	@PostMapping("/selectDeleteOrder")
	@ResponseBody
	public int deleteOrder(@RequestParam(value="deleteOrder[]",
							required = false) List<String> deleteOrder) {
		int res = 0;
		for(int i=0; i<deleteOrder.size(); i++) {
			String line = deleteOrder.get(i);
			WorkOrderVO woVO = new WorkOrderVO();
			woVO.setOrderNo(line);
			res += woService.deleteOrder(woVO);
		}
		return res;
	}
}
