package com.sseju.java.prt.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PRService {

	// 전체
	public List<PRVO> selectPrtList();

	// 단건
	public PRVO selectPrtInfo(PRVO Pvo);

	// 등록
	public int insertPrtInfo(PRVO Pvo);
	
	//수정
	public int updatePrtinfo(PRVO Pvo);
}
