package com.sseju.java.order.service;

import java.util.List;


public interface ORService {
	
	// 전체
	public List<ORVO> selectOrderList();

	// 단건
	public ORVO selectOrderInfo(ORVO Ovo);

	// 등록
	public int insertOrderInfo(ORVO Ovo);

	// 수정
	public int updateOrderInfo(ORVO Ovo);

	// 삭제
	public int deleteOrderInfo(ORVO Ovo);
}
