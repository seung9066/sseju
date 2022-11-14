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
	@Override
	public List<WorkOrderVO> getWorkOrderList() {
		return woMapper.getWorkOrderList();
	}

	@Override
	public WorkOrderVO getSearchWorkOrder() {
		return woMapper.getSearchWorkOrder();
	}

	@Override
	public Map<String, Object> insertWorkOrder(WorkOrderVO woVO) {
		int count = woMapper.insertWorkOrder(woVO);
		return getResult(count, woVO);
	}
	

	@Override
	public Map<String, Object> updateWorkOrder(WorkOrderVO woVO) {
		int count = woMapper.updateWorkOrder(woVO);
		return getResult(count, woVO);
	}

	@Override
	public Map<String, Object> deleteWorkOrder(WorkOrderVO woVO) {
		int count = woMapper.deleteWorkOrder(getWoNo());
		return getResult(count, woVO);
	}

	@Override
	public int getWoNo() {
		return woMapper.getWoNo().getPreNo();
	}
	
	public Map<String, Object> getResult(int count, WorkOrderVO woVO){
		Map<String, Object> result = new HashMap<>();
		result.put("result", count);
		result.put("data", woVO);
		return result;
	}
}
