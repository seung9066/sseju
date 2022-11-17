package com.sseju.java.company.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sseju.java.code.service.CodeService;
import com.sseju.java.code.service.CodeVO;
import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;

@Controller
public class CompanyController {
	
	@Autowired
	CompanyService service;
	
	@Autowired
	CodeService serviceC;
	
	@PostMapping("/newCpAccount")
	public String cpAccount(CompanyVO vo) {
		BCryptPasswordEncoder enco = new BCryptPasswordEncoder();
		String pw = vo.getPassword();
		vo.setPassword(enco.encode(pw));
		
		service.insertCompany(vo);
		service.insertLogin(vo);
		
		CompanyVO voCP = new CompanyVO();
		voCP = service.getCompanyInfo(vo);
		
		CodeVO voc = new CodeVO();
		voc.setCode(voCP.getCpCode());
		voc.setDivName("거래처");
		voc.setCodeName(voCP.getCpName());
		voc.setDivCode("CP");
		serviceC.insertCode(voc);
		return "login";
	}
	
	@GetMapping("/CompanyList")
	public List<CompanyVO> cpList() {
		return service.getCompanyList();
	}

}
