package com.sseju.java.mat.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.sseju.java.employee.service.EmployeeVO;
import com.sseju.java.mat.service.MatService;
import com.sseju.java.mat.service.MatVO;

@Controller
public class MatController {
	
	@Autowired
	MatService service;
	
	
	@Autowired CodeService cservice;
	 
	
	@Autowired
	CompanyService comservice;
	
	@Autowired
	EmployeeService empservice;
	
	
	
//	@GetMapping("/matOrd")
//	@ResponseBody
	@GetMapping("/matOrd")
	public String matOrd() {
		return "/admin/mat/matOrd";
	}
	
	@ResponseBody
	@GetMapping("/emp")
	public List<EmployeeVO> getEmpList(){
		return empservice.getEmpList();
	}
	
	@ResponseBody
	@GetMapping("/material")
	public List<MatVO> material(){
		return service.material();
	}
	
	@ResponseBody
	@GetMapping("/company")
	public List<CompanyVO> getCompanyList(){
		return comservice.getCompanyList();
	}
	
	//발주 종합 리스트 
	@ResponseBody
	@GetMapping("/matordList")
	public List<MatVO> matordList() {
		return service.matordList();
	}
	
	//발주 등록
	@ResponseBody
	@PostMapping("/insertMatbuy")
	public int insertMatbuy(@RequestParam(value = "Qty[]", required = false) List<String> Qty,
			@RequestParam(value = "mc[]", required = false) List<String> mc,
			@RequestParam(value = "cd[]", required = false) List<String> cd,
			@RequestParam(value = "mp[]", required = false) List<String> mp,
			@RequestParam(value = "moe[]", required = false) List<String> moe) {
			int result = 0;
			
			for(int i = 0; i < mc.size(); i++) {
				MatVO vo = new MatVO();
				vo.setMatOrdQty(Integer.valueOf(Qty.get(i)));
				vo.setMatCode(mc.get(i));
				vo.setCpCode(cd.get(i));
				vo.setMatPrice(mp.get(i));
				vo.setMatOrdEmp(moe.get(i));
				
				result += service.insertMatbuy(vo);
			}
		return result;
	}
	
	//발주 수정
	@ResponseBody
	@PostMapping("/updateMatbuy")
	public int updateMatbuy(
			@RequestParam(value = "mon[]", required = false) List<String> mon,
			@RequestParam(value = "Qty[]", required = false) List<String> Qty,
			@RequestParam(value = "mc[]", required = false) List<String> mc,
			@RequestParam(value = "cd[]", required = false) List<String> cd,
			@RequestParam(value = "mp[]", required = false) List<String> mp,
			@RequestParam(value = "moe[]", required = false) List<String> moe,
			@RequestParam(value = "yn[]", required = false) List<String> yn) {
			int uM = 0;
			
			System.out.println(mon.size());
			for(int i = 0; i < mon.size(); i++) {
				MatVO vo = new MatVO();
				vo.setMatOrdNo(mon.get(i));
				vo.setMatOrdQty(Integer.valueOf(Qty.get(i)));
				vo.setMatCode(mc.get(i));
				vo.setCpCode(cd.get(i));
				vo.setMatPrice(mp.get(i));
				vo.setMatOrdEmp(moe.get(i));
				vo.setMatOrdYn(yn.get(i));
				
				uM += service.updateMatbuy(vo);
			}
			
			System.out.println(uM);
		return uM;
	}
	
	//발주 삭제
	@PostMapping("/deleteMat")
	@ResponseBody
	public int selectDelete(@RequestBody MatVO vo) {
		return service.deleteMatbuy(vo.getDelno());
	}
	
	@RequestMapping("/matInout")
	public String ex() {
		return "/admin/mat/matInout";
	}
	
	@RequestMapping("/matStock")
	public String matt() {
		return "/admin/mat/matStock";
	}
	
	@RequestMapping("/matCheck")
	public String hh() {
		return "/admin/mat/matCheck";
	}
	
	@RequestMapping("/exex")
	public String exex() {
		return "/admin/mat/exex";
	}
}
