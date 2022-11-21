package com.sseju.java.code.service;

import java.util.List;

import com.sseju.java.employee.service.EmployeeVO;

public interface CodeService {

	public List<CodeVO> getCodeList();
	public CodeVO getCodeInfo(CodeVO vo);
	public int insertCode(CodeVO vo);
	public int updateCode(CodeVO vo);
	public int deleteCode(CodeVO vo);
	public int selectDelete(List<String> list);
	
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
	
	// main
	public CodeVO updatePrtCount();
}
