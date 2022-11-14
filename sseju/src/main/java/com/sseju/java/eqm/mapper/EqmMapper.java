package com.sseju.java.eqm.mapper;

import java.util.List;

import com.sseju.java.eqm.service.EqmVO;

public interface EqmMapper {

		// 설비 전체조회
		public List<EqmVO> getEqmList();
		
		// 설비 등록
		public int insertEqm(EqmVO eqmVO);
}
