package com.sseju.java.prtprog.service;

import java.util.List;

public interface PrtProgService {
	//C 생산 진행 현황 등록
	public int insertPrtProg(PrtProgVO pprVO);
	//R 생산 진행 현황 전체 조회
	public List<PrtProgVO> getPrtProgList();
	
	//D생산 진행 현황 삭제
	public int deletePrtProg(PrtProgVO pprVO);
}
