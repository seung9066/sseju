package com.sseju.java.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ORService {

	// 전체
	public List<ORVO> selectOrderList();
	public List<ORVO> selectPrtManager();
	public List<ORVO> selectOrdeIng();
	public List<ORVO> selectOrder();
	// 단건
	public ORVO selectOrderInfo(ORVO Ovo);
	// 등록
	public int insertOrder(ORVO Ovo);
	public int insertOrderAll(ORVO Ovo);
	public int insertOrderInfo(ORVO vo);
	public ORVO getOrderNo();
}
