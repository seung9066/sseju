package com.sseju.java.workhistory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.workhistory.mapper.WorkHistoryMapper;
import com.sseju.java.workhistory.service.WorkHistoryService;
import com.sseju.java.workhistory.service.WorkHistoryVO;


@Service
public class WorkHistoryServiceImpl implements WorkHistoryService {
	
	@Autowired
	WorkHistoryMapper whMapper;
	@Override
	public List<WorkHistoryVO> getWrokHistoryList() {
		return whMapper.getWrokHistoryList();
	}

}
