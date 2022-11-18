package com.sseju.java.eqm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.eqm.mapper.EqmMapper;
import com.sseju.java.eqm.service.EqmService;
import com.sseju.java.eqm.service.EqmVO;

@Service
public class EqmServiceImpl implements EqmService {

	@Autowired
	EqmMapper eqmMapper;

	@Override
	public List<EqmVO> selectEqmList() {
		return eqmMapper.selectEqmList();
	}

	@Override
	public int insertEqmInfo(EqmVO eqmVO) {
		return eqmMapper.insertEqmInfo(eqmVO);
	}

	@Override
	public int updateEqmInfo(EqmVO eqmVO) {
		return eqmMapper.updateEqmInfo(eqmVO);
	}

	@Override
	public int deleteEqmInfo(EqmVO eqmVO) {
		return eqmMapper.deleteEqmInfo(eqmVO);
	}

	@Override
	public List<EqmVO> getEqmLineList() {
		return eqmMapper.getEqmLineList();
	}

	@Override
	public int insertEqmLine(EqmVO eqmVO) {
		return eqmMapper.insertEqmLine(eqmVO);
	}

	@Override
	public int updateEqmLine(EqmVO eqmVO) {
		return eqmMapper.updateEqmLine(eqmVO);
	}

	@Override
	public int deleteEqmLine(String lineNo) {
		return eqmMapper.deleteEqmLine(lineNo);
	}

	@Override
	public List<EqmVO> getEqmChkList() {
		// TODO Auto-generated method stub
		return eqmMapper.getEqmChkList();
	}

	@Override
	public int insertEqmChk(EqmVO eqmVO) {
		// TODO Auto-generated method stub
		return eqmMapper.insertEqmChk(eqmVO);
	}

	@Override
	public int updateEqmChk(EqmVO eqmVO) {
		// TODO Auto-generated method stub
		return eqmMapper.updateEqmChk(eqmVO);
	}

	@Override
	public int deleteEqmChk(EqmVO eqmVO) {
		// TODO Auto-generated method stub
		return eqmMapper.deleteEqmChk(eqmVO);
	}

}