package com.sseju.java.prt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@GetMapping("prtOrder")
	public String prtOrder(Model model) {
		return "/admin/order/prtOrder";
	}

	// 제품목록 조회 서비스
	@GetMapping("/selectPrtList")
	@ResponseBody
	public List<PRVO> selectPrtList(Model model) {
		return prService.selectPrtList();
	}
	
	// 주문상세 페이지
	@GetMapping("orderList")
	public String orderList(Model model) {
		return "/admin/order/orderList";
	}

	// 주문상세 목록 조회 서비스
	@GetMapping("/selectPrtInfoList")
	@ResponseBody
	public List<ORVO> selectPrtInfoList(Model model) {
		return prService.selectPrtInfoList();
	}
	
}
