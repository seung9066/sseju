package com.sseju.java.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ORService {
	// orders테이블
	public int getOrderNo();

	// 전체
	public List<ORVO> selectOrderList();

	public List<ORVO> updateOrdeInfo();

	public List<ORVO> selectPrtManager();

	// 단건
	public ORVO selectOrderInfo(ORVO Ovo);

	// 등록
	public int insertOrderInfo(ORVO Ovo);

	public int insertOrderPrtInfo(ORVO Ovo);

	// 수정


	public List<ORVO> selectOrdeIng();

}
