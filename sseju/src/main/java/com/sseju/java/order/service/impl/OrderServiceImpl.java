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
	public int updateOrderInfo(ORVO Ovo) {
		return OMapper.updateOrderInfo(Ovo);
	}

	@Override
	public int deleteOrderInfo(ORVO Ovo) {
		return OMapper.deleteOrderInfo(Ovo);
	}

}
