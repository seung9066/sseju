package com.sseju.java.code.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.code.mapper.CodeMapper;
import com.sseju.java.code.service.CodeService;
import com.sseju.java.code.service.CodeVO;
import com.sseju.java.company.mapper.CompanyMapper;
import com.sseju.java.company.service.CompanyVO;
import com.sseju.java.employee.mapper.EmployeeMapper;
import com.sseju.java.employee.service.EmployeeVO;

@Service
public class CodeServiceImpl implements CodeService {

	@Autowired
	CodeMapper mapper;

	@Autowired
	EmployeeMapper mapperEMP;

	@Autowired
	CompanyMapper mapperCP;

	@Override
	public List<CodeVO> getCodeList() {
		// TODO Auto-generated method stub
		return mapper.getCodeList();
	}

	@Override
	public CodeVO getCodeInfo(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getCodeInfo(vo);
	}

	@Override
	public int insertCode(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertCode(vo);
	}

	@Override
	public int updateCode(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateCode(vo);
	}

	@Override
	public int deleteCode(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteCode(vo);
	}

	@Override
	public int selectDelete(List<String> list) {
		// TODO Auto-generated method stub
		return mapper.selectDelete(list);
	}

	@Override
	public List<CodeVO> getBomList(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getBomList(vo);
	}

	@Override
	public List<CodeVO> getBomMenu() {
		// TODO Auto-generated method stub
		return mapper.getBomMenu();
	}

	@Override
	public List<CodeVO> getBOMMatList() {
		// TODO Auto-generated method stub
		return mapper.getBOMMatList();
	}

	@Override
	public CodeVO getPrtCode(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getPrtCode(vo);
	}

	@Override
	public CodeVO getMatCode(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getMatCode(vo);
	}

	@Override
	public int insertBOM(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertBOM(vo);
	}

	@Override
	public List<CodeVO> getBOMPrtList() {
		// TODO Auto-generated method stub
		return mapper.getBOMPrtList();
	}

	@Override
	public List<EmployeeVO> getDept() {
		// TODO Auto-generated method stub
		return mapper.getDept();
	}

	@Override
	public int deleteBOM(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteBOM(vo);
	}

	@Override
	public int deleteWh(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteWh(vo);
	}

	@Override
	public int insertMat(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertMat(vo);
	}

	@Override
	public int insertPrd(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertPrd(vo);
	}

	@Override
	public List<CodeVO> getPrtList() {
		// TODO Auto-generated method stub
		return mapper.getPrtList();
	}

	@Override
	public List<CodeVO> getMatList() {
		// TODO Auto-generated method stub
		return mapper.getMatList();
	}

	@Override
	public List<CodeVO> getMatList1() {
		// TODO Auto-generated method stub
		return mapper.getMatList1();
	}

	@Override
	public int selectDeleteP(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.selectDeleteP(vo);
	}

	@Override
	public int selectDeleteM(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.selectDeleteM(vo);
	}

	@Override
	public List<CodeVO> prList() {
		// TODO Auto-generated method stub
		return mapper.prList();
	}

	@Override
	public int insertPrs(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertPrs(vo);
	}

	@Override
	public int deletePrs(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deletePrs(vo);
	}

	@Override
	public List<CodeVO> eqmList() {
		// TODO Auto-generated method stub
		return mapper.eqmList();
	}

	@Override
	public List<CodeVO> whList() {
		// TODO Auto-generated method stub
		return mapper.whList();
	}

	@Override
	public int insertWh(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertWh(vo);
	}

	@Override
	public int updatePrs(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.updatePrs(vo);
	}

	@Override
	public int updateWh(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateWh(vo);
	}

	@Override
	public List<CodeVO> errList() {
		// TODO Auto-generated method stub
		return mapper.errList();
	}

	@Override
	public List<CodeVO> matprsList() {
		// TODO Auto-generated method stub
		return mapper.matprsList();
	}

	@Override
	public int insertErr(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertErr(vo);
	}

	@Override
	public int deleteErr(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteErr(vo);
	}

	@Override
	public int updateErr(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateErr(vo);
	}

	@Override
	public List<CodeVO> workerList() {
		// TODO Auto-generated method stub
		return mapper.workerList();
	}

	@Override
	public int deleteEqm(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteEqm(vo);
	}

	@Override
	public List<CodeVO> workerAList(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.workerAList(vo);
	}

	@Override
	public List<CodeVO> workerBList(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.workerBList(vo);
	}

	@Override
	public int insertEmpMng(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertEmpMng(vo);
	}

	@Override
	public int insertWM(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertWM(vo);
	}

	@Override
	public int deleteWM(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteWM(vo);
	}

	@Override
	public CodeVO updatePrtCount() {
		// TODO Auto-generated method stub
		return mapper.updatePrtCount();
	}

	@Override
	public CodeVO updatePrtOutCount() {
		// TODO Auto-generated method stub
		return mapper.updatePrtOutCount();
	}

