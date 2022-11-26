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
	public int insertOrder(ORVO Ovo){
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
		// TODO Auto-generated method stub
		return OMapper.select1();
	}

	

}
