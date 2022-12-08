package com.sseju.java.lottrack.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.lottrack.service.LotTrackService;
import com.sseju.java.lottrack.service.LotTrackVO;

@Controller
public class LotTrackController {
	
	@Autowired
	LotTrackService ltService;
	
	//제품 로트 페이지 연결
	@GetMapping("/lotTrack")
	public String lotTrack() {
		return "admin/produce/lotTrack";
	}
	@GetMapping("/getLotTrackList")
	@ResponseBody
	public List<LotTrackVO> getLotTrackList(){
		return ltService.getLotTrackList();
	}
	
}
