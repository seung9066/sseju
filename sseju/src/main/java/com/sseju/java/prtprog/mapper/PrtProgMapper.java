package com.sseju.java.prtprog.mapper;

import java.util.List;


import com.sseju.java.prtprog.service.PrtProgVO;


public interface PrtProgMapper {
	//C 생산 진행 현황 등록
	public int insertPrtProg(PrtProgVO pprVO);
	//R 생산 진행 현황 전체 조회
	public List<PrtProgVO> getPrtProgList();
	
	//생상 진행 현황 단건 조회(작업 지시 번호를 받아서 조회)
	
	//U
	
	//D생산 진행 현황 삭제
	public int deletePrtProg(PrtProgVO pprVO);
}
