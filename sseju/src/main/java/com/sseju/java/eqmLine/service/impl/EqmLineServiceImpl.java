package com.sseju.java.eqmLine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.eqmLine.mapper.EqmLineMapper;
import com.sseju.java.eqmLine.service.EqmLineService;
import com.sseju.java.eqmLine.service.EqmLineVO;

@Service
public class EqmLineServiceImpl implements EqmLineService {
	
	@Autowired
	EqmLineMapper eqmLineMapper;

	@Override
	public List<EqmLineVO> getEqmLineList() {
		return eqmLineMapper.getEqmLineList();
	}

	@Override
	public int insertEqmLine(EqmLineVO eqmLineVO) {
		return eqmLineMapper.insertEqmLine(eqmLineVO);
	}

	@Override
	public int updateEqmLine(EqmLineVO eqmLineVO) {
		return eqmLineMapper.updateEqmLine(eqmLineVO);
	}

	@Override
	public int deleteEqmLine(String lineNo) {
		return eqmLineMapper.deleteEqmLine(lineNo);
	}

}
