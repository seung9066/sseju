package com.sseju.java.code.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sseju.java.employee.service.EmployeeVO;

@Service
public interface CodeService {

	public List<CodeVO> getCodeList();
	public CodeVO getCodeInfo(CodeVO vo);
	public int insertCode(CodeVO vo);
	public int updateCode(CodeVO vo);
	public int deleteCode(CodeVO vo);
	public int selectDelete(List<String> list);
	public List<CodeVO> msgUp();
	public List<CodeVO> msgUpA();
	public CodeVO msgCount();
	public int deleteMsg();
	public int readMsg(CodeVO vo);
	public int deleteOneMsg(CodeVO vo);
	
	public CodeVO selectMPCode(CodeVO vo);
	
	// bom
	public List<CodeVO> getBomList(CodeVO vo);
	public List<CodeVO> getBomMenu();
	public List<CodeVO> getBOMMatList();
	public CodeVO getPrtCode(CodeVO vo);
	public CodeVO getMatCode(CodeVO vo);
	public int insertBOM(CodeVO vo);
	public List<CodeVO> getBOMPrtList();
	public int deleteBOM(CodeVO vo);
	
	// employee
	public List<EmployeeVO> getDept();
	
	// warehouse
	public int deleteWh(CodeVO vo);
	
	public int insertMat(CodeVO vo);
	public int insertPrd(CodeVO vo);
	
	public List<CodeVO> getPrtList();
	public List<CodeVO> getMatList();
	public List<CodeVO> getMatList1();
	public int selectDeleteP(CodeVO vo);
	public int selectDeleteM(CodeVO vo);
	
	public List<CodeVO> prList();
	public int insertPrs(CodeVO vo);
	public int deletePrs(CodeVO vo);
	
	public List<CodeVO> eqmList();
	public List<CodeVO> whList();
	public int insertWh(CodeVO vo);
	public int updatePrs(CodeVO vo);
	public int updateWh(CodeVO vo);
	
	public List<CodeVO> errList();
	public List<CodeVO> matprsList();
	public int insertErr(CodeVO vo);
	public int deleteErr(CodeVO vo);
	public int updateErr(CodeVO vo);
	
	// worker
	public List<CodeVO> workerList();
	
	public int deleteEqm(CodeVO vo);
	public List<CodeVO> workerAList(CodeVO vo);
	public List<CodeVO> workerBList(CodeVO vo);
	public int insertEmpMng(CodeVO vo);
	public int insertWM(CodeVO vo);
	public int deleteWM(CodeVO vo);
	
	public List<CodeVO> MatBomList(CodeVO vo);
	public int insertMatBuy(CodeVO vo);
	public CodeVO matOrdNo();
	public int insertMatChk(CodeVO vo);
	public int orderInfYN(CodeVO vo);
	public CodeVO getMatCompany(CodeVO vo);
	public int updateMatYN(CodeVO vo);
	
	// main
	public CodeVO updatePrtCount();
	public CodeVO ydPrtCount();
	public CodeVO updatePrtOutCount();
	public CodeVO updateErrCount();
	public List<CodeVO> WhPrd(CodeVO vo);
	public List<CodeVO> updatePrttCount();
	public CodeVO ydPrtOutCount();
	public CodeVO ydErrCount();
	public List<CodeVO> selectPrtNameOut();
	public List<CodeVO> selectErrOut();
	public List<CodeVO> selectPrsName();
	public List<CodeVO> selectPrsRunNow();
	public List<CodeVO> todayWL();
	public List<CodeVO> todayWLinf(CodeVO vo);
	public List<CodeVO> prdCount();
	
	// Thread
	public void startThread(CodeVO vo);
	
	public List<CodeVO> getBomListC(CodeVO vo);
	public CodeVO getLotMat(CodeVO vo);
	public int insertMatOut(CodeVO vo);
	public int useLotQty(CodeVO vo);
	public CodeVO getMatPrs(CodeVO vo);
	public CodeVO matOutNo();
	public CodeVO prsNo();
	public int insertProcessRun(CodeVO vo);
	public CodeVO prfNo();
	public int insertProcessInf(CodeVO vo);
	public List<CodeVO> getError(CodeVO vo);
	public CodeVO processErrNo();
	public int insertProcessErr(CodeVO vo);
	public int upCountProcessInf(CodeVO vo);
	public int upCountProcessErr(CodeVO vo);
	public int upCountPIErr(CodeVO vo);
	public int endProcessInf(CodeVO vo);
	public int endProcessRun(CodeVO vo);
	public int insertLot(CodeVO vo);
	public List<CodeVO> WHListA();
	public int updateEqm(CodeVO vo);
	public int updateLotQty(CodeVO vo);
	public CodeVO getLotNo();
	public int insertLotA(CodeVO vo);
	public int updateProducePrePrg(CodeVO vo);
	
	public int selectDeleteCP(List<String> vo);
	public int insertBOM(List<String> nameList, List<String> capList, List<String> matList);
	public int updateBOM(List<String> mat, List<String> cap, List<String> prtName);
	public String insertP(CodeVO vo);
	public int selectDeletePM(List<String> prt, List<String> mat);
	public String insertPrsA(CodeVO vo);
	public int selectDeletePW(List<String> prt, List<String> mat);
	public String insertWhA(CodeVO vo);
	public String insertErrA(CodeVO vo);
	public int updateErrA(CodeVO vo);
	public Map<String, String> updateWorker(List<String> preNo, List<String> inputId, List<String> deleteId);
	public Map<String, String> updatePrtCountA();
	public Map<String, String> updatePrtOutCountA();
	public Map<String, String> updateErrCountA();
	
	public int orderNow(List<CodeVO> list);
}
