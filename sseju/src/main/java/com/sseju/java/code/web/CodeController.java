package com.sseju.java.code.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.code.service.CodeService;
import com.sseju.java.code.service.CodeVO;

@Controller
public class CodeController {
	
	@Autowired
	CodeService service;
	
	@GetMapping("/code")
	public String getCodeListForm() {
		return "/admin/basicTab/code";
	}
	
	@GetMapping("/codeList")
	@ResponseBody
	public List<CodeVO> getCodeList(Model model) {
		return service.getCodeList();
	}
	
	@GetMapping("/selectDelete")
	@ResponseBody
	public String selectDelete(List<String> code) {
		System.out.println(code);
		System.out.println("aaaaaaaaaaaaaa");
		for (int i = 0; i < code.size(); i++) {
			CodeVO vo = new CodeVO();
			vo.setCode(code.get(i));
			service.deleteCode(vo);
		}
		return "redirect";
	}
	
}
