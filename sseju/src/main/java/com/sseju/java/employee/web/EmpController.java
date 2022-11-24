package com.sseju.java.employee.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.code.service.CodeService;
import com.sseju.java.code.service.CodeVO;
import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;
import com.sseju.java.employee.service.EmployeeService;
import com.sseju.java.employee.service.EmployeeVO;

@Controller
public class EmpController {

	@Autowired
	EmployeeService service;

	@Autowired
	CompanyService serviceCP;
	
	@Autowired
	CodeService serviceCD;

	@PostMapping("/insertaccount")
	public String empInsert(EmployeeVO vo) {
		service.insertEmp(vo);
		return "login";
	}

	@ResponseBody
	@GetMapping("/idCheck")
	public int idCheck(String id) {
		System.out.println(id);
		return service.idCheck(id);
	}

	@GetMapping("/empList")
	@ResponseBody
	public List<EmployeeVO> getEmpList() {
		return service.getEmpList();
	}

	@PostMapping("/insertEmployeeA")
	public String insertEmp(EmployeeVO vo) {
		BCryptPasswordEncoder enco = new BCryptPasswordEncoder();
		String pw = vo.getPassword();

		CompanyVO vocp = new CompanyVO();
		vocp.setId(vo.getEmpId());
		vocp.setAuth("ROLE_ADMIN");
		vocp.setPassword(enco.encode(pw));
		
		CodeVO vo1 = new CodeVO();
		vo1.setEmpId(vo.getEmpId());
		serviceCP.insertLogin(vocp);
		service.insertEmp(vo);
		serviceCD.insertEmpMng(vo1);
		
		return "redirect:basicEmployee";
	}

	@PostMapping("/selectDeleteEmp")
	@ResponseBody
	public int selectDelete(@RequestParam(value = "code[]", required = false) List<String> code) {
		int a = 0;
		for (int i = 0; i < code.size(); i++) {
			String code1 = code.get(i);
			System.out.println(code1);
			
			CompanyVO vo = new CompanyVO();
			vo.setId(code1);

			EmployeeVO voEM = new EmployeeVO();
			voEM.setEmpId(code1);
			
			a += serviceCP.deleteLogin(vo);
			a += service.deleteEmp(voEM);
		}
		return a;
	}
	
	@PostMapping("/updateEmp")
	@ResponseBody
	public int updateEmp(@RequestBody EmployeeVO vo) {
		return service.updateEmp(vo);
	}
}
