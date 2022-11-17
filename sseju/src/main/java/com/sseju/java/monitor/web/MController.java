package com.sseju.java.monitor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
public class MController {
	
	@GetMapping("prduce")
	public String selectprduce(Model model) {
		return "/admin/monitoring/prduce";
	}
	@GetMapping("shipment")
	public String selectshipment(Model model) {
		return "/admin/monitoring/shipment";
	}
	@GetMapping("Stock")
	public String selectStock(Model model) {
		return "/admin/monitoring/Stock";
	}
	@GetMapping("plan")
	public String selectPlan(Model model) {
		return "/admin/monitoring/plan";
	}
}
