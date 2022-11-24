package com.sseju.java.prt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sseju.java.order.service.ORVO;

public interface PRService {

	// 제품목록 조회
	public List<PRVO> selectPrtList();
	// 주문상세 목록 조회
	public List<ORVO> selectPrtInfoList();
	public List<ORVO> selectPrtList2();
	// 등록
	public int insertPrtInfo(PRVO Pvo);
	
	//수정
	public int updatePrtinfo(PRVO Pvo);


	



}



