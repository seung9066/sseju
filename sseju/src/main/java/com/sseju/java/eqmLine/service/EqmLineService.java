package com.sseju.java.eqmLine.service;

import java.util.List;


public interface EqmLineService {

		
		// 라인 정보 전체조회
		public List<EqmLineVO> getEqmLineList();
		
		// 라인정보 등록
		public int insertEqmLine(EqmLineVO eqmLineVO);
		
		// 라인정보 수정
		public int updateEqmLine(EqmLineVO eqmLineVO);
		
		
		// 라인정보 삭제
		public int deleteEqmLine(String lineNo);

	}



