package com.sseju.java.employee.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.sseju.java.employee.service.EmployeeService;
import com.sseju.java.employee.service.EmployeeVO;

@Controller
public class EmpController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping
	public String empInsert(EmployeeVO vo) {
		service.insertEmp(vo);
		return "login";
	}

}
