package com.sseju.java.code.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.code.service.CodeService;
import com.sseju.java.code.service.CodeVO;
import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;
import com.sseju.java.employee.service.EmployeeService;
import com.sseju.java.employee.service.EmployeeVO;

@Controller
public class CodeController {
	
	@Autowired
	CodeService service;
	
	@Autowired
	CompanyService serviceCP;
	
	@Autowired
	EmployeeService serviceEM;
	
	@GetMapping("/basicCode")
	public String getCodeListForm() {
		return "/admin/basicTab/code";
	}
	
	@GetMapping("/basicProduct")
	public String basicProduct() {
		return "/admin/basicTab/product";
	}
	
	@GetMapping("/basicBOM")
	public String basicBOM() {
		return "/admin/basicTab/BOM";
	}
	
	@GetMapping("/basicCompany")
	public String basicCompany() {
		return "/admin/basicTab/company";
	}
	
	@GetMapping("/basicEmployee")
	public String basicEmployee() {
		return "/admin/basicTab/Employee";
	}
	
	@GetMapping("/basicError")
	public String basicError() {
		return "/admin/basicTab/error";
	}
	
	@GetMapping("/basicProcess")
	public String basicProcess() {
		return "/admin/basicTab/process";
	}
	
	@GetMapping("/basicWarehouse")
	public String basicWarehouse() {
		return "/admin/basicTab/warehouse";
	}
	
	@GetMapping("/basicWorker")
	public String basicWorker() {
		return "/admin/basicTab/worker";
	}
	
	@GetMapping("/codeList")
	@ResponseBody
	public List<CodeVO> getCodeList(Model model) {
		return service.getCodeList();
	}
	
	@GetMapping("/selectDeleteCP")
	@ResponseBody
	public int selectDelete(@RequestParam(value="code[]", required=false) List<String> code) {
		System.out.println(code);
		System.out.println("aaaaaaaaaaaaaa");
		for (int i = 0; i < code.size(); i++) {
			String code1 = code.get(i).substring(0,3);
			System.out.println(code1);
			if (code1.equals("CP_")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				
				CompanyVO vocp = new CompanyVO();
				vocp.setCpCode(code.get(i));
				
				vocp = serviceCP.getCompanyInfo(vocp);
				EmployeeVO voEM = new EmployeeVO();
				voEM.setId(vocp.getId());
				
				service.deleteCode(vo);
				serviceCP.deleteCompany(vocp);
				serviceEM.deleteLogin(voEM);		
			} else if (code1.equals("EQM")) {
				
			} else if (code1.equals("PRS")) {
				
			} else if (code1.equals("EQM")) {
				
			} else if (code1.equals("ERP")) {
				
			} else if (code1.equals("ERM")) {
				
			} else if (code1.equals("PRD")) {
				
			} else if (code1.equals("MAT")) {
				
			} else if (code1.equals("EQS")) {
				
			} else if (code1.equals("UOR")) {
				
			} else if (code1.equals("PRG")) {
				
			} else if (code1.equals("STO")) {
				
			}
			
		}
		return 1;
	}
	
	@GetMapping("/codeCpList")
	@ResponseBody
	public List<CodeVO> getCpCode() {
		List<CodeVO> list = service.getCodeList();
		List<CodeVO> list1 = new ArrayList<CodeVO>();
		
		for (int i = 0; i < list.size(); i++) {
			String code = list.get(i).getCode().substring(0,3);
			if (code.equals("CP_")) {
				list1.add(list.get(i));
			}
		}
		return list1;
	}
	
	@GetMapping("/bomList")
	@ResponseBody
	public List<CodeVO> bomList(@RequestParam(value="prtName", required=false) String prtName) {
		CodeVO vo = new CodeVO();
		vo.setPrtName(prtName);

		return service.getBomList(vo);
	}
	
	@GetMapping("/bomMenu")
	@ResponseBody
	public List<CodeVO> bomMenu() {
		return service.getBomMenu();
	}
	
}
