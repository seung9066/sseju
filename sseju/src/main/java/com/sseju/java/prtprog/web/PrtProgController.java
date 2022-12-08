package com.sseju.java.prtprog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//생산 진행 현황 페이지 컨트롤러
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.prtprog.service.PrtProgService;
import com.sseju.java.prtprog.service.PrtProgVO;
@Controller
public class PrtProgController {
	
	@Autowired
	PrtProgService pprService;
	
	//생산 진행 현황 페이지로 넘겨줌
	@GetMapping("/prtProg")
	public String prtProgList() {
		return "admin/produce/prtProg";
	}
	//생산 진행 현황 페이지의 그리드에 데이터 띄워주기
	@GetMapping("/getPrtProgList")
	@ResponseBody
	public List<PrtProgVO> getPrtProgList(){
		
		return pprService.getPrtProgList();
	}
	//ㄴ위 그리드의 각 행 클릭 시 해당 행의 제품에 대한 자재 상황 가져오기
	@GetMapping("/progPrtCondition")
	@ResponseBody
	public List<PrtProgVO> progPrtCondition(PrtProgVO pprVO){
		
		return pprService.progPrtCondition(pprVO);
	}
	//생산 진행 현황에서 생산 진행이 끝나면 update실행
	@PostMapping("/updateProgYtoE")
	@ResponseBody
	public int updateProgYtoE(@RequestBody PrtProgVO pprVO) {
		return pprService.updateProgYtoE(pprVO);
	}
	
}
