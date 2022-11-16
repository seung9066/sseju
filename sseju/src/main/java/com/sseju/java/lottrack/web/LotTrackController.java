package com.sseju.java.lottrack.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LotTrackController {
	//생산관리/제품 로트 페이지로 연결
	@GetMapping("/lotTrack")
	public String lotTrackList(Model model) {
		
		return "/admin/produce/lotTrack";
	}
}
