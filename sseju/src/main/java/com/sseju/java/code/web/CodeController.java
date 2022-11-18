package com.sseju.java.code.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.code.service.CodeService;
import com.sseju.java.code.service.CodeVO;
import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;
import com.sseju.java.employee.service.EmployeeService;
import com.sseju.java.employee.service.EmployeeVO;
import com.sseju.java.eqm.service.EqmVO;
import com.sseju.java.mat.service.MatVO;

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
	public String basicBOM(Model model) {
		model.addAttribute("mat", service.getBOMMatList());
		model.addAttribute("prt", service.getBOMPrtList());
		return "/admin/basicTab/BOM";
	}
	
	@GetMapping("/basicCompany")
	public String basicCompany() {
		return "/admin/basicTab/company";
	}
	
	@GetMapping("/basicEmployee")
	public String basicEmployee(Model model) {
		model.addAttribute("dept", service.getDept());
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
	
	@PostMapping("/selectDeleteCP")
	@ResponseBody
	public int selectDelete(@RequestParam(value="code[]", required=false) List<String> code) {
		int a = 0;
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
				
				a += service.deleteCode(vo);
				a += serviceCP.deleteCompany(vocp);
				a += serviceEM.deleteLogin(voEM);		
			} else if (code1.equals("EQM")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				
				EqmVO voeqm = new EqmVO();
				
				a += service.deleteCode(vo);
			} else if (code1.equals("PRS")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				
				a += service.deleteCode(vo);
			} else if (code1.equals("ERP")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				
				
				a += service.deleteCode(vo);
			} else if (code1.equals("ERM")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));


				
				a += service.deleteCode(vo);
			} else if (code1.equals("PRD")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));


				
				a += service.deleteCode(vo);
			} else if (code1.equals("MAT")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				
				MatVO vomat = new MatVO();
				
				a += service.deleteCode(vo);
			} else if (code1.equals("EQS")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				
				a += service.deleteCode(vo);
			} else if (code1.equals("UOR")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				

				
				a += service.deleteCode(vo);
			} else if (code1.equals("PRG")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				

				
				a += service.deleteCode(vo);
			} else if (code1.equals("STO")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				

				
				a += service.deleteCode(vo);
			}
		}
		return a;
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
	
	@PostMapping("/insertBOM")
	@ResponseBody
	public int insertBOM(@RequestParam(value="nameList[]", required=false) List<String> nameList, @RequestParam(value="capList[]", required=false) List<String> capList, @RequestParam(value="matList[]", required=false) List<String> matList) {
		int a = 0;
		for (int i = 0; i < nameList.size(); i++) {
				CodeVO vo = new CodeVO();
				vo.setPrtName(nameList.get(i));
				vo.setMatName(matList.get(i));
				vo.setCapacity(capList.get(i));
				
				CodeVO vomat = new CodeVO();
				vomat = service.getMatCode(vo);
				
				CodeVO voprt = new CodeVO();
				voprt = service.getPrtCode(vo);
				
				vo.setPrtCode(voprt.getPrtCode());
				vo.setMatCode(vomat.getMatCode());
				
				a += service.insertBOM(vo);
			}
		return a;
	}
	
	@PostMapping("/updateBOM")
	@ResponseBody
	public int updateBOM(@RequestParam(value = "mat[]", required = false) List<String> mat, @RequestParam(value = "cap[]", required = false) List<String> cap, @RequestParam(value = "prtName[]", required = false) List<String> prtName) {
		int a = 0;
		
		CodeVO vo = new CodeVO();
		vo.setPrtName(prtName.get(0));
		vo = service.getPrtCode(vo);
		System.out.println("aaaaaaaaaaaaaa");
		System.out.println(vo.getPrtCode());
		service.deleteBOM(vo);
		for (int i = 0; i < mat.size(); i++) {
			CodeVO vo1 = new CodeVO();
			vo1.setMatName(mat.get(i));
			
			CodeVO voa = new CodeVO();
			voa.setMatCode(service.getMatCode(vo1).getMatCode());
			voa.setCapacity(cap.get(i));
			voa.setPrtCode(vo.getPrtCode());
			
			a += service.insertBOM(voa);
		}
		return a;
	}

}
