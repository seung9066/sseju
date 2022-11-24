package com.sseju.java.prt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sseju.java.order.service.ORVO;
import com.sseju.java.prt.service.PRVO;

@Mapper
public interface PRMapper {

	// 제품목록 조회
	public List<PRVO> selectPrtList();

	// 주문상세 목록 조회
	public List<ORVO> selectPrtInfoList();
	public List<ORVO> selectPrtList2();

	
	// 단건
	public PRVO selectPrtInfo(PRVO Ovo);

	// 등록
	public int insertPrtInfo(PRVO Pvo);

	//삭제
	public int deletePrinfo(PRVO Ovo);
}
