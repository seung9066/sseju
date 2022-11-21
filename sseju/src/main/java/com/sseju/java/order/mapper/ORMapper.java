package com.sseju.java.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sseju.java.order.service.ORVO;

@Mapper
public interface ORMapper {
	// 전체
	public List<ORVO> selectOrderList();
	public List<ORVO> selectOrdeIng();
	public List<ORVO> selectPrtManager();
	

	// 단건
	public ORVO selectOrderInfo(ORVO Ovo);

	// 등록
	public int insertOrderInfo(ORVO Ovo);
	public int insertOrderPrtInfo(ORVO Ovo);

	

	// 수정
	public int updateOrderPrt(ORVO Ovo);
	//삭제
	public int delectOrderPrt(ORVO Ovo);
	// 삭제
}
