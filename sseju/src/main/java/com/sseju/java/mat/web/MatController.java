package com.sseju.java.mat.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.code.service.CodeService;
import com.sseju.java.code.service.CodeVO;
import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;
import com.sseju.java.employee.service.EmployeeService;
import com.sseju.java.employee.service.EmployeeVO;
import com.sseju.java.mat.service.MatService;
import com.sseju.java.mat.service.MatVO;
import com.sseju.java.workorder.serivce.WorkOrderService;

@Controller
public class MatController {

	@Autowired
	MatService service;

	@Autowired
	CodeService cservice;

	@Autowired
	CompanyService comservice;

	@Autowired
	EmployeeService empservice;
	
	@Autowired
	WorkOrderService woService;

//	@GetMapping("/matOrd")
//	@ResponseBody
	@GetMapping("/matOrd")
	public String matOrd() {
		return "admin/mat/matOrd";
	}


	@ResponseBody
	@GetMapping("/material")
	public List<MatVO> material() {
		return service.material();
	}

	@ResponseBody
	@GetMapping("/company")
	public List<CompanyVO> getCompanyList() {
		return comservice.getCompanyList();
	}

	@ResponseBody
	@GetMapping
	public List<CodeVO> whList() {
		return cservice.whList();
	}

	// 발주 종합 리스트
	@ResponseBody
	@GetMapping("/matordList")
	public List<MatVO> matordList() {
		return service.matordList();
	}

	

	// 입고파트
	@GetMapping("/matIn")
	public String matIn(Model model) {
		// model.addAttribute("mat", model)
		return "admin/mat/matIn";
	}

	// 입고 종합 리스트
	@ResponseBody
	@GetMapping("/matInList")
	public List<MatVO> matInList() {
		return service.matInList();
	}


	@GetMapping("/matOut")
	public String matOut() {
		return "admin/mat/matOut";
	}
	
	//출고 종합 리스트
	@ResponseBody
	@GetMapping("/matOutList")
	public List<MatVO> matOutList(){
		return service.matOutList();
	}

	@RequestMapping("/matStock")
	public String matt() {
		return "admin/mat/matStock";
	}
	
	//재고 종합 리스트
	@ResponseBody
	@GetMapping("/matStockList")
	public List<MatVO> matStockList(){
		return service.matStockList();
	}
	
	@PostMapping("/matRecChk")
	public String matRecChkList() {
		return "admin/quamanage/matRecChk";
	}
	
	//검수 내역 리스트
	@ResponseBody
	@GetMapping("/matCheckList")
	public List<MatVO> matCheckList(){
		return service.matCheckList();
	}
	
	@PostMapping("docUpdate")
	public String docUpdate(MatVO MatVO) {
		service.docUpdate(MatVO);
		return "redirect:matRecChk";
	}
}
