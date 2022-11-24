package com.sseju.java.eqm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String eqmCheck() {
		return "/admin/eqm/eqmCheck";
	}
	
	@GetMapping("eList")
	@ResponseBody
	public List<EqmVO> getEmpList(){
		return eqmService.getEmpList();
	}

	@GetMapping("/eqmUoper")
	public String eqmUoper() {
		return "/admin/eqm/eqmUoper";
	}

	//설비 리스트
	@GetMapping("/getEqmList")
	@ResponseBody
	public List<EqmVO> getEqmList() {

		return eqmService.selectEqmList();
	}

	@GetMapping("/eqmChkList")
	@ResponseBody
	public List<EqmVO> eqmChkList() {
		return eqmService.getEqmChkList();
	}

	@GetMapping("/uoperList")
	@ResponseBody
	public List<EqmVO> uoperList() {
		return eqmService.getUoperList();
	}

	@PostMapping("/deleteEqm")
	@ResponseBody
	public int deleteEqm(@RequestParam(value = "deleteEqm[]", required = false) List<String> deleteEqm) {
		int a = 0;
		for (int i = 0; i < deleteEqm.size(); i++) {
			String line1 = deleteEqm.get(i);

			EqmVO vo = new EqmVO();
			vo.setEqmCode(line1);

			a += eqmService.deleteEqmInfo(vo);
		}
		return a;
	}

	@PostMapping("/deleteChk")
	@ResponseBody
	public int deleteChk(@RequestParam(value = "chk[]", required = false) List<String> deleteChk) {
		int a = 0;
		for (int i = 0; i < deleteChk.size(); i++) {
			String line1 = deleteChk.get(i);

			EqmVO vo = new EqmVO();
			vo.setChkNo(line1);
			System.out.println(vo.getChkNo());
			a += eqmService.deleteEqmChk(vo);
		}

		return a;
	}

	@PostMapping("insertEqm")
	@ResponseBody
	public int insertEqm(EqmVO eqmVO) {
		
		
		int a = eqmService.insertEqmInfo(eqmVO);
		// 설비등록하는 동시에 공통코드에도 값 넣어주기
		CodeVO vo = new CodeVO();
		vo.setCode(eqmVO.getEqmCode());
		vo.setDivName("설비");
		vo.setDivCode("EQM");
		vo.setCodeName(eqmVO.getEqmName());
		
		cdService.insertCode(vo);
		
		return a;
	}
	
	

	@PostMapping("/updateEqm")
	@ResponseBody
	public int updateEqm(EqmVO eqmVO) {
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
		System.out.println(eqmVO.getLineNo());
		return result;

	}

	@PostMapping("insertEqmChk")
	@ResponseBody
	public int insertChk(EqmVO eqmVO) {
		int a = eqmService.insertEqmChk(eqmVO);
		
		return a;
	}

	@PostMapping("insertUoper")
	@ResponseBody
	public int insertUoper(EqmVO eqmVO) {
		int a = eqmService.insertUoper(eqmVO);
		return a;
	}

	@PostMapping("/deleteLine")
	@ResponseBody
	public int deleteLine(@RequestParam(value = "line[]", required = false) List<String> line) {
		int a = 0;
		for (int i = 0; i < line.size(); i++) {
			String line1 = line.get(i);

			EqmVO vo = new EqmVO();
			vo.setLineNo(line1);

			a += eqmService.deleteEqmLine(vo);
		}
		return a;
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