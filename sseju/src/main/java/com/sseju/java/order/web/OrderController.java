package com.sseju.java.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sseju.java.order.service.ORService;
import com.sseju.java.order.service.ORVO;

@Controller
public class OrderController {
	@Autowired
	ORService Service;

	// 등록-품
	@GetMapping("orinsert")
	public String insertForm(Model model) {
		return "order/insertForm";
	}

	// 등록-DB
	@PostMapping("orinsert")
	public String insertOrder(ORVO orVO, RedirectAttributes ratt) {

		return "redirect:list";
	}

	// 전체
	@GetMapping("orlist")
	public String selectOrderList(Model model) {
		return "order/orderList";
	}

	// 단건
	@GetMapping("info")
	public String selectOrderInfo(ORVO orVO, Model model) {

		return "order/orderInfo";
	}
	
	@GetMapping("prtlist")
	public String selectPrtList(Model model) {
		
		return "order/prtList";
	}
	

}
