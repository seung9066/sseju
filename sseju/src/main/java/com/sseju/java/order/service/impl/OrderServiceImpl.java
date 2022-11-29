package com.sseju.java.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.order.mapper.ORMapper;
import com.sseju.java.order.service.ORService;
import com.sseju.java.order.service.ORVO;

@Service
public class OrderServiceImpl implements ORService {

	@Autowired
	ORMapper OMapper;

	@Override
	public List<ORVO> selectOrderList() {
		return OMapper.selectOrderList();
	}

	@Override
	public ORVO selectOrderInfo(ORVO Ovo) {
		return OMapper.selectOrderInfo(Ovo);
	}

	@Override
	public int insertOrder(ORVO Ovo) {
		return OMapper.insertOrder(Ovo);
	}

	@Override
	public List<ORVO> selectOrdeIng() {
		return OMapper.selectOrdeIng();
	}

	@Override
	public List<ORVO> selectPrtManager() {
		return OMapper.selectPrtManager();
	}

	@Override
	public int insertOrderAll(ORVO Ovo) {
		return OMapper.insertOrderAll(Ovo);
	}

	@Override
	public List<ORVO> selectOrder() {
		return OMapper.selectOrder();
	}

	@Override
	public int insertOrderInfo(ORVO vo) {
		return OMapper.insertOrderInfo(vo);
	}

	@Override
	public ORVO getOrderNo() {
		return OMapper.getOrderNo();
	}

	@Override
	public List<ORVO> select() {
		return OMapper.select();
	}

	@Override
	public List<ORVO> select1() {
		return OMapper.select1();
	}

	@Override
	public int updateOrderNy(ORVO vo) {
		return OMapper.updateOrderNy(vo);
	}

	@Override
	public List<ORVO> select2(ORVO vo) {
		// TODO Auto-generated method stub
		return OMapper.select2(vo);
	}

	@Override
	public List<ORVO> selectA() {
		// TODO Auto-generated method stub
		return OMapper.selectA();
	}

	@Override
	public int updateOrderWK(ORVO vo) {
		// TODO Auto-generated method stub
		return OMapper.updateOrderWK(vo);
	}

	@Override
	public List<ORVO> selectB() {
		// TODO Auto-generated method stub
		return OMapper.selectB();
	}

	@Override
	public int updateLot(ORVO vo) {
		// TODO Auto-generated method stub
		return OMapper.updateLot(vo);
	}

}
