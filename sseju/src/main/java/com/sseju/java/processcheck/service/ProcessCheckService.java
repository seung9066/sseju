package com.sseju.java.processcheck.service;

import java.util.List;

public interface ProcessCheckService {
	//R : 공정 검사 페이지 리스트 가져오기
	public List<ProcessCheckVO> getProcessCheck();
}
