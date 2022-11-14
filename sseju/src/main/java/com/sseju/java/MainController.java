package com.sseju.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
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

}
