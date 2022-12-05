package com.sseju.java.matorder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatOrderController {
//생산 진행 현황 페이지에서 자재 발주 클릭 시 모달창 띄워주기위한 컨트롤러
	@GetMapping("/matOrder")
	public String matOrderList(Model model) {
		return "admin/produce/matOrder";
	}
}
