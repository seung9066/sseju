package com.sseju.java.prt.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PrtService {

	// 전체
	public List<PrtVO> selectPrtList();

	// 단건
	public PrtVO selectPrtInfo(PrtVO Ovo);

	// 등록
	public int insertPrtInfo(PrtVO Ovo);

	
}
