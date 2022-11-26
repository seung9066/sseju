package com.sseju.java.workhistory.mapper;

import java.util.List;

import com.sseju.java.workhistory.service.WorkHistoryVO;

public interface WorkHistoryMapper {
	
	//작업 이력 조회 매퍼 crud
	//c 작업 이력 등록
	public int insertWorkHistory(WorkHistoryVO whVO);
	//R 작업 이력 띄우기
	public List<WorkHistoryVO> getWrokHistoryList();
	//u
	
	//d

}
