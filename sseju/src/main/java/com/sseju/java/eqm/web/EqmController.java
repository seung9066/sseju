package com.sseju.java.eqm.web;

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
import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;
import com.sseju.java.employee.service.EmployeeService;
import com.sseju.java.eqm.service.EqmService;
import com.sseju.java.eqm.service.EqmVO;

@Controller
public class EqmController {

	@Autowired
	EqmService eqmService;
	@Autowired
	CompanyService cService;
	@Autowired
	CodeService cdService;
	@Autowired
	EmployeeService eService;
	
	

	// 거래처 정보
	@GetMapping("/cpList")
	@ResponseBody
	public List<CompanyVO> getCompanyList() {
		return cService.getCompanyList();
	}
	
	// 직원 정보
	  @GetMapping("eList")
	   @ResponseBody
	   public List<EqmVO> getEmpList(){
	      return eqmService.getEmpList();
	   }


	@GetMapping("/eqmList")
	public String eqmList(Model model) {
		model.addAttribute("line", eqmService.getEqmLineList());
		return "/admin/eqm/eqmList";
	}

	@GetMapping("/eqmBasic")
	public String lineList() {
		return "/admin/eqm/eqmBasic";
	}

	@GetMapping("/eqmCheck")
	public String eqmCheck(Model model) {
		model.addAttribute("line", eqmService.getEqmLineList());
		model.addAttribute("eqmm", eqmService.selectEqmList());
		return "/admin/eqm/eqmCheck";
	}
	
	

	@GetMapping("/eqmUoper")
	public String eqmUoper(Model model) {
		model.addAttribute("line", eqmService.getEqmLineList());
		return "/admin/eqm/eqmUoper";
	}
	
	@GetMapping("/eqmState")
	public String eqmState() {
		return "/admin/eqm/eqmState";
	}

	//설비 리스트
	@GetMapping("/getEqmList")
	@ResponseBody
	public List<EqmVO> getEqmList(Model model) {

		 return eqmService.selectEqmList();
		 
	}
	
	


	@GetMapping("/eqmChkList")
	@ResponseBody
	public List<EqmVO> eqmChkList() {
		return eqmService.getEqmChkList();
	}
	
	@GetMapping("/chkList")
	@ResponseBody
	public List<EqmVO> chkList(){
		return eqmService.getChkList();
	}
	
	

	@GetMapping("/uoperList")
	@ResponseBody
	public List<EqmVO> uoperList() {
		return eqmService.getUoperList();
	}

	@PostMapping("/deleteEqm")
	@ResponseBody
	public int deleteEqm(@RequestParam(value = "deleteEqm[]", required = false) List<String> deleteEqm) {
		return eqmService.deleteEqm(deleteEqm);
	}
	
	@PostMapping("/deleteUoper")
	@ResponseBody
	public int deleteUoper(@RequestParam(value = "deleteUoper[]", required = false) List<String> deleteUoper) {
		return eqmService.deleteUoper(deleteUoper);
	}

	@PostMapping("/deleteChk")
	@ResponseBody
	public int deleteChk(@RequestParam(value = "chk[]", required = false) List<String> deleteChk) {
	
		return eqmService.deleteChk(deleteChk);
	}

	@PostMapping("insertEqm")
	@ResponseBody
	public int insertEqm(EqmVO eqmVO) {
		
		return eqmService.insertEqm(eqmVO);
		
	}

	@PostMapping("/updateEqm")
	@ResponseBody
	public int updateEqm(@RequestBody EqmVO eqmVO) {
		return eqmService.updateEqmInfo(eqmVO);
	}

	@GetMapping("/lineList")
	@ResponseBody
	public List<EqmVO> getEqmLineList() {
		return eqmService.getEqmLineList();
	}

	@PostMapping("insertLine")
	@ResponseBody
	public int insertLine(EqmVO eqmVO) {

		int result = eqmService.insertEqmLine(eqmVO);
		return result;

	}

	@PostMapping("insertEqmChk")
	@ResponseBody
	public int insertChk(EqmVO eqmVO) {
		int a = eqmService.insertEqmChk(eqmVO);
		
		return a;
	}

	//비가동 등록
	
	@PostMapping("insertUoper")
	@ResponseBody
	public String insertUoper(@RequestBody EqmVO eqmVO,Model mode) {
		eqmService.insertUoper(eqmVO);
		eqmService.updateEqmYn(eqmVO);
		return "/admin/eqm/eqmUoper";
	}
	//비가동 수정
	
	@RequestMapping("/updateUoper")
	@ResponseBody
	public String updateUoper(@RequestBody EqmVO eqmVO) {
		 	eqmService.updateUoper(eqmVO);
			eqmService.updateEqmYn(eqmVO);
		return "/admin/eqm/eqmUoper";
	}

	@PostMapping("/deleteLine")
	@ResponseBody
	public int deleteLine(@RequestParam(value = "line[]"
			+ "", required = false) List<String> line) {
		return eqmService.deleteLine(line);
	}

	@RequestMapping("/updateLine")
	@ResponseBody
	public int updateLine(@RequestBody EqmVO eqmVO) {
		return eqmService.updateEqmLine(eqmVO);
	}

	@RequestMapping("/updateChk")
	@ResponseBody
	public int updateChk(@RequestBody EqmVO eqmVO) {
		return eqmService.updateEqmChk(eqmVO);
	}
	
	
	
	

}