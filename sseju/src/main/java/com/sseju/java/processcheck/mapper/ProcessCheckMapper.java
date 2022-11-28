package com.sseju.java.processcheck.mapper;

import java.util.List;
import java.util.Map;

import com.sseju.java.processcheck.service.ProcessCheckVO;

public interface ProcessCheckMapper {
	//R : 공정 검사 페이지 리스트 가져오기
	public List<ProcessCheckVO> getProcessCheck();
	//신청일 클릭시 조회 이벤트
	public List<Map<String, Object>> clickDate(ProcessCheckVO pcVO);
}
