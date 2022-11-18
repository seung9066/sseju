package com.sseju.java.workorder.serivce.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseju.java.workorder.mapper.WorkOrderMapper;
import com.sseju.java.workorder.serivce.WorkOrderService;
import com.sseju.java.workorder.serivce.WorkOrderVO;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {
	@Autowired
	WorkOrderMapper woMapper;
	//출력용 map 메소드 생성
	public Map<String, Object> getResult(int count, WorkOrderVO woVO) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", count);
		result.put("data", woVO);
		return result;
	}
	
	//전체조회
	@Override
	public List<WorkOrderVO> getWorkOrderList() {
		return woMapper.getWorkOrderList();
	}
	
	//단건조회
	@Override
	public WorkOrderVO getSearchWorkOrder() {
		return woMapper.getSearchWorkOrder();
	}
	
	//등록
	@Override
	public int insertWorkOrder(WorkOrderVO woVO) {
		return woMapper.insertWorkOrder(woVO);
	}

	//수정
	@Override
	public int updateWorkOrder(WorkOrderVO woVO) {
		return woMapper.updateWorkOrder(woVO);
	}
	
	//삭제()
	@Override
	public int deleteWorkOrder(WorkOrderVO woVO) {
		// TODO Auto-generated method stub
		return woMapper.deleteWorkOrder(woVO);
	}
	
	//
	@Override
	public int getWoNo() {
		return woMapper.getWoNo();
	}


}