	@Override
	public CodeVO updateErrCount() {
		// TODO Auto-generated method stub
		return mapper.updateErrCount();
	}

	@Override
	public List<CodeVO> WhPrd(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.WhPrd(vo);
	}

	@Override
	public List<CodeVO> updatePrttCount() {
		// TODO Auto-generated method stub
		return mapper.updatePrttCount();
	}

	@Override
	public CodeVO ydPrtCount() {
		// TODO Auto-generated method stub
		return mapper.ydPrtCount();
	}

	@Override
	public CodeVO ydPrtOutCount() {
		// TODO Auto-generated method stub
		return mapper.ydPrtOutCount();
	}

	@Override
	public CodeVO ydErrCount() {
		// TODO Auto-generated method stub
		return mapper.ydErrCount();
	}

	@Override
	public List<CodeVO> selectPrtNameOut() {
		// TODO Auto-generated method stub
		return mapper.selectPrtNameOut();
	}

	@Override
	public List<CodeVO> selectErrOut() {
		// TODO Auto-generated method stub
		return mapper.selectErrOut();
	}

	@Override
	public List<CodeVO> selectPrsName() {
		// TODO Auto-generated method stub
		return mapper.selectPrsName();
	}

	@Override
	public List<CodeVO> selectPrsRunNow() {
		// TODO Auto-generated method stub
		return mapper.selectPrsRunNow();
	}

	@Override
	public List<CodeVO> todayWL() {
		// TODO Auto-generated method stub
		return mapper.todayWL();
	}

	@Override
	public List<CodeVO> todayWLinf(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.todayWLinf(vo);
	}

	@Override
	public List<CodeVO> prdCount() {
		// TODO Auto-generated method stub
		return mapper.prdCount();
	}

	@Override
	public List<CodeVO> getBomListC(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getBomListC(vo);
	}

	@Override
	public CodeVO getLotMat(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getLotMat(vo);
	}

	@Override
	public int insertMatOut(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertMatOut(vo);
	}

	@Override
	public int useLotQty(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.useLotQty(vo);
	}

	@Override
	public CodeVO getMatPrs(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getMatPrs(vo);
	}

	@Override
	public CodeVO matOutNo() {
		// TODO Auto-generated method stub
		return mapper.matOutNo();
	}

	@Override
	public CodeVO prsNo() {
		// TODO Auto-generated method stub
		return mapper.prsNo();
	}

	@Override
	public int insertProcessRun(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertProcessRun(vo);
	}

	@Override
	public CodeVO prfNo() {
		// TODO Auto-generated method stub
		return mapper.prfNo();
	}

	@Override
	public int insertProcessInf(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertProcessInf(vo);
	}

	@Override
	public List<CodeVO> getError(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getError(vo);
	}

	@Override
	public CodeVO processErrNo() {
		// TODO Auto-generated method stub
		return mapper.processErrNo();
	}

	@Override
	public int insertProcessErr(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertProcessErr(vo);
	}

	@Override
	public int upCountProcessInf(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.upCountProcessInf(vo);
	}

	@Override
	public int upCountProcessErr(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.upCountProcessErr(vo);
	}

	@Override
	public int upCountPIErr(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.upCountPIErr(vo);
	}

	@Override
	public int endProcessInf(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.endProcessInf(vo);
	}

	@Override
	public int endProcessRun(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.endProcessRun(vo);
	}

	@Override
	public int insertLot(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertLot(vo);
	}

	@Override
	public List<CodeVO> WHListA() {
		// TODO Auto-generated method stub
		return mapper.WHListA();
	}

	@Override
	public int updateEqm(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateEqm(vo);
	}

