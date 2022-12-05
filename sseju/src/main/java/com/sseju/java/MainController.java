package com.sseju.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sseju.java.code.service.CodeService;

@Controller
public class MainController {
	
	@Autowired
	CodeService service;
	
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
	public String dashboard(Model model) {
		model.addAttribute("wh", service.whList());
		return "admin/dashboard";
	}
	
	@GetMapping("/accountform")
	public String accountform() {
		return "newaccount";
	}

	


}
