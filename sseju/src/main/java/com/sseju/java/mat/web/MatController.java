package com.sseju.java.mat.web;

import java.util.ArrayList;
import java.util.Date;
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

//	@GetMapping("/matOrd")
//	@ResponseBody
	@GetMapping("/matOrd")
	public String matOrd() {
		return "/admin/mat/matOrd";
	}

	@ResponseBody
	@GetMapping("/emp")
	public List<EmployeeVO> getEmpList() {
		return empservice.getEmpList();
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

	// 발주 등록
	@ResponseBody
	@PostMapping("/insertMatbuy")
	public int insertMatbuy(@RequestParam(value = "Qty[]", required = false) List<String> Qty,
			@RequestParam(value = "mc[]", required = false) List<String> mc,
			@RequestParam(value = "cd[]", required = false) List<String> cd,
			@RequestParam(value = "mp[]", required = false) List<String> mp,
			@RequestParam(value = "moe[]", required = false) List<String> moe) {
		int result = 0;

		for (int i = 0; i < mc.size(); i++) {
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

	// 발주 수정
	@ResponseBody
	@PostMapping("/updateMatbuy")
	public int updateMatbuy(@RequestParam(value = "mon[]", required = false) List<String> mon,
			@RequestParam(value = "Qty[]", required = false) List<String> Qty,
			@RequestParam(value = "mc[]", required = false) List<String> mc,
			@RequestParam(value = "cd[]", required = false) List<String> cd,
			@RequestParam(value = "mp[]", required = false) List<String> mp,
			@RequestParam(value = "moe[]", required = false) List<String> moe,
			@RequestParam(value = "yn[]", required = false) List<String> yn) {
		int uM = 0;
		System.out.println(mon.size());
		for (int i = 0; i < mon.size(); i++) {
			MatVO vo = new MatVO();
			vo.setMatOrdNo(mon.get(i));
			vo.setMatOrdQty(Integer.valueOf(Qty.get(i)));
			vo.setMatCode(mc.get(i));
			vo.setCpCode(cd.get(i));
			vo.setMatPrice(mp.get(i));
			vo.setMatOrdEmp(moe.get(i));
			vo.setMatOrdYn(yn.get(i));

			System.out.println(vo.getMatOrdYn());
			System.out.println(yn.get(i));

			vo.setMatInQty(Integer.valueOf(Qty.get(i)));

			uM += service.updateMatbuy(vo);

			// if(vo.getMatOrdYn() == "진행") {
			if (vo.getMatOrdYn().equals("확인")) {
				MatVO vo1 = new MatVO();
				// List<MatVO> list = new ArrayList<>();
				System.out.println("도달");
				System.out.println(vo.getMatOrdYn());
				System.out.println(vo.getMatOrdNo());
				vo1 = service.selectMatordno(vo);

				if (vo1 != null) {
					service.updateMatnotIn(vo);
				} else {
					service.insertMatord(vo);
				}
			}

			/*
			 * update -> Yn이 확인인 경우에만 미입고내역에 뜰수있고 insertMatord 발주확인에 넣고 미입고내역에 -> Yn을 '입고'로
			 * update시에는 입고 내역에/ '진행'인 경우에는 미입고내역에 뜰수있도록 한다.
			 * 
			 * update -> Yn이 진행인 경우에 Insert -> mat_chk로 넘어가야함 만약 mat_chk에 mat_ord_no이 이미
			 * 존재하는 경우엔 insert가 아닌 update를 해야하고 없는 경우엔 insert를 해야함
			 * 
			 * 
			 * 
			 */

		}

		System.out.println(uM);
		return uM;
	}

	// 발주 삭제
	@PostMapping("/deleteMat")
	@ResponseBody
	public int selectDelete(@RequestBody MatVO vo) {
		return service.deleteMatbuy(vo.getDelno());
	}

	// 입고파트
	@GetMapping("/matIn")
	public String matIn(Model model) {
		// model.addAttribute("mat", model)
		return "/admin/mat/matIn";
	}

	// 입고 종합 리스트
	@ResponseBody
	@GetMapping("/matInList")
	public List<MatVO> matInList() {
		return service.matInList();
	}

	// 미입고
	@GetMapping("/matNotin")
	public String matNotin() {
		// model.addAttribute("mat", model)
		return "/admin/mat/matNotin";
	}

	// 미입고 리스트
	@ResponseBody
	@GetMapping("/matNotinList")
	public List<MatVO> matNotinList() {
		// model.addAttribute("mat", model)
		return service.matNotinList();
	}

	// 미입고 => LOT 입고

	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/insertLot") public int insertLot(
	 * 
	 * @RequestParam(value = "lotDate[]", required = false) List<String> lotDate,
	 * 
	 * @RequestParam(value = "mpCode[]", required = false) List<String> mpCode,
	 * 
	 * @RequestParam(value = "whCode[]", required = false) List<String> whCode,
	 * 
	 * @RequestParam(value = "lotQty[]", required = false) List<String> lotQty,
	 * 
	 * @RequestParam(value = "matChkCode[]", required = false) List<String>
	 * matChkCode){ int result= 0; System.out.println(mpCode.size());
	 * 
	 * for(int i = 0; i < mpCode.size(); i++) { MatVO vo = new MatVO();
	 * //vo.setLotDate((lotDate.get(i))); vo.setMpCode(mpCode.get(i));
	 * vo.setWhCode(whCode.get(i)); vo.setLotQty(Integer.valueOf(lotQty.get(i)));
	 * vo.setMatChkCode(matChkCode.get(i));
	 * 
	 * result += service.insertLot(vo);
	 * 
	 * //if(vo.getMatOrdYn() == "진행") { if(vo.getMatOrdYn().equals("확인")) { MatVO
	 * vo1 = new MatVO(); //List<MatVO> list = new ArrayList<>();
	 * System.out.println("도달"); System.out.println(vo.getMatOrdYn());
	 * System.out.println(vo.getMatOrdNo()); vo1 = service.selectMatordno(vo);
	 * 
	 * 
	 * if(vo1 != null) { service.updateMatnotIn(vo); }else {
	 * service.insertMatord(vo); } }
	 * 
	 * 
	 * 
	 * update -> Yn이 확인인 경우에만 미입고내역에 뜰수있고 insertMatord 발주확인에 넣고 미입고내역에 -> Yn을 '입고'로
	 * update시에는 입고 내역에/ '진행'인 경우에는 미입고내역에 뜰수있도록 한다.
	 * 
	 * update -> Yn이 진행인 경우에 Insert -> mat_chk로 넘어가야함 만약 mat_chk에 mat_ord_no이 이미
	 * 존재하는 경우엔 insert가 아닌 update를 해야하고 없는 경우엔 insert를 해야함
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * System.out.println(uM);return uM;
	 * 
	 * }
	 */

	@GetMapping("/matOut")
	public String matOut() {
		return "/admin/mat/matOut";
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
