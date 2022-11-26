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
		System.out.println("aaaaaaaaa");

		CodeVO vo = new CodeVO();

		// 작업시작 empName, prtCode, preNo, insQty, orderNo, dDay, preManager
		vo = type.get(0);
		System.out.println(vo);

		// 주문량
		int prdOrder1 = vo.getInsQty();
		// 주문량 - 자재량
		int prdOrderA = prdOrder1 * 110 / 100;
		// 자재량
		int prdOrder = prdOrderA - (prdOrderA * 5 / 100);

		// 주문제품 bom 리스트
		List<CodeVO> bomList = new ArrayList<>();
		bomList = service.getBomListC(vo);
		// lot 찾기
		CodeVO voMat = new CodeVO();
		// lot 정보 담기용
		CodeVO voLot = new CodeVO();
		// lot 번호 리스트
		List<CodeVO> lotList = new ArrayList<>();
		// mat_out 번호
		List<CodeVO> matOutList = new ArrayList<>();

		// lot테이블, 자재출고 테이블
		for (int i = 0; i < bomList.size(); i++) {
			voMat.setMpCode(bomList.get(i).getMatCode());
			voMat.setLotQty(prdOrder);
			voLot = service.getLotMat(voMat);

			// lot 번호 리스트 담기
			lotList.add(voLot);

			// 자재출고 테이블 등록
			CodeVO voMout = new CodeVO();
			voMout.setLotNo(voLot.getLotNo());
			voMout.setMatOutQty(prdOrder);
			voMout.setMatOutNo(service.matOutNo().getMatOutNo());

			// matoutno 리스트 담기
			matOutList.add(voMout);
			service.insertMatOut(voMout);

			// lot 테이블 out_from 출고처용 공정코드 찾기
			voMout.setPrsCode(service.getMatPrs(voMout).getPrsCode());
			// lot 테이블 수량 출고처 변경
			service.useLotQty(voMout);
		}

		// 공정 종류 담는 list
		List<CodeVO> prsList = new ArrayList<>();
		prsList = service.selectPrsName();

		// process_run 테이블
		CodeVO voPR = new CodeVO();
		// process_inf 테이블
		CodeVO voPI = new CodeVO();
		// process_err 테이블
		CodeVO voPE = new CodeVO();

		// process_run, process_inf, process_err 테이블
		for (int i = 0; i < prsList.size(); i++) {
			// process_run insert
			String prsNo = service.prsNo().getPrsNo();
			voPR.setPrsNo(prsNo);
			voPR.setPrsCode(prsList.get(i).getPrsCode());
			voPR.setPreNo(vo.getPreNo());
			voPR.setPrsManager(vo.getPreManager());
			voPR.setMatOutNo(matOutList.get(i / 2).getMatOutNo());
			service.insertProcessRun(voPR);

			// process_inf insert
			String prfNo = service.prfNo().getPrsPfNo();
			voPI.setPrsPfNo(prfNo);
			voPI.setPrsNo(prsNo);
			service.insertProcessInf(voPI);

			if (i > prsList.size() / 2 - 1) {
				// process_err insert
				String prerrNo = service.processErrNo().getPrsErrNo();
				voPE.setPrsErrNo(prerrNo);
				voPE.setErrCode(service.getError(voPR).getErrCode());
				service.insertProcessErr(voPE);
			}

			// update
			int j = 0;
			int k = 0;
			// 10초후 완료 될 초당 생산량
			int prdOut = (prdOrder / 10);
			// 주문량 2000
			if (prdOrderA == 2200) {
				if (i == prsList.size() - 1) {

					// 완제품 공정
					while (j < prdOrder) {
						j += prdOut;

						k += prdOut * 1 / 100;

						if (j + (prdOrder % 10) == prdOrder) {
							j += prdOrder % 10;
							if (prdOrder % 100 > 10) {
								String a = Integer.toString(prdOrder % 100);
								k += Integer.parseInt(a.substring(0,1))+1;
							} else {
								k += prdOrder % 100;
							}
						}
						
						voPE.setPrsErrQty(k);
						service.upCountProcessErr(voPE);

						voPI.setPrsErrQty(k);
						service.upCountPIErr(voPI);
						
						
						if (j + (prdOrder % 10) == prdOrder) {
							service.endProcessInf(voPI);
						}

						voPR.setPrtQty(j - (k * (prsList.size() / 2)));
						service.endProcessRun(voPR);

						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}

					}

				} else {

					// 완제품 이전 공정
					while (j < prdOrder) {
						j += prdOut;

						// 불량수량
						if (i > prsList.size() / 2 - 1) {
							k += prdOut * 1 / 100;
							if (j + (prdOrder % 10) == prdOrder) {
								j += prdOrder % 10;
								if (prdOrder % 100 > 10) {
									String a = Integer.toString(prdOrder % 100);
									k += Integer.parseInt(a.substring(0,1))+1;
								} else {
									k += prdOrder % 100;
								}
							}
							voPE.setPrsErrQty(k);
							service.upCountProcessErr(voPE);

							voPI.setPrsErrQty(k);
							service.upCountPIErr(voPI);
						} else {
							voPI.setPrsOutPut(j);
							service.upCountProcessInf(voPI);
						}

						if (j + (prdOrder % 10) == prdOrder) {
							service.endProcessInf(voPI);
						}

						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
				
			} else {
				// 주문량 2200 이외
				if (i == prsList.size() - 1) {

					// 완제품 공정
					while (j < prdOrder) {
						j += prdOut;

						k += prdOut * 1 / 100;

						if (j + (prdOrder % 10) == prdOrder) {
							j += prdOrder % 10;
							if (prdOrder % 100 > 10) {
								String a = Integer.toString(prdOrder % 100);
								k += Integer.parseInt(a.substring(0,1))+1;
							} else {
								k += prdOrder % 100;
							}
						}
						
						voPE.setPrsErrQty(k);
						service.upCountProcessErr(voPE);

						voPI.setPrsErrQty(k);
						service.upCountPIErr(voPI);
						
						
						if (j + (prdOrder % 10) == prdOrder) {
							service.endProcessInf(voPI);
						}

						voPR.setPrtQty(j - (k * (prsList.size() / 2)));
						service.endProcessRun(voPR);
						
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}

					}

				} else {

					// 완제품 이전 공정
					while (j < prdOrder) {
						j += prdOut;

						// 불량수량
						if (i > prsList.size() / 2 - 1) {
							k += prdOut * 1 / 100;
							if (j + (prdOrder % 10) == prdOrder) {
								j += prdOrder % 10;
								if (prdOrder % 100 > 10) {
									String a = Integer.toString(prdOrder % 100);
									k += Integer.parseInt(a.substring(0,1))+1;
								} else {
									k += prdOrder % 100;
								}
							}
							voPE.setPrsErrQty(k);
							service.upCountProcessErr(voPE);

							voPI.setPrsErrQty(k);
							service.upCountPIErr(voPI);
						} else {
							voPI.setPrsOutPut(j);
							service.upCountProcessInf(voPI);
						}

						if (j + (prdOrder % 10) == prdOrder) {
							service.endProcessInf(voPI);
						}

						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			}
		}
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
		return "/admin/basicTab/code";
	}

	@GetMapping("/basicProduct")
	public String basicProduct(Model model) {
		model.addAttribute("code", service.getCodeList());
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
	public String basicError(Model model) {
		model.addAttribute("err", service.getCodeList());
		return "/admin/basicTab/error";
	}

	@GetMapping("/basicProcess")
	public String basicProcess(Model model) {
		model.addAttribute("eqm", service.eqmList());
		model.addAttribute("emp", serviceEM.getEmpList());
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
	public int selectDelete(@RequestParam(value = "code[]", required = false) List<String> code) {
		int a = 0;
		for (int i = 0; i < code.size(); i++) {
			String code1 = code.get(i).substring(0, 3);
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
				vo.setEqmCode(code.get(i));

				a += service.deleteEqm(vo);
				a += service.deleteCode(vo);
			} else if (code1.equals("PRS")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setPrsCode(code.get(i));

				a += service.deletePrs(vo);
				a += service.deleteCode(vo);
			} else if (code1.equals("ERP")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setErrCode(code.get(i));

				a += service.deleteErr(vo);
				a += service.deleteCode(vo);
			} else if (code1.equals("ERM")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setErrCode(code.get(i));

				a += service.deleteErr(vo);
				a += service.deleteCode(vo);
			} else if (code1.equals("PRD")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setPrtCode(code.get(i));

				a += service.deleteBOM(vo);
				a += service.selectDeleteP(vo);
				a += service.deleteCode(vo);
			} else if (code1.equals("MAT")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setMatCode(code.get(i));

				a += service.selectDeleteM(vo);
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
				vo.setWhCode(code.get(i));

				a += service.deleteWh(vo);
				a += service.deleteCode(vo);
			}
		}
		return a;
	}

	@PostMapping("/codeCpList")
	@ResponseBody
	public List<CodeVO> getCpCode(@RequestBody String type) {
		List<CodeVO> list = service.getCodeList();
		List<CodeVO> list1 = new ArrayList<CodeVO>();

		System.out.println(type);

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
	public int updateBOM(@RequestParam(value = "mat[]", required = false) List<String> mat,
			@RequestParam(value = "cap[]", required = false) List<String> cap,
			@RequestParam(value = "prtName[]", required = false) List<String> prtName) {
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

	@PostMapping("/insertP")
	public String insertP(CodeVO vo) {
		if (vo.getType().equals("mat")) {

			service.insertMat(vo);

			CodeVO vo1 = new CodeVO();
			vo.setMatName(vo.getName());

			vo1 = service.getMatCode(vo);
			vo1.setCode(vo1.getMatCode());
			vo1.setCodeName(vo.getName());
			vo1.setDivName("자재");
			vo1.setDivCode("MAT");

			service.insertCode(vo1);

		} else if (vo.getType().equals("prd")) {
			service.insertPrd(vo);

			CodeVO vo1 = new CodeVO();
			vo.setPrtName(vo.getName());

			vo1 = service.getPrtCode(vo);
			vo1.setCode(vo1.getPrtCode());
			vo1.setCodeName(vo.getName());
			vo1.setDivName("제품");
			vo1.setDivCode("PRD");

			service.insertCode(vo1);
		}

		return "redirect:basicProduct";
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
		int a = 0;
		if (prt != null) {
			for (int i = 0; i < prt.size(); i++) {
				CodeVO vo = new CodeVO();
				vo.setPrtCode(prt.get(i));
				vo.setCode(prt.get(i));
				a += service.deleteCode(vo);
				a += service.selectDeleteP(vo);
			}
		}

		if (mat != null) {
			for (int i = 0; i < mat.size(); i++) {
				CodeVO vo = new CodeVO();
				vo.setMatCode(mat.get(i));
				vo.setCode(mat.get(i));
				a += service.deleteCode(vo);
				a += service.selectDeleteM(vo);
			}
		}
		return a;
	}

	@GetMapping("/prList")
	@ResponseBody
	public List<CodeVO> prList() {
		return service.prList();
	}

	@PostMapping("/insertPrs")
	public String insertPrs(CodeVO vo) {

		service.insertPrs(vo);
		vo.setCode(vo.getPrsCode());
		vo.setDivName("공정");
		vo.setCodeName(vo.getPrsName());
		vo.setDivCode("PRS");
		service.insertCode(vo);
		return "redirect:basicProcess";
	}

	@PostMapping("/selectDeletePW")
	@ResponseBody
	public int selectDeletePW(@RequestParam(value = "prt[]", required = false) List<String> prt,
			@RequestParam(value = "mat[]", required = false) List<String> mat) {
		int a = 0;
		if (prt != null) {
			for (int i = 0; i < prt.size(); i++) {
				CodeVO vo = new CodeVO();
				vo.setPrsCode(prt.get(i));
				vo.setCode(prt.get(i));
				a += service.deleteCode(vo);
				a += service.deletePrs(vo);
			}
		}

		if (mat != null) {
			for (int i = 0; i < mat.size(); i++) {
				CodeVO vo = new CodeVO();
				vo.setWhCode(mat.get(i));
				vo.setCode(mat.get(i));
				a += service.deleteCode(vo);
				a += service.deleteWh(vo);
			}
		}
		return a;
	}

	@GetMapping("/whList")
	@ResponseBody
	public List<CodeVO> whList() {
		return service.whList();
	}

	@PostMapping("/insertWh")
	public String insertWh(CodeVO vo) {
		service.insertWh(vo);
		vo.setCode(vo.getWhCode());
		vo.setDivName("공장");
		vo.setCodeName(vo.getWhName());
		vo.setDivCode("STO");
		service.insertCode(vo);
		return "redirect:basicWarehouse";
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
		CodeVO vo1 = new CodeVO();
		vo1.setCode(vo.getErrCode());
		vo1.setCodeName(vo.getErrName());
		vo1.setDivName("불량");
		if (vo.getErrOption().equals("MAT")) {
			vo1.setDivCode("ERM");
		} else if (vo.getErrOption().equals("PRS")) {
			vo1.setDivCode("ERP");
		}
		service.insertCode(vo1);
		service.insertErr(vo);
		return "redirect:basicError";
	}

	@PostMapping("/updateErr")
	@ResponseBody
	public int updateErr(@RequestBody CodeVO vo) {
		CodeVO vo1 = new CodeVO();
		vo1.setCode(vo.getErrCode());
		vo1.setCodeName(vo.getErrName());
		service.updateCode(vo1);
		return service.updateErr(vo);
	}

	@PostMapping("/workerAList")
	@ResponseBody
	public List<CodeVO> workerAList(@RequestBody String data) {
		CodeVO vo = new CodeVO();
		vo.setPreNo(data);
		System.out.println(vo.getPrsNo() + "  aaaaaaaa");
		System.out.println(service.workerAList(vo));
		return service.workerAList(vo);
	}

	@PostMapping("/workerBList")
	@ResponseBody
	public List<CodeVO> workerBList(@RequestBody String data) {
		CodeVO vo = new CodeVO();
		vo.setPreNo(data);
		System.out.println(vo.getPrsNo());
		return service.workerBList(vo);
	}

	@PostMapping("/updateWorker")
	@ResponseBody
	public Map<String, String> updateWorker(@RequestParam(value = "preNo[]", required = false) List<String> preNo,
			@RequestParam(value = "inputId[]", required = false) List<String> inputId,
			@RequestParam(value = "deleteId[]", required = false) List<String> deleteId) {
		Map<String, String> map = new HashMap<>();

		int a = 0;
		CodeVO vo = new CodeVO();
		vo.setPreNo(preNo.get(0));

		String b = vo.getPreNo();
		if (inputId != null) {
			for (int i = 0; i < inputId.size(); i++) {
				vo.setEmpId(inputId.get(i));
				a += service.insertWM(vo);
			}
		}
		if (deleteId != null) {
			for (int i = 0; i < deleteId.size(); i++) {
				vo.setEmpId(deleteId.get(i));
				a += service.deleteWM(vo);
			}
		}
		if (a > 0) {
			map.put("msg", b);
			return map;
		} else {
			map.put("msg", "error");
			return map;
		}
	}

	@GetMapping("/updatePrtCount")
	@ResponseBody
	public Map<String, String> updatePrtCount() {
		Map<String, String> map = new HashMap<>();
		CodeVO vo = new CodeVO();
		vo = service.updatePrtCount();
		String a = "";
		String b = "";
		double c = -1;
		double d = -1;
		if (vo != null) {
			a = String.valueOf(vo.getPrtQty());
			c = Integer.parseInt(a);
		}
		vo = service.ydPrtCount();
		if (vo != null) {
			b = String.valueOf(vo.getPrtQty());
			d = Integer.parseInt(b);
		}
		if (c != -1 && d != -1) {
			b = String.valueOf("전일대비" + Math.round((c - d) / d * 100) + "%");
		}
		if (d == 0) {
			b = "전일실적없음";
		}
		map.put("count", a);
		map.put("percent", b);
		return map;
	}

	@GetMapping("/updatePrtOutCount")
	@ResponseBody
	public Map<String, String> updatePrtOutCount() {
		Map<String, String> map = new HashMap<>();
		CodeVO vo = new CodeVO();
		vo = service.updatePrtOutCount();
		String a = "";
		String b = "";
		double c = -1;
		double d = -1;
		if (vo != null) {
			a = String.valueOf(vo.getPrtQty());
			c = Integer.parseInt(a);
		}
		vo = service.ydPrtOutCount();
		if (vo != null) {
			b = String.valueOf(vo.getPrtQty());
			d = Integer.parseInt(b);
		}
		if (c != -1 && d != -1) {
			b = String.valueOf("전일대비" + Math.round((c - d) / d * 100) + "%");
		}
		if (d == 0) {
			b = "전일실적없음";
		}
		map.put("count", a);
		map.put("percent", b);
		return map;
	}

	@GetMapping("/updateErrCount")
	@ResponseBody
	public Map<String, String> updateErrCount() {
		Map<String, String> map = new HashMap<>();
		CodeVO vo = new CodeVO();
		vo = service.updateErrCount();
		String a = "";
		String b = "";
		double c = -1;
		double d = -1;
		if (vo != null) {
			a = String.valueOf(vo.getPrtQty());
			c = Integer.parseInt(a);
		}
		vo = service.ydErrCount();
		if (vo != null) {
			b = String.valueOf(vo.getPrtQty());
			d = Integer.parseInt(b);
		}
		if (c != -1 && d != -1) {
			b = String.valueOf("전일대비" + Math.round((c - d) / d * 100) + "%");
		}
		if (d == 0) {
			b = "전일실적없음";
		}
		map.put("count", a);
		map.put("percent", b);
		return map;
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
}