	@Override
	public int selectDeleteCP(List<String> code) {
		int a = 0;
		for (int i = 0; i < code.size(); i++) {
			String code1 = code.get(i).substring(0, 3);
			System.out.println(code1);
			if (code1.equals("CP_")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));

				CompanyVO vocp = new CompanyVO();
				vocp.setCpCode(code.get(i));

				vocp = mapperCP.getCompanyInfo(vocp);
				EmployeeVO voEM = new EmployeeVO();
				voEM.setId(vocp.getId());

				a += mapper.deleteCode(vo);
				a += mapperCP.deleteCompany(vocp);
				a += mapperEMP.deleteLogin(voEM);
			} else if (code1.equals("EQM")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setEqmCode(code.get(i));

				a += mapper.deleteEqm(vo);
				a += mapper.deleteCode(vo);
			} else if (code1.equals("PRS")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setPrsCode(code.get(i));

				a += mapper.deletePrs(vo);
				a += mapper.deleteCode(vo);
			} else if (code1.equals("ERP")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setErrCode(code.get(i));

				a += mapper.deleteErr(vo);
				a += mapper.deleteCode(vo);
			} else if (code1.equals("ERM")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setErrCode(code.get(i));

				a += mapper.deleteErr(vo);
				a += mapper.deleteCode(vo);
			} else if (code1.equals("PRD")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setPrtCode(code.get(i));

				a += mapper.deleteBOM(vo);
				a += mapper.selectDeleteP(vo);
				a += mapper.deleteCode(vo);
			} else if (code1.equals("MAT")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setMatCode(code.get(i));

				a += mapper.selectDeleteM(vo);
				a += mapper.deleteCode(vo);
			} else if (code1.equals("EQS")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));

				a += mapper.deleteCode(vo);
			} else if (code1.equals("UOR")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));

				a += mapper.deleteCode(vo);
			} else if (code1.equals("PRG")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));

				a += mapper.deleteCode(vo);
			} else if (code1.equals("STO")) {
				CodeVO vo = new CodeVO();
				vo.setCode(code.get(i));
				vo.setWhCode(code.get(i));

				a += mapper.deleteWh(vo);
				a += mapper.deleteCode(vo);
			}
		}
		return a;
	}

	@Override
	public int insertBOM(List<String> nameList, List<String> capList, List<String> matList) {
		int a = 0;
		for (int i = 0; i < nameList.size(); i++) {
			CodeVO vo = new CodeVO();
			vo.setPrtName(nameList.get(i));
			vo.setMatName(matList.get(i));
			vo.setCapacity(capList.get(i));

			CodeVO vomat = new CodeVO();
			vomat = mapper.getMatCode(vo);

			CodeVO voprt = new CodeVO();
			voprt = mapper.getPrtCode(vo);

			vo.setPrtCode(voprt.getPrtCode());
			vo.setMatCode(vomat.getMatCode());

			a += mapper.insertBOM(vo);
		}
		return a;
	}

	@Override
	public int updateBOM(List<String> mat, List<String> cap, List<String> prtName) {
		int a = 0;

		CodeVO vo = new CodeVO();
		vo.setPrtName(prtName.get(0));
		vo = mapper.getPrtCode(vo);
		mapper.deleteBOM(vo);

		for (int i = 0; i < mat.size(); i++) {
			CodeVO vo1 = new CodeVO();
			vo1.setMatName(mat.get(i));

			CodeVO voa = new CodeVO();
			voa.setMatCode(mapper.getMatCode(vo1).getMatCode());
			voa.setCapacity(cap.get(i));
			voa.setPrtCode(vo.getPrtCode());

			a += mapper.insertBOM(voa);
		}
		return a;
	}

	@Override
	public String insertP(CodeVO vo) {
		if (vo.getType().equals("mat")) {

			mapper.insertMat(vo);

			CodeVO vo1 = new CodeVO();
			vo.setMatName(vo.getName());

			vo1 = mapper.getMatCode(vo);
			vo1.setCode(vo1.getMatCode());
			vo1.setCodeName(vo.getName());
			vo1.setDivName("자재");
			vo1.setDivCode("MAT");

			mapper.insertCode(vo1);

		} else if (vo.getType().equals("prd")) {
			mapper.insertPrd(vo);

			CodeVO vo1 = new CodeVO();
			vo.setPrtName(vo.getName());

			vo1 = mapper.getPrtCode(vo);
			vo1.setCode(vo1.getPrtCode());
			vo1.setCodeName(vo.getName());
			vo1.setDivName("제품");
			vo1.setDivCode("PRD");

			mapper.insertCode(vo1);
		}

		return "redirect:basicProduct";
	}

	@Override
	public int selectDeletePM(List<String> prt, List<String> mat) {
		int a = 0;
		if (prt != null) {
			for (int i = 0; i < prt.size(); i++) {
				CodeVO vo = new CodeVO();
				vo.setPrtCode(prt.get(i));
				vo.setCode(prt.get(i));
				a += mapper.deleteCode(vo);
				a += mapper.selectDeleteP(vo);
			}
		}

		if (mat != null) {
			for (int i = 0; i < mat.size(); i++) {
				CodeVO vo = new CodeVO();
				vo.setMatCode(mat.get(i));
				vo.setCode(mat.get(i));
				a += mapper.deleteCode(vo);
				a += mapper.selectDeleteM(vo);
			}
		}
		return a;
	}

	@Override
	public String insertPrsA(CodeVO vo) {
		mapper.insertPrs(vo);
		vo.setCode(vo.getPrsCode());
		vo.setDivName("공정");
		vo.setCodeName(vo.getPrsName());
		vo.setDivCode("PRS");
		mapper.insertCode(vo);
		return "redirect:basicProcess";
	}

	@Override
	public int selectDeletePW(List<String> prt, List<String> mat) {
		int a = 0;
		if (prt != null) {
			for (int i = 0; i < prt.size(); i++) {
				CodeVO vo = new CodeVO();
				vo.setPrsCode(prt.get(i));
				vo.setCode(prt.get(i));
				a += mapper.deleteCode(vo);
				a += mapper.deletePrs(vo);
			}
		}

		if (mat != null) {
			for (int i = 0; i < mat.size(); i++) {
				CodeVO vo = new CodeVO();
				vo.setWhCode(mat.get(i));
				vo.setCode(mat.get(i));
				a += mapper.deleteCode(vo);
				a += mapper.deleteWh(vo);
			}
		}
		return a;
	}

	@Override
	public String insertWhA(CodeVO vo) {
		mapper.insertWh(vo);
		vo.setCode(vo.getWhCode());
		vo.setDivName("공장");
		vo.setCodeName(vo.getWhName());
		vo.setDivCode("STO");
		mapper.insertCode(vo);
		return "redirect:basicWarehouse";
	}

	@Override
	public String insertErrA(CodeVO vo) {
		CodeVO vo1 = new CodeVO();
		vo1.setCode(vo.getErrCode());
		vo1.setCodeName(vo.getErrName());
		vo1.setDivName("불량");
		if (vo.getErrOption().equals("MAT")) {
			vo1.setDivCode("ERM");
		} else if (vo.getErrOption().equals("PRS")) {
			vo1.setDivCode("ERP");
		}
		mapper.insertCode(vo1);
		mapper.insertErr(vo);
		return "redirect:basicError";
	}

	@Override
	public int updateErrA(CodeVO vo) {
		CodeVO vo1 = new CodeVO();
		vo1.setCode(vo.getErrCode());
		vo1.setCodeName(vo.getErrName());
		mapper.updateCode(vo1);
		return mapper.updateErr(vo);
	}

	@Override
	public Map<String, String> updateWorker(List<String> preNo, List<String> inputId, List<String> deleteId) {
		Map<String, String> map = new HashMap<>();

		int a = 0;
		CodeVO vo = new CodeVO();
		vo.setPreNo(preNo.get(0));

		String b = vo.getPreNo();
		if (inputId != null) {
			for (int i = 0; i < inputId.size(); i++) {
				vo.setEmpId(inputId.get(i));
				a += mapper.insertWM(vo);
			}
		}
		if (deleteId != null) {
			for (int i = 0; i < deleteId.size(); i++) {
				vo.setEmpId(deleteId.get(i));
				a += mapper.deleteWM(vo);
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

	@Override
	public List<CodeVO> MatBomList(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.MatBomList(vo);
	}

	@Override
	public int insertMatBuy(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertMatBuy(vo);
	}
	
	// 생산량 카운트
	@Override
	public Map<String, String> updatePrtCountA() {
		Map<String, String> map = new HashMap<>();
		CodeVO vo = new CodeVO();
		vo = mapper.updatePrtCount();
		String a = "";
		String b = "";
		double c = -1;
		double d = -1;
		if (vo != null) {
			a = String.valueOf(vo.getPrtQty());
			c = Integer.parseInt(a);
		}
		vo = mapper.ydPrtCount();
		if (vo != null) {
			b = String.valueOf(vo.getPrtQty());
			d = Integer.parseInt(b);
		}
		if (c != -1 && d != -1) {
			b = String.valueOf("전일대비" + Math.round((c - d) / d * 100) + "%");
			if (b.equals("전일대비-100%")) {
				b = "금일생산량없음";
			}
		}
		if (d == 0) {
			b = "전일실적없음";
		}
		map.put("count", a);
		map.put("percent", b);
		return map;
	}

	@Override
	public Map<String, String> updatePrtOutCountA() {
		Map<String, String> map = new HashMap<>();
		CodeVO vo = new CodeVO();
		vo = mapper.updatePrtOutCount();
		String a = "";
		String b = "";
		double c = -1;
		double d = -1;
		if (vo != null) {
			a = String.valueOf(vo.getPrtQty());
			c = Integer.parseInt(a);
		}
		vo = mapper.ydPrtOutCount();
		if (vo != null) {
			b = String.valueOf(vo.getPrtQty());
			d = Integer.parseInt(b);
		}
		if (c != -1 && d != -1) {
			b = String.valueOf("전일대비" + Math.round((c - d) / d * 100) + "%");
			if (b.equals("전일대비-100%")) {
				b = "금일생산량없음";
			}
		}
		if (d == 0) {
			b = "전일실적없음";
		}
		map.put("count", a);
		map.put("percent", b);
		return map;
	}

	@Override
	public Map<String, String> updateErrCountA() {
		Map<String, String> map = new HashMap<>();
		CodeVO vo = new CodeVO();
		vo = mapper.updateErrCount();
		String a = "";
		String b = "";
		double c = -1;
		double d = -1;
		if (vo != null) {
			a = String.valueOf(vo.getPrtQty());
			c = Integer.parseInt(a);
		}
		vo = mapper.ydErrCount();
		if (vo != null) {
			b = String.valueOf(vo.getPrtQty());
			d = Integer.parseInt(b);
		}
		if (c != -1 && d != -1) {
			b = String.valueOf("전일대비" + Math.round((c - d) / d * 100) + "%");
			if (b.equals("전일대비-100%")) {
				b = "금일생산량없음";
			}
		}
		if (d == 0) {
			b = "전일실적없음";
		}
		map.put("count", a);
		map.put("percent", b);
		return map;
	}

	@Override
	public void startThread(CodeVO vo) {
		// 주문량
		int prdOrder1 = vo.getInsQty();
		// 주문량 - 자재량
		int prdOrderA = prdOrder1 * 110 / 100;
		// 자재량
		int prdOrder = prdOrderA - (prdOrderA * 5 / 100);

		// msg 테이블
		CodeVO voMsg = new CodeVO();
		// 주문제품 bom 리스트
		System.out.println("ㅁBOM리스");
		List<CodeVO> bomList = new ArrayList<>();
		bomList = mapper.getBomListC(vo);
		// lot 찾기
		CodeVO voMat = new CodeVO();
		// lot 정보 담기용
		CodeVO voLot = new CodeVO();
		// lot 번호 리스트
		List<CodeVO> lotList = new ArrayList<>();
		// mat_out 번호
		List<CodeVO> matOutList = new ArrayList<>();

		voMsg.setMsg("자재 출고 완료 : " + bomList.size() + " 종류");
		mapper.insertMsg(voMsg);
		
		voMsg.setMsg("생산 시작 : " + vo.getPrtCode());
		mapper.insertMsg(voMsg);
		
		// lot테이블, 자재출고 테이블
		for (int i = 0; i < bomList.size(); i++) {
			System.out.println("ㅁlot수량 줄이기");
			voMat.setMpCode(bomList.get(i).getMatCode());
			voMat.setLotQty(prdOrder);
			voLot = mapper.getLotMat(voMat);

			// lot 번호 리스트 담기
			lotList.add(voLot);

			// 자재출고 테이블 등록
			System.out.println("ㅁ자재출고 테이블 등록");
			CodeVO voMout = new CodeVO();
			voMout.setLotNo(voLot.getLotNo());
			voMout.setMatOutQty(prdOrder);
			voMout.setMatOutNo(mapper.matOutNo().getMatOutNo());

			// matoutno 리스트 담기
			System.out.println("ㅁmatoutno");
			matOutList.add(voMout);
			mapper.insertMatOut(voMout);

			// lot 테이블 out_from 출고처용 공정코드 찾기
			System.out.println("ㅁlot테이블 공정코드 찾");
			voMout.setPrsCode(mapper.getMatPrs(voMat).getPrsCode());
			// lot 테이블 수량 출고처 변경
			System.out.println("ㅁlot테이블 수량, 출고처");
			mapper.useLotQty(voMout);
		}

		// process_run 테이블
		CodeVO voPR = new CodeVO();
		// process_inf 테이블
		CodeVO voPI = new CodeVO();
		// process_err 테이블
		CodeVO voPE = new CodeVO();
		// error 테이블
		CodeVO voER = new CodeVO();

		// 공정 종류 담는 list
		System.out.println("ㅁ공정종류");
		List<CodeVO> prsList = new ArrayList<>();
		prsList = mapper.selectPrsName();

		// prspfno 담을 리스트
		List<String> prspfnoList = new ArrayList<>();

		CodeVO voEqm = new CodeVO();

		// process_run, process_inf, process_err 테이블
		for (int i = 0; i < prsList.size(); i++) {
			System.out.println("ㅁprocess_run");
			// process_run insert
			String prsNo = mapper.prsNo().getPrsNo();
			voPR.setPrsNo(prsNo);
			voPR.setPrsCode(prsList.get(i).getPrsCode());
			voPR.setPreNo(vo.getPreNo());
			voPR.setPrsManager(vo.getPreManager());
			voPR.setMatOutNo(matOutList.get(i / 2).getMatOutNo());
			mapper.insertProcessRun(voPR);

			// process_inf insert
			System.out.println("ㅁprocess_inf");
			String prfNo = mapper.prfNo().getPrfNo();
			voPI.setPrsPfNo(prfNo);

			// prspfno 리스트 담기
			prspfnoList.add(prfNo);
			voPI.setPrsNo(prsNo);
			mapper.insertProcessInf(voPI);

			if (i > prsList.size() / 2 - 1) {
				// process_err insert
				System.out.println("ㅁprocess_err");
				String prerrNo = mapper.processErrNo().getPrsErrNo();
				voPE.setPrsErrNo(prerrNo);
				System.out.println("ㅁprocess_err2");
				voPE.setPrsPfNo(prfNo);
				List<CodeVO> ErrList = mapper.getError(voPR);
				int err = (int) Math.random() * ErrList.size();
				voPE.setErrCode(ErrList.get(err).getErrCode());
				mapper.insertProcessErr(voPE);
			}

			// 완제품 lot에 insert
			CodeVO voLotI = new CodeVO();
			// 창고 리스트용
			System.out.println("ㅁ창고리스트");
			List<CodeVO> whList = new ArrayList<>();
			whList = mapper.WHListA();

			// 공정별 eqm코드 담기
			System.out.println("ㅁ공정별 eqm코드");
			voEqm.setEqmCode(prsList.get(i).getEqmCode());

			// 10초후 완료 될 초당 생산량
			int prdOut = (prdOrder / 10);
			System.out.println("생산시작");

			// update
			int j = 0;
			int k = 0;
			// 주문량 3000
			if (prdOrderA == 3300) {

				if (i == prsList.size() - 1) {

					System.out.println("ㅁ설비 가동");
					mapper.updateEqm(voEqm);

					int wh = whList.size();
					int whCode = (int) (Math.random() * wh);
					for (int q = 0; q < wh; q++) {
						if (q == whCode) {
							voLotI.setWhCode(whList.get(q).getWhCode());
						}
					}

					voLotI.setLotNo(mapper.getLotNo().getLotNo());
					voLotI.setMpCode(vo.getPrtCode());
					voLotI.setOutFrom(vo.getOrderNo());
					mapper.insertLot(voLotI);

					prdOut = 3135;
					j = 0;
					k = 0;

					// 완제품 공정
					while (j < prdOrder) {
						
						j += prdOut / 3;
						k = prdOut * 1 / 100;
						
						if (j == prdOrder) {
							k += 2;
						}

						System.out.println("ㅁprocessErr up");
						voPE.setPrsErrQty(k);
						mapper.upCountProcessErr(voPE);

						System.out.println("ㅁprocessInf up");
						voPI.setPrsErrQty(k);
						mapper.upCountPIErr(voPI);

						System.out.println("ㅁ완제품수량");
						voPR.setPrtQty(j - (k * (prsList.size() / 2)));
						mapper.endProcessRun(voPR);

						voLotI.setLotQty(j - (k * (prsList.size() / 2)));

						System.out.println("ㅁlot완제품");
						mapper.updateLotQty(voLotI);

						if (j == prdOrder) {
							voPR.setPrtQty(prdOrder1);
							mapper.endProcessRun(voPR);
							System.out.println("ㅁ작업중단시간");
							voPI.setPrsPfNo(prspfnoList.get(i));
							mapper.endProcessInf(voPI);
							System.out.println("ㅁ설비중지");
							mapper.updateEqm(voEqm);
							System.out.println("produce 업데이트 prePrg");
							mapper.updateProducePrePrg(vo);
							voMsg.setMsg("제품 생산 완료 : " + vo.getPrtCode());
							mapper.insertMsg(voMsg);
							voMsg.setMsg("제품 창고 입고 완료 : " + vo.getPrtCode());
							mapper.insertMsg(voMsg);
						}
						
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}

					}

				} else {
					System.out.println("ㅁ설비가동");
					mapper.updateEqm(voEqm);

					prdOut = 3135;
					j = 0;
					k = prdOut * 1 / 100;

					// 완제품 이전 공정
					while (j < prdOrder) {
						
						k = prdOrderA * 1 / 100;
						j += prdOut / 3;
						
						// 불량수량
						if (i > prsList.size() / 2 - 1) {

							System.out.println("ㅁprocessErr up");
							voPE.setPrsErrQty(k);
							mapper.upCountProcessErr(voPE);

							System.out.println("ㅁprocessInfErr up");
							voPI.setPrsErrQty(k);
							mapper.upCountPIErr(voPI);
						} else {
							System.out.println("ㅁprocessInf 생산량");
							voPI.setPrsOutPut(j);
							mapper.upCountProcessInf(voPI);
						}

						if (j == prdOrder) {
							System.out.println("ㅁprocessInf 중단시간");
							voPI.setPrsPfNo(prspfnoList.get(i));
							mapper.endProcessInf(voPI);
							System.out.println("ㅁ설비중지");
							mapper.updateEqm(voEqm);
						}
						
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}

			} else {
				// 공정수량 증가
				if (i == prsList.size() - 1) {

					System.out.println("ㅁ설비 가동");
					mapper.updateEqm(voEqm);

					int wh = whList.size();
					int whCode = (int) (Math.random() * wh);
					for (int q = 0; q < wh; q++) {
						if (q == whCode) {
							voLotI.setWhCode(whList.get(q).getWhCode());
						}
					}

					voLotI.setLotNo(mapper.getLotNo().getLotNo());
					voLotI.setMpCode(vo.getPrtCode());
					voLotI.setOutFrom(vo.getOrderNo());
					mapper.insertLot(voLotI);

					prdOut = prdOrder;
					j = 0;
					k = prdOut * 1 / 100;

					// 완제품 공정
					while (j < prdOrder) {
						
						j += prdOut / 10;

						if (j == prdOrder) {
							String z = Integer.toString(prdOut % 100);
							if (z.length() == 2) {
								if (Integer.parseInt(z.substring(1)) != 0) {
									k += Integer.parseInt(z.substring(0, 1)) + 1;
								} else {
									k += Integer.parseInt(z.substring(0, 1));
								}
							} else {
								k += prdOut % 100;
							}
						}

						if (j + (prdOrder % 10) == prdOrder) {
							j += (prdOrder % 10);
							String z = Integer.toString(prdOut % 100);
							if (z.length() == 2) {
								if (Integer.parseInt(z.substring(1)) != 0) {
									k += Integer.parseInt(z.substring(0, 1)) + 1;
								} else {
									k += Integer.parseInt(z.substring(0, 1));
								}
							} else {
								k += prdOut % 100;
							}
						}

						System.out.println("ㅁprocessErr up");
						voPE.setPrsErrQty(k);
						mapper.upCountProcessErr(voPE);

						System.out.println("ㅁprocessInf up");
						voPI.setPrsErrQty(k);
						mapper.upCountPIErr(voPI);

						System.out.println("ㅁ완제품수량");
						voPR.setPrtQty(j - (k * (prsList.size() / 2)));
						mapper.endProcessRun(voPR);

						voLotI.setLotQty(j - (k * (prsList.size() / 2)));

						System.out.println("ㅁlot완제품");
						mapper.updateLotQty(voLotI);

						if (j == prdOrder || j + (prdOrder % 10) == prdOrder) {
							voPR.setPrtQty(prdOrder1);
							mapper.endProcessRun(voPR);
							System.out.println("ㅁ작업중단시간");
							voPI.setPrsPfNo(prspfnoList.get(i));
							mapper.endProcessInf(voPI);
							System.out.println("ㅁ설비중지");
							mapper.updateEqm(voEqm);
							System.out.println("produce 업데이트 prePrg");
							mapper.updateProducePrePrg(vo);
							voMsg.setMsg("제품 생산 완료 : " + vo.getPrtCode());
							mapper.insertMsg(voMsg);
							voMsg.setMsg("제품 창고 입고 완료 : " + vo.getPrtCode());
							mapper.insertMsg(voMsg);
						}
						
						k = prdOrderA * 1 / 100;
						
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}

					}

				} else {
					System.out.println("ㅁ설비가동");
					mapper.updateEqm(voEqm);

					prdOut = prdOrder;
					j = 0;
					k = prdOut * 1 / 100;

					// 완제품 이전 공정
					while (j < prdOrder) {
						
						j += prdOut / 10;

						// 불량수량
						if (i > prsList.size() / 2 - 1) {

							System.out.println("ㅁprocessErr up");
							voPE.setPrsErrQty(k);
							mapper.upCountProcessErr(voPE);

							System.out.println("ㅁprocessInfErr up");
							voPI.setPrsErrQty(k);
							mapper.upCountPIErr(voPI);

							if (j == prdOrder) {
								String z = Integer.toString(prdOut % 100);
								if (z.length() == 2) {
									if (Integer.parseInt(z.substring(1)) != 0) {
										k += Integer.parseInt(z.substring(0, 1)) + 1;
									} else {
										k += Integer.parseInt(z.substring(0, 1));
									}
								} else {
									k += prdOut % 100;
								}
							}

							if (j + (prdOrder % 10) == prdOrder) {
								j += (prdOrder % 10);
								String z = Integer.toString(prdOut % 100);
								if (z.length() == 2) {
									if (Integer.parseInt(z.substring(1)) != 0) {
										k += Integer.parseInt(z.substring(0, 1)) + 1;
									} else {
										k += Integer.parseInt(z.substring(0, 1));
									}
								} else {
									k += prdOut % 100;
								}
							}
						} else {
							if (j + (prdOrder % 10) == prdOrder) {
								j += (prdOrder % 10);
							}
							System.out.println("ㅁprocessInf 생산량");
							voPI.setPrsOutPut(j);
							mapper.upCountProcessInf(voPI);
						}

						if (j == prdOrder || j + (prdOrder % 10) == prdOrder) {
							System.out.println("ㅁprocessInf 중단시간");
							voPI.setPrsPfNo(prspfnoList.get(i));
							mapper.endProcessInf(voPI);
							System.out.println("ㅁ설비중지");
							mapper.updateEqm(voEqm);
						}
						
						k = prdOut * 1 / 100;

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

	@Override
	public CodeVO matOrdNo() {
		// TODO Auto-generated method stub
		return mapper.matOrdNo();
	}

	@Override
	public int insertMatChk(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertMatChk(vo);
	}
	
	
	// 자재 자동화
	@Override
	public int orderNow(List<CodeVO> list) {
		List<CodeVO> whList = new ArrayList<>();
		List<CodeVO> errList = new ArrayList<>();
		whList = mapper.WHListA();
		System.out.println("ㅁAAA");
		CodeVO voMsg = new CodeVO();
		List<CodeVO> listBom = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("ㅁbom 리스트 가져오기");
			CodeVO vo = new CodeVO();
			vo.setOrderNo(list.get(i).getOrderNo());
			vo.setPrtCode(list.get(i).getPrtCode());
			listBom = mapper.MatBomList(vo);

			for (int j = 0; j < listBom.size(); j++) {

				System.out.println("ㅁ자재발주");
				vo.setMatOrdNo(mapper.matOrdNo().getMatOrdNo());
				vo.setMatOrdQty(list.get(i).getOrderQty() * 110 / 100);
				vo.setMatCode(listBom.get(j).getMatCode());
				vo.setCpCode(mapper.getMatCompany(vo).getCpCode());
				vo.setMatPrice(listBom.get(j).getMatUnitPrc() * list.get(i).getOrderQty());
				vo.setMatOrdEmp("admin");
				mapper.insertMatBuy(vo);

				System.out.println("ㅁ자재검수");
				vo.setMatChkCode(mapper.getMatChkNo().getMatChkCode());
				vo.setMatInQty(list.get(i).getOrderQty() * 110 / 100);
				vo.setMatErrQty(vo.getMatInQty() * 5 / 100);
				vo.setMatPassQty(vo.getMatInQty() - vo.getMatErrQty());
				mapper.insertMatChk(vo);

				System.out.println("ㅁ자재불량코드 찾기");
				errList = mapper.selectMatErr(vo);

				System.out.println("ㅁ자재불량 테이블 인서트");
				int u = (int) Math.random() * errList.size();
				vo.setErrCode(errList.get(u).getErrCode());
				mapper.insertMatErr(vo);

				System.out.println("ㅁ자재진행여부");
				mapper.updateMatYN(vo);

				System.out.println("ㅁlot등록");
				vo.setLotNo(mapper.getLotNo().getLotNo());
				vo.setMpCode(vo.getMatCode());
				vo.setOutFrom("대기");
				vo.setLotQty(vo.getMatPassQty());
				int q = (int) Math.random() * whList.size();
				vo.setWhCode(whList.get(q).getWhCode());
				mapper.insertLotA(vo);

				System.out.println("ㅁ주문YN");
				vo.setOrderNo(list.get(i).getOrderNo());
				mapper.orderInfYN(vo);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println("ㅁbom 리스트 가져오기");
			CodeVO vo = new CodeVO();
			vo.setOrderNo(list.get(i).getOrderNo());
			vo.setPrtCode(list.get(i).getPrtCode());
			listBom = mapper.MatBomListCount(vo);
		}
		
		CodeVO vo = new CodeVO();
		
		List<String> listMat = new ArrayList<>();
		
		for (int j = 0; j < listBom.size(); j++) {
			vo.setMatCode(listBom.get(j).getMatCode());
			listMat.add(vo.getMatCode());
		}
		
		int countMat = listMat.size();
		
		voMsg.setMsg("자재발주 완료 : 총" + countMat + " 종류");
		mapper.insertMsg(voMsg);
		voMsg.setMsg("자재검수 완료 : 총" + countMat + " 종류");
		mapper.insertMsg(voMsg);
		voMsg.setMsg("자재불량 등록 완료 : 총" + countMat + " 종류");
		mapper.insertMsg(voMsg);
		voMsg.setMsg("자재창고 입고 완료 : 총" + countMat + " 종류");
		mapper.insertMsg(voMsg);
		
		return 0;
	}

	@Override
	public int orderInfYN(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.orderInfYN(vo);
	}

	@Override
	public CodeVO getMatCompany(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.getMatCompany(vo);
	}

	@Override
	public int updateMatYN(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateMatYN(vo);
	}

	@Override
	public int updateLotQty(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateLotQty(vo);
	}

	@Override
	public CodeVO getLotNo() {
		// TODO Auto-generated method stub
		return mapper.getLotNo();
	}

	@Override
	public int insertLotA(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertLotA(vo);
	}

	@Override
	public int updateProducePrePrg(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateProducePrePrg(vo);
	}

	@Override
	public List<CodeVO> msgUp() {
		return mapper.msgUp();
	}

	@Override
	public CodeVO msgCount() {
		// TODO Auto-generated method stub
		return mapper.msgCount();
	}

	@Override
	public int deleteMsg() {
		// TODO Auto-generated method stub
		return mapper.deleteMsg();
	}

	@Override
	public int readMsg(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.readMsg(vo);
	}

	@Override
	public List<CodeVO> msgUpA() {
		// TODO Auto-generated method stub
		return mapper.msgUpA();
	}

	@Override
	public int deleteOneMsg(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteOneMsg(vo);
	}

	@Override
	public CodeVO selectMPCode(CodeVO vo) {
		// TODO Auto-generated method stub
		return mapper.selectMPCode(vo);
	}

}
