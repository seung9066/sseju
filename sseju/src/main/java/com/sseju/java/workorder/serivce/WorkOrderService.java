package com.sseju.java.workorder.serivce;

import java.util.List;
import java.util.Map;

public interface WorkOrderService {
	//작업 지시 전체 조회
	public List<WorkOrderVO> getWorkOrderList();
	//작업 지시 단건 조회
	public WorkOrderVO getSearchWorkOrder();
	//작업 지시 등록
	public Map<String, Object> insertWorkOrder(WorkOrderVO woVO);
	//수정
	public Map<String, Object> updateWorkOrder(WorkOrderVO woVO);
	//삭제
	public Map<String, Object> deleteWorkOrder(WorkOrderVO woVO);
	//작업지시 번호 조회
	public int getWoNo();
}
