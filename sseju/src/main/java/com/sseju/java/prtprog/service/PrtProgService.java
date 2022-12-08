package com.sseju.java.prtprog.service;

import java.util.List;

public interface PrtProgService {
	//C 생산 진행 현황 등록
	public int insertPrtProg(PrtProgVO pprVO);
	//R 생산 진행 현황 전체 조회
	public List<PrtProgVO> getPrtProgList();
	//R 생산 공정별 자재 상황 조회
	public List<PrtProgVO> progPrtCondition(PrtProgVO pprVO);
	//U 생산 진행이 완료되었을때 그리드에서 행이 사라지게
	public int updateProgYtoE(PrtProgVO pprVO);
	
	//D생산 진행 현황 삭제
	public int deletePrtProg(PrtProgVO pprVO);
}
