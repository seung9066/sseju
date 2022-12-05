package com.sseju.java.code.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

class produceThread implements Runnable {

	private List<CodeVO> type;

	private CodeService service;

	public produceThread(List<CodeVO> type) {
		this.type = type;
	}

	@Override
	public void run() {
		service = ApplicationContextProvider.getBean(CodeService.class);

		CodeVO vo = new CodeVO();

		// 작업시작 empName, prtCode, preNo, insQty, orderNo, dDay, preManager
		vo = type.get(0);
		
		service.startThread(vo);
	}

}

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
		return "admin/basicTab/code";
	}

	@GetMapping("/basicProduct")
	public String basicProduct(Model model) {
		model.addAttribute("code", service.getCodeList());
		return "admin/basicTab/product";
	}

	@GetMapping("/basicBOM")
	public String basicBOM(Model model) {
		model.addAttribute("mat", service.getBOMMatList());
		model.addAttribute("prt", service.getBOMPrtList());
		return "admin/basicTab/bom";
	}

	@GetMapping("/basicCompany")
	public String basicCompany() {
		return "admin/basicTab/company";
	}

	@GetMapping("/basicEmployee")
	public String basicEmployee(Model model) {
		model.addAttribute("dept", service.getDept());
		return "admin/basicTab/employee";
	}

	@GetMapping("/basicError")
	public String basicError(Model model) {
		model.addAttribute("err", service.getCodeList());
		return "admin/basicTab/error";
	}

	@GetMapping("/basicProcess")
	public String basicProcess(Model model) {
		model.addAttribute("eqm", service.eqmList());
		model.addAttribute("emp", serviceEM.getEmpList());
		return "admin/basicTab/process";
	}

	@GetMapping("/basicWarehouse")
	public String basicWarehouse() {
		return "admin/basicTab/warehouse";
	}

	@GetMapping("/basicWorker")
	public String basicWorker() {
		return "admin/basicTab/worker";
	}

	@GetMapping("/codeList")
	@ResponseBody
	public List<CodeVO> getCodeList(Model model) {
		return service.getCodeList();
	}

	@PostMapping("/selectDeleteCP")
	@ResponseBody
	public int selectDelete(@RequestParam(value = "code[]", required = false) List<String> code) {
		return service.selectDeleteCP(code);
	}

	@PostMapping("/codeCpList")
	@ResponseBody
	public List<CodeVO> getCpCode(@RequestBody String type) {
		List<CodeVO> list = service.getCodeList();
		List<CodeVO> list1 = new ArrayList<CodeVO>();

		for (int i = 0; i < list.size(); i++) {
			String code = list.get(i).getCode().substring(0, 3);

			if (code.equals("CP_") && type.contains("CP")) {
				list1.add(list.get(i));
			} else if (code.equals("EQM") && type.contains("EQM")) {
				list1.add(list.get(i));
			} else if (code.equals("PRS") && type.contains("PRS")) {
				list1.add(list.get(i));
			} else if (code.equals("ERP") && type.contains("ERP")) {
				list1.add(list.get(i));
			} else if (code.equals("ERM") && type.contains("ERM")) {
				list1.add(list.get(i));
			} else if (code.equals("PRD") && type.contains("PRD")) {
				list1.add(list.get(i));
			} else if (code.equals("MAT") && type.contains("MAT")) {
				list1.add(list.get(i));
			} else if (code.equals("EQS") && type.contains("EQS")) {
				list1.add(list.get(i));
			} else if (code.equals("UOR") && type.contains("UOR")) {
				list1.add(list.get(i));
			} else if (code.equals("PRG") && type.contains("PRG")) {
				list1.add(list.get(i));
			} else if (code.equals("STO") && type.contains("STO")) {
				list1.add(list.get(i));
			} else if (code.equals("CHK") && type.contains("CHK")) {
				list1.add(list.get(i));
			}
		}
		return list1;
	}

	@GetMapping("/bomList")
	@ResponseBody
	public List<CodeVO> bomList(@RequestParam(value = "prtName", required = false) String prtName) {
		CodeVO vo = new CodeVO();
		vo.setPrtName(prtName);
		
		return service.getBomList(vo);
	}
	
	@PostMapping("/user/orderNow")
	@ResponseBody
	public int orderNow(@RequestBody List<CodeVO> list) {
		return service.orderNow(list);
	}
	
	@GetMapping("/bomMenu")
	@ResponseBody
	public List<CodeVO> bomMenu() {
		return service.getBomMenu();
	}

	@PostMapping("/insertBOM")
	@ResponseBody
	public int insertBOM(@RequestParam(value = "nameList[]", required = false) List<String> nameList,
			@RequestParam(value = "capList[]", required = false) List<String> capList,
			@RequestParam(value = "matList[]", required = false) List<String> matList) {
		return service.insertBOM(nameList, capList, matList);
	}

	@PostMapping("/updateBOM")
	@ResponseBody
	public int updateBOM(@RequestParam(value = "mat[]", required = false) List<String> mat,
			@RequestParam(value = "cap[]", required = false) List<String> cap,
			@RequestParam(value = "prtName[]", required = false) List<String> prtName) {
		return service.updateBOM(mat, cap, prtName);
	}

	@PostMapping("/insertP")
	public String insertP(CodeVO vo) {
		return service.insertP(vo);
	}

	@GetMapping("/pList")
	@ResponseBody
	public List<CodeVO> pList() {
		return service.getPrtList();
	}

	@GetMapping("/mList")
	@ResponseBody
	public List<CodeVO> mList() {
		return service.getMatList1();
	}

	@PostMapping("/selectDeletePM")
	@ResponseBody
	public int selectDeletePM(@RequestParam(value = "prt[]", required = false) List<String> prt,
			@RequestParam(value = "mat[]", required = false) List<String> mat) {
		return service.selectDeletePM(prt, mat);
	}

	@GetMapping("/prList")
	@ResponseBody
	public List<CodeVO> prList() {
		return service.prList();
	}

	@PostMapping("/insertPrs")
	public String insertPrs(CodeVO vo) {
		service.insertPrsA(vo);
		return "redirect:basicProcess";
	}

	@PostMapping("/selectDeletePW")
	@ResponseBody
	public int selectDeletePW(@RequestParam(value = "prt[]", required = false) List<String> prt,
			@RequestParam(value = "mat[]", required = false) List<String> mat) {
		return service.selectDeletePW(prt, mat);
	}

	@GetMapping("/whList")
	@ResponseBody
	public List<CodeVO> whList() {
		return service.whList();
	}

	@PostMapping("/insertWh")
	public String insertWh(CodeVO vo) {
		service.insertWhA(vo);
		return "redirect:basicProcess";
	}

	@PostMapping("/updatePrs")
	@ResponseBody
	public int updatePrs(@RequestBody CodeVO vo) {
		CodeVO vo1 = new CodeVO();
		vo1.setCode(vo.getPrsCode());
		vo1.setCodeName(vo.getPrsName());
		return service.updatePrs(vo);
	}

	@PostMapping("/updateWh")
	@ResponseBody
	public int updateWh(@RequestBody CodeVO vo) {
		CodeVO vo1 = new CodeVO();
		vo1.setCode(vo.getWhCode());
		vo1.setCodeName(vo.getWhName());
		return service.updateWh(vo);
	}

	@GetMapping("/errList")
	@ResponseBody
	public List<CodeVO> errList() {
		return service.errList();
	}

	@PostMapping("/insertErr")
	public String inserErr(CodeVO vo) {
		return service.insertErrA(vo);
	}

	@PostMapping("/updateErr")
	@ResponseBody
	public int updateErr(@RequestBody CodeVO vo) {
		return service.updateErrA(vo);
	}

	@PostMapping("/workerAList")
	@ResponseBody
	public List<CodeVO> workerAList(@RequestBody String data) {
		CodeVO vo = new CodeVO();
		vo.setPreNo(data);
		return service.workerAList(vo);
	}

	@PostMapping("/workerBList")
	@ResponseBody
	public List<CodeVO> workerBList(@RequestBody String data) {
		CodeVO vo = new CodeVO();
		vo.setPreNo(data);
		return service.workerBList(vo);
	}

	@PostMapping("/updateWorker")
	@ResponseBody
	public Map<String, String> updateWorker(@RequestParam(value = "preNo[]", required = false) List<String> preNo,
			@RequestParam(value = "inputId[]", required = false) List<String> inputId,
			@RequestParam(value = "deleteId[]", required = false) List<String> deleteId) {
		return service.updateWorker(preNo, inputId, deleteId);
	}

	@GetMapping("/updatePrtCount")
	@ResponseBody
	public Map<String, String> updatePrtCount() {
		return service.updatePrtCountA();
	}

	@GetMapping("/updatePrtOutCount")
	@ResponseBody
	public Map<String, String> updatePrtOutCount() {
		return service.updatePrtOutCountA();
	}

	@GetMapping("/updateErrCount")
	@ResponseBody
	public Map<String, String> updateErrCount() {
		return service.updateErrCountA();
	}

	@PostMapping("/WhPrd")
	@ResponseBody
	public List<CodeVO> WhPrd(@RequestBody String type) {
		CodeVO vo = new CodeVO();
		vo.setWhCode(type.substring(5));
		return service.WhPrd(vo);
	}

	@GetMapping("/updatePrttCount")
	@ResponseBody
	public List<CodeVO> updatePrttCount() {
		return service.updatePrttCount();
	}

	@GetMapping("/selectPrdNameOut")
	@ResponseBody
	public List<CodeVO> selectPrdNameOut() {
		return service.selectPrtNameOut();
	}

	@GetMapping("/selectErrOut")
	@ResponseBody
	public List<CodeVO> selectErrOut() {
		return service.selectErrOut();
	}

	@GetMapping("/prsRun")
	@ResponseBody
	public List<CodeVO> selectPrsName() {
		return service.selectPrsName();
	}

	@GetMapping("/prsRunNow")
	@ResponseBody
	public List<CodeVO> selectPrsRunNow() {
		return service.selectPrsRunNow();
	}

	@GetMapping("/todayWL")
	@ResponseBody
	public List<CodeVO> todayWL() {
		return service.todayWL();
	}

	@PostMapping("/todayWLinf")
	@ResponseBody
	public List<CodeVO> todayWLinf(@RequestBody String type) {
		CodeVO vo = new CodeVO();
		vo.setPreNo(type.substring(5));
		return service.todayWLinf(vo);
	}

	@GetMapping("/prdCount")
	@ResponseBody
	public List<CodeVO> prdCount() {
		return service.prdCount();
	}

	@PostMapping("/startPr")
	@ResponseBody
	public int startPr(@RequestBody List<CodeVO> type) {
		int a = 0;

		Runnable prRunnable = new produceThread(type);
		Thread thread = new Thread(prRunnable);
		thread.start();
		return a;
	}
	
	@GetMapping("/msgUp")
	@ResponseBody
	public List<CodeVO> msgUp() {
		return service.msgUp();
	}
	
	@GetMapping("/msgUpA")
	@ResponseBody
	public List<CodeVO> msgUpA() {
		return service.msgUpA();
	}
	
	@GetMapping("/msgCount")
	@ResponseBody
	public CodeVO msgCount() {
		return service.msgCount();
	}
	
	@GetMapping("/deleteMsg")
	@ResponseBody
	public int deleteMsg() {
		return service.deleteMsg();
	}
	
	@PostMapping("/readMsg")
	@ResponseBody
	public int readMsg(@RequestBody CodeVO vo) {
		return service.readMsg(vo);
	}
	
	@PostMapping("/deleteOneMsg")
	@ResponseBody
	public int deleteOneMsg(@RequestBody CodeVO vo) {
		return service.deleteOneMsg(vo);
	}
	
	@PostMapping("/selectMPCode")
	@ResponseBody
	public Map<String, String> selectMPCode(@RequestBody CodeVO vo) {
		int a = service.selectMPCode(vo).getNo();
		Map<String, String> map = new HashMap<String, String>();
		map.put("no", Integer.toString(a));
		return map;
	}
}
