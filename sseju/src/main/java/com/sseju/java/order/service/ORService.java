package com.sseju.java.order.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface ORService {

	// 전체
	public List<ORVO> selectOrderList();

	public List<ORVO> selectPrtManager();

	public List<ORVO> selectOrdeIng();

	public List<ORVO> selectOrder();

	public List<ORVO> select();

	public List<ORVO> select1();

	public List<ORVO> select2(ORVO vo);

	public List<ORVO> selectA();

	public List<ORVO> selectB();

	// 단건
	public ORVO selectOrderInfo(ORVO Ovo);

	// 등록
	public int insertOrder(ORVO Ovo);

	public int insertOrderAll(ORVO Ovo);

	public int insertOrderInfo(ORVO vo);

//	public int insertOut(ORVO vo);
	public int insertOrder(List<ORVO> list);

	// 수정
	public int updateOrderNy(List<ORVO> Ovo);

	public int updateOrderWK(List<ORVO> Ovo);

	public int updateOrderNy(ORVO vo);

	public int updateOrderWK(ORVO vo);

	public int updateLot(ORVO vo);
	public int updateOut(ORVO vo);

	public int updateDel(ORVO vo);

	public int updateDelOut(ORVO vo);

	public ORVO getOrderNo();

}
