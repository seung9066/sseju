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
@RequestMapping("order")
public class OrderController {
	@Autowired
	ORService Service;

	// 등록-품
	@GetMapping("insert")
	public String insertForm(Model model) {
		return "order/insertForm";
	}

	// 등록-DB
	@PostMapping("insert")
	public String insertOrder(ORVO orVO, RedirectAttributes ratt) {

		return "redirect:list";
	}

	// 전체
	@GetMapping("list")
	public String selectOrderList(Model model) {
		return "order/orderList";
	}

	// 단건
	@GetMapping("info")
	public String selectOrderInfo(ORVO orVO, Model model) {

		return "order/orderInfo";
	}

	// 수정-폼
	@PostMapping("updateform")
	public String updateForm(Model model) {
		return "order/updateForm";
	}

	// 수정-DB update
	@PostMapping("update")
	public String updateOrder(ORVO orVO, RedirectAttributes ratt) {

		return "redirect:list";
	}

	// 삭제
	@GetMapping("delete")
	public String deleteForm(Model model, ORVO prVO) {
		return "order/orderList";
	}

}
