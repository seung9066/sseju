package com.sseju.java.processcheck.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.processcheck.mapper.ProcessCheckMapper;
import com.sseju.java.processcheck.service.ProcessCheckService;
import com.sseju.java.processcheck.service.ProcessCheckVO;
@Service
public class ProcessCheckServiceImpl implements ProcessCheckService {
//	매퍼어노테이션
	@Autowired
	ProcessCheckMapper pcMapper;
	//공정 검사 페이지 그리드 데이터 불러오기
	@Override
	public List<ProcessCheckVO> getProcessCheck() {
		return pcMapper.getProcessCheck();
	}
	//
	@Override
	public List<Map<String, Object>> clickDate(ProcessCheckVO pcVO) {
		return pcMapper.clickDate(pcVO);
	}

}
