package com.sseju.java.matinputhistory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.matinputhistory.mapper.MatInputHistoryMapper;
import com.sseju.java.matinputhistory.service.MatInputHistoryService;
import com.sseju.java.matinputhistory.service.MatInputHistoryVO;

@Service
public class MatInputHistoryServiceImpl implements MatInputHistoryService {
	@Autowired
	MatInputHistoryMapper mihMapper;
	@Override
	public int insertMatInputHistory(MatInputHistoryVO mihVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MatInputHistoryVO> getMatInputHistory() {
		// TODO Auto-generated method stub
		return mihMapper.getMatInputHistory();
	}

	@Override
	public int deleteMatInputHistory(MatInputHistoryVO mihVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
