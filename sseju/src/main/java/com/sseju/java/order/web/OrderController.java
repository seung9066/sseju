package com.sseju.java.order.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.code.service.CodeService;
import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;
import com.sseju.java.order.service.ORService;
import com.sseju.java.order.service.ORVO;
import com.sseju.java.prt.service.PRService;

@Controller
public class OrderController {
	@Autowired
	ORService oService;

	@Autowired
	PRService prService;

	@Autowired
	CodeService serviceC;

	@Autowired
	CompanyService service;



	@GetMapping("/selectOrderList")
	@ResponseBody
	public List<ORVO> selectOrderList(Model model) {
		return oService.selectOrderList();
	}

	@GetMapping("/prtList")
	@ResponseBody
	public List<CompanyVO> cpList() {
		return service.getCompanyList();
	}
	@GetMapping("/selectOrdeIng")
	@ResponseBody
	public List<ORVO> selectOrdeIng() {
		return oService.selectOrdeIng();
	}
	@GetMapping("/selectPrtManager")
	@ResponseBody
	public List<ORVO> selectPrtManager() {
		return oService.selectPrtManager();
	}



//	// 제품목록 조회 서비스
//	@GetMapping("/insertPrtInfo")
//	@ResponseBody
//	public int insertPrtInfo(Model model) {
//		model.addAttribute("", )
//		return prService.insertPrtInfo(prvo);
//	}
//	

	// 전체
	@GetMapping("/orlist")
	public String OrderList(Model model) {

		return "/admin/order/orderList";
	}

	@GetMapping("prtlist")
	public String selecetprtList(Model model) {
		return "/admin/order/prtlist";
	}

	@GetMapping("inout")
	public String selectrinout(Model model) {
		return "/admin/order/inout";
	}

	
	
	

	/* 수량 수정 */
//	@PostMapping("/orlist")
//	public String  selectOrderInfo(ORVO oVO) {
//		int result = 0;
//		result = oService.insertOrderInfo(oVO);
//		// 주문테이블 등록 성공
//		if(result == 1){
//			// 주문상세테이블 등록
//			result = oService.insertOrderPrtInfo(oVO);
//			// 주문상세테이블 등록 성공
//			if(result == 1) {
//				// TODO 사용자에게 등록 성공 알림주기
//			}
//			// 주문상세테이블 등록 실패
//			else {
//				// TODO 사용자에게 실패했다고 알림주기
//				// TODO 주문테이블 삭제 필요
//			}
//		}
//		// 주문테이블 등록 실페
//		else {
//			// TODO 사용자에게 실패했다고 알림주기
//		}
//
//		return "";
//
//	}
}
