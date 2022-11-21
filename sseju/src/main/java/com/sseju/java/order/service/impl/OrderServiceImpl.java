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
	public int insertOrderInfo(ORVO Ovo) {
		return OMapper.insertOrderInfo(Ovo);
	}

	@Override
	public int getOrderNo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ORVO> selectOrdeIng() {
		// TODO Auto-generated method stub
		return OMapper.selectOrdeIng();
	}

	@Override
	public List<ORVO> updateOrdeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ORVO> selectPrtManager() {
		return OMapper.selectPrtManager();
	}

	@Override
	public int insertOrderPrtInfo(ORVO Ovo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOrderPrt(ORVO Ovo) {
		// TODO Auto-generated method stub
		return OMapper.updateOrderPrt(Ovo);
	}

	@Override
	public int delectOrderPrt(ORVO Ovo) {
		// TODO Auto-generated method stub
		return OMapper.delectOrderPrt(Ovo);
	}




}
