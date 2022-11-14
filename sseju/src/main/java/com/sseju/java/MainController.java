package com.sseju.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sseju.java.eqm.service.EqmService;

@Controller
public class MainController {
	
	@Autowired
	EqmService eqmService;
	
	@RequestMapping("/")
    public String index(){
        return "index";
    }
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}	
	
//	@GetMapping("/eqmCode")
//	public String eqmCode() {
//		return "/admin/eqm/eqmCode";
//	}	
	
	@RequestMapping("/eqmList")
	public String getEqmList(Model model) { //데이터를 보낼때 model
		model.addAttribute("eqmList", eqmService.selectEqmList());
		return "/admin/eqm/eqmList";
	}

	
	

}
