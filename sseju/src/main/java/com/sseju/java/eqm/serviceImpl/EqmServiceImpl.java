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
		return eqmMapper.getEqmList();
	}

	@Override
	public int insertEqmInfo(EqmVO eqmVO) {
		return eqmMapper.insertEqm(eqmVO);
	}

}
