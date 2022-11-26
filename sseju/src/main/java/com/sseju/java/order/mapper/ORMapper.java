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
	public List<ORVO> selectOrder();
	public List<ORVO> select();
	public List<ORVO> select1();

	// 단건
	public ORVO selectOrderInfo(ORVO Ovo);
	// 등록
	public int insertOrder(ORVO Ovo);
	public int insertOrderAll(ORVO Ovo);
	public int insertOrderInfo(ORVO vo);
	public ORVO getOrderNo();

}
