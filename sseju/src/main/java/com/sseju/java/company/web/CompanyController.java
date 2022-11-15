package com.sseju.java.company.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;

@Controller
public class CompanyController {
	
	@Autowired
	CompanyService service;
	
	@PostMapping("/newCpAccount")
	public String cpAccount(CompanyVO vo) {
		BCryptPasswordEncoder enco = new BCryptPasswordEncoder();
		String pw = vo.getPassword();
		vo.setPassword(enco.encode(pw));
		
		service.insertCompany(vo);
		service.insertLogin(vo);
		return "login";
	}

}
