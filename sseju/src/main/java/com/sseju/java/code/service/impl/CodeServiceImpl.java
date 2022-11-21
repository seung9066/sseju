package com.sseju.java.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.code.mapper.CodeMapper;
import com.sseju.java.code.service.CodeService;
import com.sseju.java.code.service.CodeVO;
import com.sseju.java.employee.service.EmployeeVO;

@Service
public class CodeServiceImpl implements CodeService {
	
	@Autowired
	CodeMapper mapper;
	
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

}
