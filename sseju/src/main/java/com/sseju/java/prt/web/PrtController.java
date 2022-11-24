package com.sseju.java.prt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.eqm.service.EqmVO;
import com.sseju.java.order.service.ORService;
import com.sseju.java.order.service.ORVO;
import com.sseju.java.prt.service.PRService;
import com.sseju.java.prt.service.PRVO;

@Controller
public class PrtController {
	
	@Autowired
	PRService prService;
	
	@Autowired
	ORService oService;
	
	// 제품주문 페이지
	// 제품목록 조회 서비스
	@GetMapping("/user/selectPrtList")
	@ResponseBody
	public List<PRVO> selectPrtList(Model model) {
		return prService.selectPrtList();
	}
	// 주문상세 페이지
	@GetMapping("orderList")
	public String orderList(Model model) {
		return "/admin/order/orderList";
	}
	@GetMapping("/selectPrtList2")
	@ResponseBody
	public List<ORVO> selectPrtList2(Model model) {
		return prService.selectPrtList2();
	}

	// 주문상세 목록 조회 서비스
	@GetMapping("/user/selectPrtInfoList")
	@ResponseBody
	public List<ORVO> selectPrtInfoList(Model model) {
		return prService.selectPrtInfoList();
	}

	
	@PostMapping("insertPrtInf")
	@ResponseBody
	public String insertPrtInfo(PRVO Pvo) {
		prService.insertPrtInfo(Pvo);
		return "redirect:orderList";
	}
}
