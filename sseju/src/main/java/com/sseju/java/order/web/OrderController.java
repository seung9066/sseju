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
		return "/admin/order/insertForm";
	}

	// 등록-DB
	@PostMapping("orinsert")
	public String insertOrder(ORVO orVO, RedirectAttributes ratt) {

		return "redirect:list";
	}

	// 전체
	@GetMapping("/orlist")
	public String selectOrderList(Model model) {
		return "/admin/order/orderList";
	}

	// 단건
	@GetMapping("orinfo")
	public String selectOrderInfo(ORVO orVO, Model model) {

		return "/adminorder/orderInfo";
	}

	// 수정-폼
	@PostMapping("orupdateform")
	public String updateForm(Model model) {
		return "/admin/order/updateForm";
	}

	// 수정-DB update
	@PostMapping("orupdate")
	public String updateOrder(ORVO orVO, RedirectAttributes ratt) {

		return "redirect:list";
	}

	// 삭제
	@GetMapping("ordelete")
	public String deleteForm(Model model, ORVO prVO) {
		return "/admin/order/orderList";
	}

}
