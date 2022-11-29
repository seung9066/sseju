package com.sseju.java.workhistory.service;

import java.util.List;

public interface WorkHistoryService {

	//작업 이력 조회의 CRUD
	//R 작업 이력 띄우기
	public List<WorkHistoryVO> getWorkHistoryList();
	
}
