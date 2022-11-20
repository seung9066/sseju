package com.sseju.java.shipmentcheck.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//출하검사 페이지 컨트롤러
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ShipmentCheckController {
	@GetMapping("shipmentCheckList")
	public String shipmentCheckList(Model model) {
		return "/admin/quamanage/shipmentCheck";
	}
}
