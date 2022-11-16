package com.sseju.java.prtprog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//생산 진행 현황 페이지 컨트롤러
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PrtProgController {
	//생산 진행 현황 페이지로 넘겨줌
	@GetMapping("/prtProg")
	public String prtProgList(Model model) {
		return "/admin/produce/prtProg";
	}
}
