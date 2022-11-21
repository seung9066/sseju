package com.sseju.java.prtprocess.service;

import java.util.List;

public interface PrtProcessService {
	//생산 공정 관리 전체 조회
	public List<PrtProcessVO> getPrtProcessList();
	//생산 공정 단건 조회
	public PrtProcessVO getSearchPrtProcess();
	//생산 공정 등록
	public int insertPrtProcessVO(PrtProcessVO prptVO);
	//생산 공정 수정(업데이트)
	public int updatePrtProcessVO(PrtProcessVO prptVO);
	//생산 공정 삭제
	public int deletePrtProcessVO(PrtProcessVO prptVO);
}
