package com.sseju.java.prtper.mapper;

import java.util.List;

import com.sseju.java.prtper.service.PrtPerVO;

public interface PrtPerMapper {
	//생산 실적 등록
	public int insertPrtPer(PrtPerVO ppVO);
	//생산 실적 전체조회
	public List<PrtPerVO> getPrtPerList();
	//생산 실적단건조회
	public PrtPerVO SelectPrtPer();
	//생산 실적 수정(필요유무 판단해야함)
	public int updatePrtPer(PrtPerVO ppVO);
	//생산 실적 삭제(실적은 지우면 안되므로 만들지 말지 회의후 결정)
	public int deletePrtPer(PrtPerVO ppVO);
}
