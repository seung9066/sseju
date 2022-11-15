package com.sseju.java.eqm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sseju.java.eqm.service.EqmService;

@Controller
public class EqmController {
	
	@Autowired
	   EqmService eqmService;

	
	  @RequestMapping("/eqmList")
	   public String getEqmList(Model model) { //데이터를 보낼때 model
	      model.addAttribute("eqmList", eqmService.selectEqmList());
	      return "/admin/eqm/eqmList";
	   }
	  
	  @GetMapping("/eqmCheck")
		public String eqmCheck() {
			return "/admin/eqm/eqmCheck";
		}


}
