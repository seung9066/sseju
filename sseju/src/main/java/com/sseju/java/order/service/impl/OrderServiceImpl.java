package com.sseju.java.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.code.mapper.CodeMapper;
import com.sseju.java.code.service.CodeVO;
import com.sseju.java.order.mapper.ORMapper;
import com.sseju.java.order.service.ORService;
import com.sseju.java.order.service.ORVO;

@Service
public class OrderServiceImpl implements ORService {

	@Autowired
	ORMapper OMapper;
	
	@Autowired
	CodeMapper CMapper;
	
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

	@Override
	public int updateDel(ORVO vo) {
		return OMapper.updateDel(vo);
	}

	public int insertOrder(List<ORVO> list) {
		CodeVO voMsg = new CodeVO();
		voMsg.setMsg("새로운 주문이 있습니다");
		CMapper.insertMsg(voMsg);
		
		int a = 0;
		a += OMapper.insertOrder(list.get(0));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			a += OMapper.insertOrderInfo(list.get(i));
		}
		return a;
	}

	public int updateOrderNy(List<ORVO> Ovo) {
		int a = 0;
		System.out.println("aaaaaaa");
		System.out.println(Ovo);
		ORVO vo = new ORVO();
		for (int i = 0; i < Ovo.size(); i++) {
			vo.setOrderNo(Ovo.get(i).getOrderNo());
			vo.setPrtCode(Ovo.get(i).getPrtCode());
			a += OMapper.updateOrderNy(vo);
		}
		return a;
	}

	@Override
	public int updateOrderWK(List<ORVO> Ovo) {
		int a = 0;
		System.out.println("aaaaaaa");
		System.out.println(Ovo);
		ORVO vo = new ORVO();
		for (int i = 0; i < Ovo.size(); i++) {
			vo.setOrderNo(Ovo.get(i).getOrderNo());
			vo.setPrtCode(Ovo.get(i).getPrtCode());
			a += OMapper.updateOrderWK(vo);
			OMapper.updateLot(vo);
			OMapper.updateDel(vo);
			OMapper.updateDelOut(vo);
		}
		return a;
	}

	@Override
	public int updateDelOut(ORVO vo) {

		return OMapper.updateDelOut(vo);
	}
	@Override
	public int updateOut(ORVO vo) {
		
		return OMapper.updateOut(vo);
	}

//	@Override
//	public int insertOut(ORVO ovo) {
//		OMapper.insertOut(ovo);
//		OMapper.updateOrderWK(ovo);
//		return OMapper.updateLot(ovo);
//	}

}
