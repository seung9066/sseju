package com.sseju.java.eqm.service;

import java.util.List;

public interface EqmService {
	// 설비 전체조회
	public List<EqmVO> selectEqmList();
	
	// 설비 등록
	public int insertEqmInfo(EqmVO eqmVO);

}
