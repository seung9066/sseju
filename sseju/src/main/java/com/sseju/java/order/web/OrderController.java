package com.sseju.java.order.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sseju.java.code.service.CodeService;
import com.sseju.java.company.service.CompanyService;
import com.sseju.java.company.service.CompanyVO;
import com.sseju.java.order.service.ORService;
import com.sseju.java.order.service.ORVO;
import com.sseju.java.prt.service.PRService;

@Controller
public class OrderController {
	@Autowired
	ORService oService;

	@Autowired
	PRService prService;

	@Autowired
	CodeService serviceC;

	@Autowired
	CompanyService service;

	@GetMapping("/selectOrderList")
	@ResponseBody
	public List<ORVO> selectOrderList(Model model) {
		return oService.selectOrderList();
	}

	@GetMapping("/selectOrdeIng")
	@ResponseBody
	public List<ORVO> selectOrdeIng() {
		return oService.selectOrdeIng();
	}

	@GetMapping("/prtList")
	@ResponseBody
	public List<CompanyVO> cpList() {
		return service.getCompanyList();
	}

	@GetMapping("/selectPrtManager")
	@ResponseBody
	public List<ORVO> selectPrtManager() {
		return oService.selectPrtManager();
	}

	@GetMapping("/selectOrder")
	@ResponseBody
	public List<ORVO> selectOrder() {
		return oService.selectOrder();
	}
	
	@GetMapping("/select")
	@ResponseBody
	public List<ORVO> select() {
		return oService.select();
	}
	@GetMapping("/select1")
	@ResponseBody
	public List<ORVO> select1() {
		return oService.select1();
	}
	@GetMapping("/selectA")
	@ResponseBody
	public List<ORVO> selectA() {
		return oService.selectA();
	}
	@GetMapping("/selectB")
	@ResponseBody
	public List<ORVO> selectB() {
		return oService.selectB();
	}
	@PostMapping("/select2")
	@ResponseBody
	public List<ORVO> select2(@RequestBody ORVO a) {
		return oService.select2(a);
	}

	@GetMapping("/user/getOrderNo")
	@ResponseBody
	public ORVO getOrderNo() {
		return oService.getOrderNo();
	}

	@PostMapping("/user/insertOrder")
	@ResponseBody
	public int insertOrder(@RequestBody List<ORVO> list) {
		int a = 0;

		a += oService.insertOrder(list.get(0));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			a += oService.insertOrderInfo(list.get(i));
		}

		return a;
	}
	@PostMapping("updateOrderNy")
	@ResponseBody
	public int updateOrderNy(@RequestBody List<ORVO> Ovo) {
		int a = 0;
		System.out.println("aaaaaaa");
		System.out.println(Ovo);
		ORVO vo = new ORVO();
		for (int i = 0; i < Ovo.size(); i++) {
			vo.setOrderNo(Ovo.get(i).getOrderNo());
			vo.setPrtCode(Ovo.get(i).getPrtCode());
			a += oService.updateOrderNy(vo);
		}
		return a;
	}
	@PostMapping("updateOrderWK")
	@ResponseBody
	public int updateOrderWK(@RequestBody List<ORVO> Ovo) {
		int a = 0;
		System.out.println("aaaaaaa");
		System.out.println(Ovo);
		ORVO vo = new ORVO();
		for (int i = 0; i < Ovo.size(); i++) {
			vo.setOrderNo(Ovo.get(i).getOrderNo());
			vo.setPrtCode(Ovo.get(i).getPrtCode());
			a += oService.updateOrderWK(vo);
			oService.updateLot(vo);
		}
		return a;
	}
//	@PostMapping("insertOrderAll")
//	@ResponseBody
//	public int insertOrderAll(@RequestBody List<ORVO> list) {
//		return oService.insertOrderAll(getOrderNo()) ;
//	}
	//들어가는 주소 Controller
	// 전체
	@GetMapping("/orlist")
	public String OrderList(Model model) {
		return "/admin/order/orderList";
	}

	@GetMapping("prtlist")
	public String selecetprtList(Model model) {
		return "/admin/order/prtlist";
	}

	@GetMapping("inout")
	public String selectrinout(Model model) {
		return "/admin/order/inout";
	}
	@GetMapping("/ordetail")
	public String ordetail(Model model) {
		return "/admin/order/ordetail";
	}
}
