package com.sseju.java.matinputhistory.mapper;

import java.util.List;

import com.sseju.java.matinputhistory.service.MatInputHistoryVO;

public interface MatInputHistoryMapper {
	//자재 투입 내역 확인 페이지 CRUD
	
	//C 자재 투입 내역 등록
	public int insertMatInputHistory(MatInputHistoryVO mihVO);
	
	//R 자재 투입 내역 페이지 리스트 전체 조회
	public List<MatInputHistoryVO> getMatInputHistory();
	
	//U 자재 투입 내역 수정, 내역 수정은 필요없으므로 제외
	
	//D자재 투입 내역 삭제, 투입내역을 지워도 되는지 판단하여 사용결정
	public int deleteMatInputHistory(MatInputHistoryVO mihVO);
}
