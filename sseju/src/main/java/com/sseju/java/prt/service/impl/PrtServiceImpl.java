package com.sseju.java.prt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.order.service.ORVO;
import com.sseju.java.prt.mapper.PRMapper;
import com.sseju.java.prt.service.PRService;
import com.sseju.java.prt.service.PRVO;

@Service
public class PrtServiceImpl implements PRService {

	@Autowired
	PRMapper pmapper;

	// 제품목록 조회
	@Override
	public List<PRVO> selectPrtList() {
		return pmapper.selectPrtList();
	}

	// 주문상세 목록 조회
	@Override
	public List<ORVO> selectPrtInfoList() {
		return pmapper.selectPrtInfoList();
	}

	@Override
	public int insertPrtInfo(PRVO Pvo) {
		return pmapper.insertPrtInfo(Pvo);
	}

	@Override
	public int updatePrtinfo(PRVO Pvo) {
		return 0;
	}

	@Override
	public List<ORVO> selectPrtList2() {
		return pmapper.selectPrtList2();
	}

}
